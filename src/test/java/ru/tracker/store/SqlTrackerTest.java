package ru.tracker.store;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import org.junit.jupiter.api.*;
import ru.tracker.Item;
import ru.tracker.SqlTracker;

import static org.assertj.core.api.Assertions.assertThat;

public class SqlTrackerTest {

    private static Connection connection;
    private SqlTracker tracker;
    private Item first;
    private Item second;
    private Item third;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @BeforeEach
    public void setUp() {
        tracker = new SqlTracker(connection);
        first = new Item("first");
        second = new Item("second");
        third = new Item("third");
    }

    @Test
    public void whenFindByIllegalIdThenResultIsNull() {
        assertThat(tracker.findById(first.getId())).isNull();
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        tracker.add(first);
        assertThat(tracker.findById(first.getId())).isEqualTo(first);
    }

    @Test
    public void whenReplaceItemThenPreviousIsAbsent() {
        tracker.add(first);
        tracker.add(second);
        tracker.replace(second.getId(), third);
        third.setId(second.getId());
        assertThat(tracker.findAll()).doesNotContain(second);
        assertThat(tracker.findById(second.getId())).isEqualTo(third);
    }

    @Test
    public void whenReplaceItemWithIllegalIdThenFalse() {
        tracker.add(first);
        tracker.add(second);
        assertThat(tracker.replace(3, third)).isFalse();

    }

    @Test
    public void whenDeleteThenTrackerDoesntContainsItem() {
        tracker.add(first);
        tracker.add(second);
        tracker.delete(first.getId());
        assertThat(tracker.findAll()).doesNotContain(first);
    }

    @Test
    public void whenDeleteWithIllegalId() {
        tracker.add(first);
        tracker.add(second);
        List<Item> expected = List.of(
                tracker.findById(first.getId()),
                tracker.findById(second.getId())
        );
        tracker.delete(3);
        assertThat(tracker.findAll()).isEqualTo(expected);
    }

    @Test
    public void whenFindByNameThenResultIsEqualToExpected() {
        tracker.add(first);
        tracker.add(second);
        List<Item> expected = List.of(
                tracker.findById(first.getId())
        );
        assertThat(tracker.findByName("first")).contains(first).isEqualTo(expected);
    }

    @Test
    public void  whenFindByIllegalNameThenResultIsEmpty() {
        assertThat(tracker.findByName("first")).isEmpty();
    }
}

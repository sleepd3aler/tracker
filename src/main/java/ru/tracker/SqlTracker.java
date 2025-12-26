package ru.tracker;

import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection connection;

    public SqlTracker() {
        try {
            init();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO items(name, creation_time) values (?, ?);",
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.execute();
            try (ResultSet generatedIds = statement.getGeneratedKeys()) {
                if (generatedIds.next()) {
                    item.setId(generatedIds.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean res;
        try (PreparedStatement statement = connection.prepareStatement(
                "UPDATE items set name = ? , creation_time = ? where id = ?;"
        )) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.setInt(3, id);
            res = statement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM items WHERE ID = ?;"
        )) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Item> findAll() {
        try (PreparedStatement statement = connection.prepareStatement(
                "select * from items;"
        )) {
            return getItems(statement);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Item> findByName(String key) {
        try (PreparedStatement statement = connection.prepareStatement(
                "select * from items where name = ?;"
        )) {
            statement.setString(1, key);
            return getItems(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Item findById(int id) {
        try (PreparedStatement statement = connection.prepareStatement(
                "select * from items where id = ?;"
        )) {
            statement.setInt(1, id);
            List<Item> items = getItems(statement);
            if (!items.isEmpty()) {
                return items.get(0);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    private void init() {
        try (InputStream input = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(input);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(config.getProperty("url"), config.getProperty("username"), config.getProperty("password"));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    private List<Item> getItems(PreparedStatement statement) throws SQLException {
        List<Item> res = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            LocalDateTime created = resultSet.getTimestamp(3).toLocalDateTime();
            Item item = new Item(id, name);
            item.setCreated(created);
            res.add(item);
        }
        return res;
    }
}

package ru.collection;
//
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Ivan Ivanov");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenTestAddCitizenWithDuplicatePassport() {
        Citizen citizen = new Citizen("2f44a", "Ivan Ivanov");
        Citizen citizen2 = new Citizen("2f44a", "Ivan Alekseyevich");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        office.add(citizen2);
        boolean result = office.add(citizen2);
        assertThat(result).isFalse();

    }
}

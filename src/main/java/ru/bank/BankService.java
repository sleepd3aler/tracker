package ru.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского сервиса
 * Сервис может добавлять/удалять пользователей, выполнять поиск пользователей по паспорту.
 * Добавлять пользователям аккаунты, выполнять поиск аккаунтов пользователей по реквизитам, и так же выдавать информацию
 * о всех аккаунтах пользователя.
 * Выполнять денежные переводы между аккаунтами пользователей
 * @author Novitskiy Alexander
 * @version 1.0
 */
public class
BankService {
    /**
     * Хранение пользователей и списка их аккаунтов осуществляется в коллекции типа Map
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в карту, если этого пользователя еще нет
     * @param user - пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод ищет пользователя в карте по паспорту, и удаляет его
     * @param passport - паспорт пользователя
     */
    public void deleteUser(String passport) {
        User delete = findByPassport(passport);
        if (delete != null) {
            users.remove(delete);
        }
    }

    /**
     * Метод добавляет аккаунт пользователю, если такого аккаунта еще нет у пользователя
     * @param passport - паспорт пользователя
     * @param account - аккаунт пользователя
     */
    public void addAccount(String passport, Account account) {
       User accountHolder = findByPassport(passport);
        if (accountHolder != null && !users.get(accountHolder).contains(account)) {
            users.get(accountHolder).add(account);
        }
    }

    /**
     * Метод позволяет получить объект пользователя, если пользователя не существует - возвращает null
     * @param passport  - паспорт пользователя
     * @return объект пользователя, или null если его нет в карте
     */
    public User findByPassport(String passport) {
        User result = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
        return result;
    }

    /**
     * Метод позволяет получить аккаунт, выполняя поиск по реквизитам, если аккаунта не существует - возвращает null
     * @param passport - паспорт пользователя
     * @param requisite - реквизиты аккаунта
     * @return - объект аккаунта или null, если его нет в карте
     */
    public Account findByRequisite(String passport, String requisite) {
        User accountHolder = findByPassport(passport);
        if (accountHolder != null) {
            for (Account account : users.get(accountHolder)) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод позволяет выполнять перевод денежных средств, в случае успеха возвращает true, в противном случае - false
     * Успешным переводом считаются случаи в которых один из пользователей и реквизитов существуют
     * @param sourcePassport - паспорт отправителя
     * @param sourceRequisite - реквизиты отправителя
     * @param destinationPassport - паспорт получателя
     * @param destinationRequisite - реквизиты получателя
     * @param amount - сумма перевода
     * @return true - при успешном случае, false - при неудачном случае
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount != null && destinationAccount != null && sourceAccount.getBalance() >= amount) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            result = true;
        }

        return result;
    }

    /**
     * Метод позволяет получить список аккаунтов пользователя
     * @param user - объект пользователя
     * @return - список аккаунтов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}

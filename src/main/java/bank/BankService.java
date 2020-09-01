package bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (!users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        for (Account account : users.get(findByPassport(passport))) {
            if (account.getRequisite().equals(requisite)) {
                rsl = account;
                break;
            }
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        if (findByRequisite(srcPassport, srcRequisite) != null && findByRequisite(destPassport, destRequisite) != null && findByRequisite(srcPassport, srcRequisite).getBalance() >= amount) {
            findByRequisite(srcPassport, srcRequisite).setBalance(findByRequisite(srcPassport, srcRequisite).getBalance() - amount);
            findByRequisite(destPassport, destRequisite).setBalance(findByRequisite(destPassport, destRequisite).getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
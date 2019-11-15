package pl.sdacademy.payments;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository {

    private final List<Account> accounts = new ArrayList<>();

    public void addAccount(final Account account) {
        account.setAmount(0L);
        accounts.add(account);
    }

    public void removeAccount(final Long id) {
        accounts.stream()
                .filter(account -> account.getId().equals(id))
                .findFirst().ifPresent(accounts::remove);
    }

    public List<Account> getAll() {
        return accounts;
    }
}

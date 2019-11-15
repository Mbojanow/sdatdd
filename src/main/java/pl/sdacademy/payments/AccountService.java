package pl.sdacademy.payments;

import java.util.Comparator;
import java.util.Optional;

public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountVerifier accountVerifier;

    public AccountService(final AccountRepository accountRepository, final AccountVerifier accountVerifier) {
        this.accountRepository = accountRepository;
        this.accountVerifier = accountVerifier;
    }

    public void createNewAccount(final Account account) {
        final Optional<Account> accountWithMaxId = accountRepository.getAll().stream().max(Comparator.comparing(Account::getId));
        final Long nextId = accountWithMaxId.map(Account::getId).orElse(1L);
        account.setId(nextId);
        accountVerifier.verify(account);
        accountRepository.addAccount(account);
    }

    public void removeAccount(final Long id) {
        if (accountRepository.getAll().stream().anyMatch(account -> account.getId().equals(id))) {
            accountRepository.removeAccount(id);
        } else {
            throw new AccountException("Account with given id does not exist");
        }
    }
}

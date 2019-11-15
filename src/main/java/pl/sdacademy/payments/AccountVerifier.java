package pl.sdacademy.payments;

public class AccountVerifier {

    private static final int ACCOUNT_LENGTH = 20;

    private final AccountRepository accountRepository;
    private final OwnerVerifier ownerVerifier;

    public AccountVerifier(final AccountRepository accountRepository, final OwnerVerifier ownerVerifier) {
        this.accountRepository = accountRepository;
        this.ownerVerifier = ownerVerifier;
    }

    public void verify(final Account account) {
        if (account == null) {
            throw new AccountException("Ow account is null");
        }

        if (account.getId() == null) {
            throw new AccountException("account has no id");
        }

        if (account.getNumber().length() != ACCOUNT_LENGTH) {
            throw new AccountException("Account length is incorrect");
        }

        ownerVerifier.verify(account.getOwner());

        accountRepository.getAll().stream().filter(acc -> acc.getId().equals(account.getId()))
                .findFirst().ifPresent(acc -> {throw new AccountException("duplicated id found");});
    }
}

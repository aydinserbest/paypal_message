package payments.domain.accounts;

import java.util.concurrent.atomic.AtomicLong;

public class CustomerAccount {
    private static final AtomicLong ACCOUNT_NUMBER_COUNTER = new AtomicLong(1);
    private Long accountNumber;
    private AccountType accountType;

    public CustomerAccount(AccountType accountType) {
        this.accountType = accountType;
        this.accountNumber = ACCOUNT_NUMBER_COUNTER.getAndIncrement();
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }
}

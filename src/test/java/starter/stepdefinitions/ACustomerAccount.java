package starter.stepdefinitions;

import payments.domain.accounts.AccountType;
import payments.domain.accounts.CustomerAccount;

public class ACustomerAccount {
    public static CustomerAccount ofType(AccountType accountType) {
        return new CustomerAccount(accountType);
    }
}

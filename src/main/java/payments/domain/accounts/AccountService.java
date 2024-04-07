package payments.domain.accounts;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountService {
    List<CustomerAccount> accounts=new ArrayList<>(); // <1>
    public CustomerAccount newAccountOfType(AccountType accountType) {
        CustomerAccount newAccount = new CustomerAccount(accountType);
        accounts.add(newAccount);
        return newAccount;
    }
    public Optional<CustomerAccount> findByAccountNumber(Long accountNumber) {
        return accounts.stream()
                .filter(account -> account.getAccountNumber().equals(accountNumber))
                .findFirst();
    }
}

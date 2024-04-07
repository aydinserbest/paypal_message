package payments.service;

import payments.domain.PaymentMethod;
import payments.domain.accounts.AccountService;
import payments.domain.accounts.AccountType;
import payments.domain.accounts.CustomerAccount;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PaymentService {
    private final AccountService accountService;

    public PaymentService(AccountService accountService) {
        this.accountService = accountService;
    }

    public PaymentMethod getSupportedCardPaymentsForAccount(Long accountNumber) {

        CustomerAccount account = accountService.findByAccountNumber(accountNumber).get();
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setType("CARD");
        List<String> supportedCards = Arrays.asList("VISA", "MASTERCARD");
        if (account.getAccountType() == AccountType.PREMIUM) {
            supportedCards.add("AMEX");
        }
        paymentMethod.setParameters(Map.of("allowedCardNetworks", supportedCards));
        return paymentMethod;
    }
}


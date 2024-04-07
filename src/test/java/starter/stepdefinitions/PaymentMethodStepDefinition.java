package starter.stepdefinitions;

import com.google.common.base.Splitter;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import payments.domain.PaymentMethod;
import payments.domain.accounts.AccountService;
import payments.domain.accounts.AccountType;
import payments.domain.accounts.CustomerAccount;
import payments.service.PaymentService;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentMethodStepDefinition {
    @ParameterType("Standard|Premium")
    public AccountType accountType(String value) {
        return AccountType.valueOf(value);
    }
    CustomerAccount customerAccount;
    AccountService accountService = new AccountService();

    PaymentService paymentService = new PaymentService(accountService);

    @Given("a shop owner has a {accountType} account")
    public void aShopOwnerHasAAccountTypeAccount(AccountType accountType) {
        customerAccount = accountService.newAccountOfType(accountType);
    }
    PaymentMethod supportedPaymentMethod;

    @When("the supported card payments are requested")
    public void theSupportedCardPaymentsAreRequested() {
        supportedPaymentMethod = paymentService.getSupportedCardPaymentsForAccount(customerAccount.getAccountNumber());
    }
    @ParameterType(".*")
    public List<String> cardNetworks(String value) {
        return Splitter.on(',').splitToList(value);
    }
    @Then("the allowed card networks should be {cardNetworks}")
    public void theAllowedCardNetworksShouldBeAllowedCardNetworks(List<String> expectedCardNetworks) {
        List<String> actualCardNetworks = (List<String>) supportedPaymentMethod.getParameters().get("allowedCardNetworks");
        assertThat(actualCardNetworks).containsExactlyInAnyOrderElementsOf(expectedCardNetworks);

    }

    @Given("Gavin has a Premium account")
    public void gavinHasAPremiumAccount() {
    }

    @And("Gavin has disabled credit card support")
    public void gavinHasDisabledCreditCardSupport() {
    }

    @Then("the supported card payments should include:")
    public void theSupportedCardPaymentsShouldInclude(List<Map<String, String>> supportedCardPayments) {
    }
}

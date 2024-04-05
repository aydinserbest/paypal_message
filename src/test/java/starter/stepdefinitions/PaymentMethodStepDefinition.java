package starter.stepdefinitions;

import com.google.common.base.Splitter;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import payments.domain.accounts.AccountType;

import java.util.List;
import java.util.Map;

public class PaymentMethodStepDefinition {
    @Given("a shop owner has a {word} account")
    public void aShopOwnerHasAAccountTypeAccount(AccountType accountType) {
    }

    @When("the supported card payments are requested")
    public void theSupportedCardPaymentsAreRequested() {
    }
    @ParameterType(".*")
    public List<String> cardNetworks(String value) {
        return Splitter.on(',').splitToList(value);
    }
    @Then("the allowed card networks should be {cardNetworks}")
    public void theAllowedCardNetworksShouldBeAllowedCardNetworks(List<String> allowedCardNetworks) {
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

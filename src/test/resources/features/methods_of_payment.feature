Feature: Methods of payment

  We host online stores for our clients.
  Our system supports both card and Paypal payments.The supported card networksare configurable.

  Scenario Outline: AMEX is only supported for premium customers
    Given a shop owner has a <Account Type> account
    When the supported card payments are requested
    Then the allowed card networks should be <allowedCardNetworks>

  Examples:
    | Account Type | allowedCardNetworks     |
    | Standard     | MASTERCARD, VISA        |
    | Premium      | AMEX, MASTERCARD, VISA  |

  Rule: Credit cards can be optionally disabled
    Scenario: A UK gaming client does not want to support credit cards
      Given Gavin has a Premium account
      And Gavin has disabled credit card support
      When the supported card payments are requested
      Then the supported card payments should include:

        | Property         | Value |
        | allowCreditCards | false |

Feature: Send email by reply to

  Scenario: Reply to, empty message
    Given User in on inbox page
    And User opens email from "sender@email.pl"
    When User clicks "Odpowiedz"
    Then System shows send email box
    When User click on "Wyślij" button
    Then Email is send to "sender@email.pl"

  Scenario: Reply all, empty message
    Given User in on inbox page
    And User opens email from "sender@email.pl" and "sender2@email.pl"
    When User clicks "Odpowiedz wszystkim"
    Then System shows send email box
    When User click on "Wyślij" button
    Then Email is send to "sender@email.pl"
    And Email is send to "sender2@email.pl"

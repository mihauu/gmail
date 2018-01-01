Feature: Login to gmail.com

  Background: 
    Given User is logout
    And User is on page "gmail.com"
    And User is on first step login page

  Scenario: Successfully login to account
    When User fill email "user@gmail.com"
    And User send form login step 1
    Then System redirect user to page login step 2
    When User fill password "password"
    And User send form with password
    Then System redirect user to gmail account
    And System shows user emails

  Scenario: Login to account with invalid email
    When User fill email "some_non_existing_user@gmail.com"
    And User send form login step 1
    Then System shows validation "Nie możemy znaleźć takiego konta"
    And User is on form login step 1
    And Email field is fill with "some_non_existing_user@gmail.com"

  Scenario: Login to account with valid email and invalid password
    When User fill email "user@gmail.com"
    And User send form login step 1
    Then System redirect user to page login step 2
    When User fill password "Invalidpassword"
    And User send form with password
    Then System show validation "Nieprawidlowe hasło spróbuj jescze raz"
    And User is on page login step 2
    And Password field is ""

  Scenario: Login to account with captcha
    When User fill valid email and not valid password several times
    Then System show captcha
    When User fill valid text from catcha
    And User fill valid password
    Then System redirect user to gmail account
    And System shows user emails

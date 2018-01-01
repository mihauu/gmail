Feature: Send email - BCC,CC

  Background: 
    Given	 User is login

    And User is on Inbox Page
    And User clicks on "Utwórz" button
    And System shows modal with new message
    When User fills valid receipment "receipment@email.pl"
    And User fill CC "DW" with "dw@email.pl"
    And User fill BCC "UDW" with "udw@email.pl"
    And User sends message

  Scenario Outline: Send email - BCC,CC
    Then Email is sends to <receipment>
    And User <receipment> <visibility> header <receipment2>

    Examples: 
      | receipment          | visibility | receipment2         |
      | receipment@email.pl | see        | dw@email.pl         |
      | receipment@email.pl | don\\'t    | udw@email.pl        |
      | udw@email.pl        | see        | receipment@email.pl |
      | dw@email.pl         | see        | receipment@email.pl |
      | dw@email.pl         | don\\'t    | udw@email.pl        |

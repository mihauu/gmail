Feature: Send email

  Background: 
    Given	 User is login

    And User is on Inbox Page
    And User clicks on "Utwórz" button
    And System shows modal with new message

  Scenario: Send email - empty message
    When User fills valid receipment "michal@email.pl"
    And User sends message
    Then Email is send to "michal@email.pl"
    And Email has no message
    When User click on "Wysłane"
    Then User see on "1" position email to "michal@email.pl"

  Scenario: Send email with subject
    When User fills valid receipment "michal@email.pl"
    And User fills subject with text "sample subject text"
    And User sends message
    Then Email is send to "michal@email.pl"
    And Email has subject "sample subject text"
    When User click on "Wysłane"
    And User click on "1" position email to "michal@email.pl"
    Then User see email to "michal@email.pl" with subject "sample subject text"

  Scenario: Send email with message
    When User fills valid receipment "michal@email.pl"
    And User fills message with text "sample email text"
    And User sends message
    Then Email is send to "michal@email.pl"
    And Email has message "sample email text"
    When User click on "Wysłane"
    And User click on "1" position email to "michal@email.pl"
    Then User see email to "michal@email.pl" with message "sample email text"

  Scenario Outline: Send email with attachment
    When User fills valid receipment "michal@email.pl"
    And User attachs valid <attachmentType> from <source>  <attachment>
    And User sends message
    Then Email is send to "michal@email.pl"
    And Email has attachment <attachment> in <attachmentDestination>

    Examples: 
      | source      | attachmentType | attachment | attachmentDestination |
      | MyComputer  | file           | file.pdf   | cid                   |
      | GoogleDrive | file           | file2.pdf  | cid                   |
      | MyComputer  | photo          | image.jpg  | messageBody           |

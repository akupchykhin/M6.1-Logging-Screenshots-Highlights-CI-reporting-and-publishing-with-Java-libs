Feature: Yandex mail service testing

    Scenario Outline: User login
      Given user on login page
      When user fill login with <login>
      And user fill password with <password>
      And user click on login button
      Then user is logged in
      Examples:
        | login      | password       |
        | yalogintest| yalogintest123 |


    Scenario: Scenario 1 - Create a new mail and save it as draft
      When user click on Compose button
      And fill receiver
      And fill subject
      And fill message body
      And save en email as draft


    Scenario: Scenario 2 - Verify, that the mail presents in ‘Drafts’ folder
      When user click on Compose button
      And fill receiver
      And fill subject
      And fill message body
      And save en email as draft
      Then user go to drafts folder
      And an email is saved in draft folder

    Scenario: Scenario 3 - Send the mail
      When user click on Compose button
      And fill receiver
      And fill subject
      And fill message body
      And user send the email by pressing send button
      Then message was sent notification appears

    Scenario: Scenario 4 - Verify, that the mail is in ‘Sent’ folder
      When user go to sent page
      Then an email is in sent folder


    Scenario: Scenario 5 - Log off
      When user click on logoff button
      And confirm exit
      Then user logged out successfully



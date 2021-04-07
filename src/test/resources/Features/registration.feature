Feature: Mailchimp
  Try out the registration @ https://login.mailchimp.com/signup/

  Background:
    Given user have navigated to the website

  Scenario Outline: Register user
    Given user writes an <email>
    And user writes a <username>
    And user writes a password
    When user clicks on Sign Up button
    Then user should see the text <text>
    Examples:
      | email    | username                              | text                                                                                                |
      | email    | username                              | "Check your email"                                                                                  |
      | email    | username with over hundred characters | "Enter a value less than 100 characters long" error message.                                        |
      | email    | used username                         | "Another user with this username already exists. Maybe it's your evil twin. Spooky." error message. |
      | no email | username                              | "Please enter a value" error message.                                                               |



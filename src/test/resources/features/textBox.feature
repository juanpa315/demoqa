Feature: Text Box form validation

  @HappyPath
  Scenario Outline: Successful registration of information in text box form
    Given Juan access to text box page
    When Juan registers a user
      | Full_Name   | Email   | Current_Address   | Permanent_Address   |
      | <Full_Name> | <Email> | <Current_Address> | <Permanent_Address> |
    Then Juan can see the registered user

    Examples:
      | Full_Name   | Email           | Current_Address | Permanent_Address |
      | juan osorio | juanp@gmail.com |                 | Bogotá            |
      |             | de@gmail.com    | cali            | pereira           |
      | carolaina   | de@gmail.com    | cali            | pereira           |

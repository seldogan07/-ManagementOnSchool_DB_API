@US01_DB
Feature: Prospective students should be able to register in the system

  Scenario Outline: : US01_GetGuestUser

    Given get guest user via username "<username>"
    Then body contains birth_day "<birth_day>", birth_place "<birth_place>", gender "<gender>", name "<name>", phone_number "<phone_number>", ssn "<ssn>", surname "<surname>", username "<username>"
    Examples:
      | username | birth_day  | birth_place | gender | name | phone_number | ssn         | surname |
      | john_doe | 2023-07-01 | New York    | 0      | John | 444-666-3458 | 111-66-3451 | Doe     |


  @US01_Negative
  Scenario: Admin should be able to delete information of Guest User List.
    Given get guest user via username "john_doeX"
    Then body should be empty

  @LoopExample
  Scenario: There must be at least 10 users whose birt_place is Berlin
    Given get guest user via birth_place "birth_place"
    Then there must be at least 10 users
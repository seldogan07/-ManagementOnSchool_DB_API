@US01_Api @Api
Feature: Prospective students should be able to register in the system(Api)

  Scenario Outline: US01_GetGuestUserByUsername

    Given send get request by "<username>"
    Then body should contain birth_day "<birth_day>", birth_place "<birth_place>", gender "<gender>", name "<name>", phone_number "<phone_number>", ssn "<ssn>", surname "<surname>", username "<username>"
    Examples:
      | username | birth_day  | birth_place | gender | name | phone_number | ssn         | surname |
      | john_doe | 2023-07-01 | New York    | MALE   | John | 444-666-3458 | 111-66-3451 | Doe     |

  @US01_NegativeApi
  Scenario: Admin should be able to delete information of Guest User List.
    Given send get request by "john_doeX"
    Then body must be empty with non existing username "john_doe"
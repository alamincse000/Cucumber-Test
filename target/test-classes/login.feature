Feature: login to HRM portal
  Scenario Outline: verify user can to login with invalid portal
    Given users visit to the HRM Portal
    When users input invalid "<username>" and "<password>"
    Then user can not log in
    Examples:
      | username | password |
    |user1     |123       |
    |user2     | 234      |
    |user3     |345       |

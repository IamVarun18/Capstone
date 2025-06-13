Feature: Search and Filter Products

  Scenario Outline: Search with a valid keyword
    Given user is on the Amazon home page with "<email>" and "<password>"
    When user searches for "<item>"
    Then search results for "<item>" should be displayed

    Examples: 
      | item   | email                    | password   |
      | laptop | varun.018072001@gmail.com | Varun@018072001 |

  Scenario Outline: Search with a invalid keyword
    Given user is on the Amazon home page with "<email>" and "<password>"
    When user searches for invalid "<item>"
    Then no product found should displayed

    Examples: 
      | item               | email                    | password   |
      | sdjkgnskldjgbakdfj | varun.018072001@gmail.com | Varun@018072001 |

  Scenario Outline: Apply single brand filter
    Given user has searched for "<item>" with "<email>" and "<password>"
    When user applies brand filter sony
    Then only Sony items should be listed

    Examples: 
      | item       | email                    | password   |
      | headphones | varun.018072001@gmail.com | Varun@018072001 |

  Scenario Outline: Clear all filters
    Given user has applied brand and price filters on "<item>" with "<email>" and "<password>"
    When user clears all filters
    Then all search results for "<item>" should be shown again

    Examples: 
      | item       | email                    | password   |
      | headphones | varun.018072001@gmail.com | Varun@018072001 |

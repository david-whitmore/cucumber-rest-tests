Feature: GET request

  Scenario: Get page that exists
    When I send a GET request for http://www.bbc.co.uk/news
    Then I should get a 200 response

  Scenario: Get page that doesn't exist
    When I send a GET request for http://www.bbc.co.uk/wibble
    Then I should get a 404 response
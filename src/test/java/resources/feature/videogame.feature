Feature: Testing requests of the Videogame application



  Scenario Outline: Create a new videoGame & Verify if the videoGame is added

    When I create a new Videogame by providing the information name "<name>" releaseDate "<releaseDate>" rating" <rating>"
    Then I verify the VideoGame is created Successfully
    Examples:
      | name  | releaseDate              | rating |
      | Mario | 2021-07-14T22:02:17.443Z | String |


  Scenario: Getting Videogame information by its Id
    When I send GET request to Videogame endpoint with Id "id",I should See the Videogame information Successfully

  Scenario: Update a created Videogame & verify if the Videogame is updated
    When  I update a created Videogame providing the new name
    Then I verify the Videogame is updated Successfully

  Scenario: Delete a created Videogame & verify the Videogame is deleted
    When I delete a created Videogame ,they get back a valid status code is 200


  Scenario: Verify if the Videogame application can be accessed by users
    When User sends a GET request to the Videogame endpoint,they get back a valid status code 200






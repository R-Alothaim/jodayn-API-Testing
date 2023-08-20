Feature: Application Login
@AddPlace
Scenario Outline: Scenario Outline name: Home page default login
    Given Add place "<Header 1>" "<Header 2>" "<Header 3>"
   When user calls "addPlaceAPI" with "post" http request
    Then "status" in response body is "Riyadh"
  #And verify place_id created maps to "<Header 1>" using "getPlaceAPI"
    Examples:
      | Header 1 | Header 2 | Header 3 |
      | Ryan     | English  | Riyadh   |
  #| Roon  | Arabic  | Jeddah  |
#@DeletePlace
#Scenario: Verify if Delete place functionality is working
    #Given Delete place payload
    #When user calls "deletePlaceAPI" with "post" http request
    #Then "status" in response body is "OK"
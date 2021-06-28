#Author: kits.gauravtiwary@gmail.com


Feature: As a person from Wales I need to know what help I can get with my NHS costs so that I can get the treatment I need
	
  Scenario Outline: Wales Test Ticket - Acceptance Criteria
    Given I am a person from Wales
    And I am able to open the browser and navigate to the NHS url
    When I put my circumstances into the Checker tool <Date> and <Month> and <Year>
    Then I should get a result of whether I will get help or not
    
  Examples:
	|Date |Month|Year|
	|22		|06		|2000|  
Feature: Login Functionality 

@LoginMultiple
Scenario Outline: User want to login the application 
	Given User launch the hotel booking application 
	When User enter the valid "<UserName>" and "<Password>" 
	And User click the login button 
	Then User validate the username and password then navigates to the homepage 
	
	Examples: 
		|UserName|Password|
		|AAA|111|
		|BBB|222|
		|CCC|333|
		
@Login	
Scenario: User want to login the application 
	Given User launch the hotel booking application 
	When User enter the valid username and password 
		|Baviraghu|98U3GP|
		|AAA|123|
		|BBB|123|
		|CCC|123|
	And User click the login button 
	Then User validate the username and password then navigates to the homepage 
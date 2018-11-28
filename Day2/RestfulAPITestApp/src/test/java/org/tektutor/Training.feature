Feature: Develop a RESTful API that supports CRUD operations for Training object. The training object will contain an id, name and duration fields. Where id is int, while name and duration are string fields.

	Scenario:  Should be able to add new training objects via POST.
		Given the id is "10" 
		And the name of the training is "Jenkins" 
		And the duration of the training is "2 days"
		When I invoke the POST endpoint "http://localhost:8080/tektutor-restful-ws-1.0.0/rest/trainings/"
		Then I expect the training object to get added to database. 

	Scenario:  Should be able to update training objects via PUT.
		Given the id is "10" 
		And the name of the training is "Jenkins" 
		And the duration of the training is "5 days"
		When I invoke the PUT endpoint "http://localhost:8080/tektutor-restful-ws-1.0.0/rest/trainings/"
		Then I expect the training object updated in the database. 

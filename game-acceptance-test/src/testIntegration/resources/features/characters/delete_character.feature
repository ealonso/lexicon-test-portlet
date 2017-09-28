Feature: Deleting Characters

	Background:

		* def characterName = 'Robb Stark'
		* def characterUrl = 'https://en.wikipedia.org/wiki/File:Robb_Stark-Richard_Madden.jpg'

		* def setupReponse = call read('../helper/setup.feature')

		* def authHeaderValue = setupReponse.authHeaderValue
		* def companyId = setupReponse.companyId
		* def groupId = setupReponse.groupId
		* def userId = setupReponse.userId

	Scenario: Deleting a Character

	 # Setup

		Given url characterURL
		And path 'add-character'
		And header Authorization = authHeaderValue
		And param userId = userId
		And param groupId = groupId
		And param name = characterName
		And param url = characterUrl
		When method get
		Then status 200

		* def characterId = response.characterId

	 # Delete character

		Given url characterURL
		And path 'delete-character'
		And header Authorization = authHeaderValue
		And param characterId = characterId
		When method get
		Then status 200

	  # Verify

		Given url characterURL
		And path 'get-character'
		And header Authorization = authHeaderValue
		And param characterId = characterId
		When method get
		Then status 500
		And match response.exception == 'No Character exists with the primary key ' + characterId

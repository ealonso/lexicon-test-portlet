Feature: Getting Characters

	Background:

		* def characterName = 'Robb Stark'
		* def characterUrl = 'https://en.wikipedia.org/wiki/File:Robb_Stark-Richard_Madden.jpg'

		* def setupReponse = call read('../helper/setup.feature')

		* def authHeaderValue = setupReponse.authHeaderValue
		* def companyId = setupReponse.companyId
		* def groupId = setupReponse.groupId
		* def userId = setupReponse.userId

	Scenario: Getting a Character

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

	  # Verify

		Given url characterURL
		And path 'get-character'
		And header Authorization = authHeaderValue
		And param characterId = characterId
		When method get
		Then status 200
		And match response contains
           """
           {
               characterId: '#notnull',
               companyId: '#(companyId)',
               createDate: '#notnull',
               groupId: '#notnull',
               modifiedDate: '#notnull',
               name: '#(characterName)',
               url: '#(characterUrl)',
               userId: '#(userId)',
               userName: '#notnull',
               uuid: '#notnull'
           }
           """

	 # Cleanup

		Given url characterURL
		And path 'delete-character'
		And header Authorization = authHeaderValue
		And param characterId = characterId
		When method get
		Then status 200

	Scenario: Get all Characters in a group

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

	 # Verify that the number of characters returned is greater than 0

		Given url characterURL
		And path 'get-characters'
		And header Authorization = authHeaderValue
		And param groupId = groupId
		And param start = 0
		And param end = 2
		When method get
		Then status 200
		And match response == '#[_ > 0]'

	 # Cleanup

		Given url characterURL
		And path 'delete-character'
		And header Authorization = authHeaderValue
		And param characterId = characterId
		When method get
		Then status 200

Feature: Updating existing Characters

	Background:

		* def characterName = 'Robb Stark'
		* def updatedCharacterName = 'Robb Stark 2'
		* def characterUrl = 'https://en.wikipedia.org/wiki/File:Robb_Stark-Richard_Madden.jpg'
		* def updatedCharacterUrl = 'https://en.wikipedia.org/wiki/File:Robb_Stark-Richard_Madden2.jpg'

		* def setupReponse = call read('../helper/setup.feature')

		* def authHeaderValue = setupReponse.authHeaderValue
		* def companyId = setupReponse.companyId
		* def groupId = setupReponse.groupId
		* def userId = setupReponse.userId

	Scenario: Update an existing Character

		# Setup: Add a new character

		Given url characterURL
		And path 'add-character'
		And header Authorization = authHeaderValue
		And param userId = userId
		And param groupId = groupId
		And param name = characterName
		And param url = characterUrl
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

		* def characterId = response.characterId

	 # Update character

		Given url characterURL
		And path 'update-character'
		And header Authorization = authHeaderValue
		And param userId = userId
		And param groupId = groupId
		And param characterId = characterId
		And param name = updatedCharacterName
		And param url = updatedCharacterUrl
		When method get
		Then status 200
		And match response contains
           """
           {
               characterId: '#(characterId)',
               companyId: '#(companyId)',
               createDate: '#notnull',
               groupId: '#notnull',
               modifiedDate: '#notnull',
               name: '#(updatedCharacterName)',
               url: '#(updatedCharacterUrl)',
               userId: '#(userId)',
               userName: '#notnull',
               uuid: '#notnull'
           }
           """

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
               name: '#(updatedCharacterName)',
               url: '#(updatedCharacterUrl)',
               userId: '#(userId)',
               userName: '#notnull',
               uuid: '#notnull'
           }
           """

		# Clean Up

		Given url characterURL
		And path 'delete-character'
		And header Authorization = authHeaderValue
		And param characterId = characterId
		When method get
		Then status 200

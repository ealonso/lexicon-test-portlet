Feature: Adding new Characters

	Background:

		* def characterName = 'Robb Stark'
		* def characterUrl = 'https://en.wikipedia.org/wiki/File:Robb_Stark-Richard_Madden.jpg'

		* def setupReponse = call read('../helper/setup.feature')

		* def authHeaderValue = setupReponse.authHeaderValue
		* def companyId = setupReponse.companyId
		* def groupId = setupReponse.groupId
		* def userId = setupReponse.userId

	Scenario: Add a new Character

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

		# Clean Up

		Given url characterURL
		And path 'delete-character'
		And header Authorization = authHeaderValue
		And param characterId = characterId
		When method get
		Then status 200

	Scenario: Validation of Character with missing name

		Given url characterURL
		And path 'add-character'
		And header Authorization = authHeaderValue
		And param userId = userId
		And param groupId = groupId
		And param url = characterUrl
		When method get
		Then status 404
		And match response.error.message contains 'No JSON web service'
		And match response.error.type == 'com.liferay.portal.kernel.jsonwebservice.NoSuchJSONWebServiceException'

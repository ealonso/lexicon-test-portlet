Feature: Deleting Data Sources

#    curl http://localhost:8080/api/jsonws/game.character/delete-characters \
#    -u test@liferay.com:test \
#    -d groupId=12345

#   curl http://localhost:8080/api/jsonws/game.character/delete-character \
#  -u test@liferay.com:test \
#  -d characterId=12345

    Background: Discover Data Sources URL

        Given url engineURL
        When method get
        Then status 200

        * def dataSourcesLink = response._links['data-sources']
        * def dataSourcesURL = dataSourcesLink.href
        * replace dataSourcesURL.{projectId} = projectId

    Scenario: Deleting a Data Source
         # Set Up

            * def dataSource =
               """
               {
                   "name" : "Internal LDAP",
                   "provider" : {
                       "name" : "liferay-de"
                   },
                   "url" : "http://interal.ldap.com"
               }
               """

            Given url dataSourcesURL
            And request dataSource
            When method post
            Then status 200

            * def identifier = response.identifier

        Given url dataSourcesURL
        And path identifier
        When method delete
        Then status 200

        # Verify

            Given url dataSourcesURL
            And path identifier
            When method get
            Then status 404
Feature: Updating existing Data Sources

#    curl http://localhost:8080/api/jsonws/game.character/update-character \
#    -u test@liferay.com:test \
#    -d characterId=22332 \
#    -d name='abcd' \
#    -d url='http'

    Background: Discover Data Sources URL

        Given url engineURL
       When method get
       Then status 200

       * def dataSourcesLink = response._links['data-sources']
       * def dataSourcesURL = dataSourcesLink.href
       * replace dataSourcesURL.{projectId} = projectId

    Scenario: Update a Data Source

        # Set Up

            * def dataSource =
               """
               {
                   "name" : "Intranet",
                   "provider" : {
                       "name" : "liferay-de"
                   },
                   "url" : "https://web.liferay.com"
               }
               """

            Given url dataSourcesURL
            And request dataSource
            When method post
            Then status 200

            * def identifier = response.identifier

        * def dataSource =
           """
           {
               "name" : "Intranet",
               "provider" : {
                   "name" : "liferay-de"
               },
               "url" : "https://loop.liferay.com"
           }
           """

        Given url dataSourcesURL
        And path identifier
        And request dataSource
        When method put
        Then status 200
        And match response contains {url : "https://loop.liferay.com"}

        # Clean Up

            Given url dataSourcesURL
            And path identifier
            When method delete
            Then status 200


    Scenario: Attempt to update a non existing Data Source

            * def dataSource =
               """
               {
                   "name" : "Social Network",
                   "provider" : {
                       "name" : "liferay-de"
                   },
                   "url" : "https://social.liferay.com"
               }
               """

            Given url dataSourcesURL
            And path 'ABCDEF'
            And request dataSource
            When method put
            Then status 404
            And match response.message == 'Not Found'
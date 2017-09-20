Feature: Getting Data Sources

    Background: Discover Data Sources URL

        Given url engineURL
        When method get
        Then status 200

        * def dataSourcesLink = response._links['data-sources']
        * def dataSourcesURL = dataSourcesLink.href
        * replace dataSourcesURL.{projectId} = projectId

#    curl http://localhost:8080/api/jsonws/game.character/get-characters \
#    -u test@liferay.com:test \
#    -d groupId=20143 \
#    -d start=0 \
#    -d end=10

#    curl http://localhost:8080/api/jsonws/game.character/get-character \
#    -u test@liferay.com:test \
#    -d characterId=25703

    Scenario: Get a Data Source

            # Set Up

            * def dataSource =
               """
               {
                   "name" : "Public Website",
                   "provider" : {
                       "name" : "liferay-de"
                   },
                   "url" : "http://mywebsite.com"
               }
               """

            Given url dataSourcesURL
            And request dataSource
            When method post
            Then status 200

            * def identifier = response.identifier

        Given url dataSourcesURL
        And path identifier
        When method get
        Then status 200
        And match response contains
        """
           {
               identifier : '#(identifier)',
               dateCreated : '#notnull',
               dateModified : '#notnull',
               name : "Public Website",
               provider : {
                   name : "liferay-de"
               },
               url : "http://mywebsite.com"
           }
           """
        And match response !contains { projectId: '#notnull' }

            # Clean Up

            Given url dataSourcesURL
            And path identifier
            When method delete
            Then status 200

    Scenario: Get the list of Data Sources

         # Set Up

            * def dataSource1 =
               """
               {
                   "name" : "Intranet1",
                   "provider" : {
                       "name" : "liferay-de"
                   },
                   "url" : "http://mywebsite.com"
               }
               """

            * def dataSource2 =
               """
               {
                   "name" : "Intranet2",
                   "provider" : {
                       "name" : "liferay-de"
                   },
                   "url" : "http://mywebsite.com"
               }
               """


            Given url dataSourcesURL
            And request dataSource1
            When method post
            Then status 200
            * def identifier1 = response.identifier

            Given url dataSourcesURL
            And request dataSource2
            When method post
            Then status 200
            * def identifier2 = response.identifier


        Given url dataSourcesURL
        When method get
        Then status 200
        And match response._embedded['data-sources'][*].name contains ['Intranet1', 'Intranet2']
        And match response.page.size == '#number'
        And match response.page.number == '#number'
        And match response.page.totalElements == '#number'
        And match response.page.totalPages == '#number'

        # Clean Up

            Given url dataSourcesURL
            And path identifier1
            When method delete
            Then status 200

            Given url dataSourcesURL
            And path identifier2
            When method delete
            Then status 200

    Scenario: Get the list of Data Sources paginated

         # Set Up

            * def dataSource1 =
               """
               {
                   "name" : "Intranet1",
                   "provider" : {
                       "name" : "liferay-de"
                   },
                   "url" : "http://mywebsite.com"
               }
               """

            * def dataSource2 =
               """
               {
                   "name" : "Intranet2",
                   "provider" : {
                       "name" : "liferay-de"
                   },
                   "url" : "http://mywebsite.com"
               }
               """


            Given url dataSourcesURL
            And request dataSource1
            When method post
            Then status 200
            * def identifier1 = response.identifier

            Given url dataSourcesURL
            And request dataSource2
            When method post
            Then status 200
            * def identifier2 = response.identifier

        Given url dataSourcesURL
        And param size = '1'
        When method get
        Then status 200
        And match response._links.self == '#notnull'
        And match response._links.first == '#notnull'
        And match response._links.next == '#notnull'
        And match response._links.last == '#notnull'

        # Clean Up

            Given url dataSourcesURL
            And path identifier1
            When method delete
            Then status 200

            Given url dataSourcesURL
            And path identifier2
            When method delete
            Then status 200

    Scenario: Navigate to the second page of Data Sources

         # Set Up

            * def dataSource1 =
               """
               {
                   "name" : "Intranet1",
                   "provider" : {
                       "name" : "liferay-de"
                   },
                   "url" : "http://mywebsite.com"
               }
               """

            * def dataSource2 =
               """
               {
                   "name" : "Intranet2",
                   "provider" : {
                       "name" : "liferay-de"
                   },
                   "url" : "http://mywebsite.com"
               }
               """


            Given url dataSourcesURL
            And request dataSource1
            When method post
            Then status 200
            * def identifier1 = response.identifier

            Given url dataSourcesURL
            And request dataSource2
            When method post
            Then status 200
            * def identifier2 = response.identifier

        Given url dataSourcesURL
        And param size = '1'
        When method get
        Then status 200

        Given url response._links.next.href
        When method get
        Then status 200
        And assert response._embedded['data-sources'].length == 1
        And match response.page.number == 1

        # Clean Up

            Given url dataSourcesURL
            And path identifier1
            When method delete
            Then status 200

            Given url dataSourcesURL
            And path identifier2
            When method delete
            Then status 200
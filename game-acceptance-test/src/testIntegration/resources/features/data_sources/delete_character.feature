Feature: Deleting Data Sources

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
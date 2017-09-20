Feature: Adding new Data Sources


#    curl http://localhost:8080/api/jsonws/game.character/add-character \
#    -u test@liferay.com:test \
#    -d userId=12311 \
#    -d groupId=1212121 \
#    -d name='abc' \
#    -d url='http'

    Background: Discover Data Sources URL

        Given url engineURL
        When method get
        Then status 200

        * def dataSourcesLink = response._links['data-sources']
        * def dataSourcesURL = dataSourcesLink.href
        * replace dataSourcesURL.{projectId} = projectId

    Scenario: Add a new Data Source

        * def dataSource =
           """
           {
               "name" : "Customer Portal",
               "provider" : {
                   "name" : "liferay-de"
               },
               "url" : "https://web.liferay.com/group/customer",
               "author" : {
                    "identifier" : "12345",
                    "name" : "Eduardo Pulido"
               }
           }
           """

        Given url dataSourcesURL
        And request dataSource
        When method post
        Then status 200
        And match response contains
        """
           {
               identifier : '#notnull',
               dateCreated : '#notnull',
               dateModified : '#notnull',
               name : "Customer Portal",
               provider : {
                   name : "liferay-de"
               },
               url : "https://web.liferay.com/group/customer",
               author : {
                   identifier : "12345",
                   name : "Eduardo Pulido"
               }
           }
           """

        # Clean Up

            Given url dataSourcesURL
            And path response.identifier
            When method delete
            Then status 200


    Scenario: Validation of Data Source with missing name

        * def dataSource =
           """
           {
               "provider" : {
                   "name" : "liferay-de"
               },
               "url" : "https://web.liferay.com/group/customer"
           }
           """

        Given url dataSourcesURL
        And request dataSource
        When method post
        Then status 422
        And match response.message == 'Unprocessable Entity'
        And match response.fieldErrors[*].field contains 'name'
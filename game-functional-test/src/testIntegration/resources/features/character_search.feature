Feature: Search of Characters

    Screenwriters should be able to find the characters available in the show.

    Scenario: Search a character by name (Arya)

        Given a character called Arya Stark exists
        When I search for Arya
        Then I see Arya Stark in the list of characters

    Scenario: Search a character by family name (Arya)

        Given a character called Arya Stark exists
        When I search for Stark
        Then I see Arya Stark in the list of characters

    Scenario: Search a character by house

        Given a character called Arya Stark exists
        When I search for ALIVE
        Then I see Arya Stark in the list of characters
        
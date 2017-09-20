Feature: Creation of Characters

    Screenwriters should be able to add new characters to the show.

    Scenario: Adding a new Character (Arya)

        Given I am in the list of characters
        When I add a new character called Arya Stark
        Then I see Arya Stark in the list of characters

    Scenario: Adding a new Character without a name

        Given I am in the list of characters
        When I add a new character without a name
        Then I can't save the character
Feature: Slay of Characters

    Screenwriters should be able to slay characters in the show. (Even if those
    characters are really loved by everyone in the world).

    Scenario: Slaying a Character (Jon)

        Given a character called Jon Snow exists
        When I slay Jon Snow
        Then Jon Snow is dead

    Scenario: Slaying a dead character

        Given Jon Snow is daed
        When I try to slay Jon Snow
        Then I can't slay Jon Snow
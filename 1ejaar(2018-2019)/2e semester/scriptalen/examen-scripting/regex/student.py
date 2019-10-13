import re

def correct(s):
    return re.sub('([A-Z]{1})', r'_\1', s).lower()#\1 means contents of last group


    """
    De functie correct(s) ontvangt een string s.
    Deze string bevat code waarin identifiers geschreven zijn in
    lower camel case. Dit ken je van Java,
    nl. een identifier bestaande uit meerdere
    woorden waarvan elk woord met een hoofdletter
    geschreven wordt behalve het eerste.
    Voorbeelden zijn isLarge, validateValue en dropTable.

    Je wenst van naamconventie te veranderen:
    je wil nu woorden scheiden door een underscore:

        isLarge       --> is_large
        validateValue --> validate_value
        dropTable     --> dropTable

    Deze functie moet een nieuwe string teruggeven
    waarin alle lowerCamelCase identifiers
    omgezet zijn naar de nieuwe underscore-naamgeving.

    
    === ENGLISH ===

    The function receives a string s.
    This string contains code where
    identifiers are written in lower camel case, e.g.
    isLarge, validateValue, dropTable.

    You now want to switch to another naming convention,
    one where words are separated by underscores:x

        isLarge       --> is_large
        validateValue --> validate_value
        dropTable     --> dropTable

    This function should return a new string in which
    all identifiers have been transformed to the new naming convention.

    """


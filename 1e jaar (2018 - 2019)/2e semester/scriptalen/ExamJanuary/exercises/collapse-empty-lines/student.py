def collapse_empty_lines(file_in, file_out):

    

    '''
    Parameters:
    * file_in: bestandsnaam van invoerbestand
    * file_out: bestandsnaam van uitvoerbestand

    De functie moet de inhoud van het invoerbestand uitlezen,
    overbodige whitespace weghalen, en het resultaat
    wegschrijven naar het uitvoerbestand.

    We moeten nu nog bepalen wanneer whitespace overbodig is.
    In onderstaande voorbeelden gebruiken we . om spaties aan te geven.

    1. Indien een regel enkel whitespace bevat, moet deze whitespace verwijderd worden.
       Bijvoorbeeld,

              --------------------
              a.b.c
              .......
              ...b...
              --------------------

       Er is hier sprake van drie regels, waarvan de middelste enkel whitespace bevat.
       Dit moet omgezet worden naar

              --------------------
              a.b.c
              
              ...b...
              --------------------

       m.a.w. op de tweede regel moeten alle spaties verwijderd worden.
       Merk op dat de whitespace op de eerste en derde regel onveranderd moeten blijven.

    2. Er mogen geen twee opeenvolgende lege regels voorkomen. Indien er meerdere
       lege regels elkaar opvolgen, moeten deze samengesmolten worden tot een enkele lege regel.
       Bijvoorbeeld,

              --------------------
              aaa


              bbb



              ccc
              --------------------

        moet omgezet worden naar

              --------------------
              aaa

              bbb

              ccc
              --------------------
    '''

    raise NotImplementedError()

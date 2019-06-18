import json

def count_courses(input):
    data = json.loads(input)
    ret = dict()

    for student in data:
        ret[student["studentid"]] = len[student["courses"]]

    return ret

    '''
    Het argument input krijgt een JSON-string binnen. Deze heeft de volgende vorm:

        [ { "studentId": <student-id-string>,
            "courses": [ <course-id-string>, <course-id-string>, ... ] },
          { "studentId": <student-id-string>,
            "courses": [ <course-id-string>, <course-id-string>, ... ] },
          ...
        ]

    Een concreet voorbeeld is:

        [ { "studentId": "r0000001",
            "courses": [ "MBI58x", "MBI12x", "MBI98x" ] },
          { "studentId": "r0000002",
            "courses": [ "MBI58x", "MBI12x", "MBI98x" ] },
        ]

    Dit geeft aan dat er twee studenten student zijn met r-nummers r0000001 en r0000002
    die beiden de drie vakken met codes MBI58x, MBI12x en MBI98x volgen.
    Merk op dat input een string is en je deze zal moeten parsen.
    Vergelijk het met 15 en "15": alvorens je wiskundige operaties kan toepassen
    op "15" moet je deze eerst omzetten (parsen) naar een integer 15.

    De functie moet een dict teruggeven die de r-nummers associeert met het aantal
    vakken dat de student met dat r-nummer volgt. Voor bovenstaand voorbeeld is dit dus

        { "r0000001": 3, "r0000002": 3 }


    === ENGLISH ===

    The argument named input contains a JSON-string. It has the form

        [ { "studentId": <student-id-string>,
            "courses": [ <course-id-string>, <course-id-string>, ... ] },
          { "studentId": <student-id-string>,
            "courses": [ <course-id-string>, <course-id-string>, ... ] },
          ...
        ]

    For example,

        [ { "studentId": "r0000001",
            "courses": [ "MBI58x", "MBI12x", "MBI98x" ] },
          { "studentId": "r0000002",
            "courses": [ "MBI58x", "MBI12x", "MBI98x" ] },
        ]

    This indicates that there are two students with ids r0000001 and r0000002
    who both follow the same three courses with ids MBI58x, MBI12x, MBI98x.
    Notice that the argument input is a string and you will need to parse it.

    The function should return a dict that associates student ids
    with the number of courses they follow. For the example above,
    the result should be

        { "r0000001": 3, "r0000002": 3 }

    '''

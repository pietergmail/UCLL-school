import hashlib

def hash_file(filename):
    with open(filename, 'r') as file:
        data = file.readlines()

        ret = ""
        for line in data:
            line = line.replace('\n', '')
            hs = hashlib.sha256(line.encode('ASCII')).hexdigest()[:10]
            ret += hs+"\n"


        with open(filename) as file:
            file.write(ret)
        file.close()


    '''
    Open het bestand met bestandnaam filename.
    Elke regel in dit bestand moet vervangen door de eerste 10 hexadecimale cijfers
    van de SHA256-hash ervan.

    Bijvoorbeeld, stel dat het bestand de volgende regels tekst bevat:

        a
        b
        c

    dan moet na de oproep van deze functie het bestand de volgende data bevatten:

        10 eerste hex-cijfers van SHA256(a)
        10 eerste hex-cijfers van SHA256(b)
        10 eerste hex-cijfers van SHA256(c)
                    
    Je zal merken dat je zal moeten specificeren welke encoding je moet gebruiken
    om de strings naar rauwe bytes om te zetten. Gebruik hiervoor ASCII.


    === ENGLISH ===

    Open the file with the given name.
    Each line in this file should be replaced by the first 10 hexadecimal digits
    of its SHA256-hash.

    For example, say the file contains the following lines:

        a
        b
        c

    After a call to hash_file, the file's new contents should contain:

        10 first hex-digits van SHA256(a)
        10 first hex-digits van SHA256(b)
        10 first hex-digits van SHA256(c)

    Use ASCII encoding to convert strings to raw bytes.

    '''

def generate_download_script(ids):
    res = ""
    for ida in ids:
        res += 'if [ ! -d {} ]; then\n'.format(ida)
        res += '    git clone https://github.com/{}/project\n'.format(ida, ida)
        res += 'else\n'
        res += '    (cd {}; git pull\n'.format(ida)
        res += 'fi\n'

    return res


    '''
    We willen een reeks git-repositories afhalen. Deze functie moet hiervoor een shell-script genereren.
    Je gaat in Python dus geen git-repos afhalen, maar instructies genereren die dat zullen doen.

    Het argument ids is een lijst van alle GitHub accounts waarvan we de repo genaamd "project"
    willen afhalen. De url voor deze repo is

        http://github.com/<id>/project

    Elke repo moet naar een aparte directory gecloned worden, genoemd naar de eigenaar.
    Bijvoorbeeld, stel dat we de repo van gebruiker 'ryan' willen afhalen, dan gebeurt dit
    met de opdracht

        git clone https://github.com/ryan/project ryan

    Het kan echter zijn dat de repo reeds afgehaald werd. In dit geval willen we
    de nieuwste versie afhalen (git pull). De uit te voeren opdracht wordt dan

        if [ ! -d ryan ]; then
            git clone https://github.com/ryan/project ryan
        else
            (cd ryan; git pull)
        fi
    
    Schrijf de functie generate_download_script die voor elke gegeven id
    deze regels scriptcode genereert. Geef het resultaat terug als een enkele string.

    Bijvoorbeeld, stel dat ids == [ 'A', 'B', 'C' ], dan moet de volgende string teruggegeven worden:

        if [ ! -d A ]; then
            git clone https://github.com/A/project A
        else
            (cd A; git pull)
        fi

        if [ ! -d B ]; then
            git clone https://github.com/B/project B
        else
            (cd B; git pull)
        fi

        if [ ! -d C ]; then
            git clone https://github.com/C/project C
        else
            (cd C; git pull)
        fi


    De tests zijn vrij flexibel: lege lijnen tellen niet mee, indentatie wordt
    eveneens genegeerd. Het belangrijkste is dat je de regelstructuur behoudt:
    wat op aparte regels staat, moet op aparte regels blijven staan. Bijvoorbeeld,

        if [ ! -d A ]; then git clone https://github.com/A/project A
        else (cd A; git pull)
        fi

    zal worden gekeurd worden door de tests.
    Het spreekt voor zich dat de volgorde eveneens behouden moet blijven.


    === ENGLISH ===

    We wish to download a number of git-repositories. This function should generate a shell script to achieve this.
    Note that you won't be downloading git-repos in Python, you will merely generate a script.

    The argument named ids contains a list of all GitHub accounts of which we wish to
    fetch the repo named "project". The url for this repo has the form

        http://github.com/<id>/project

    Each repo should be cloned into a separate directory, named after the owner.
    For example, to fetch the repo of user 'ryan', we can use the command

        git clone https://github.com/ryan/project ryan

    However, it is possible that we already downloaded this repo in the past.
    In this case, we merely want to perform an update using git pull:

        if [ ! -d ryan ]; then
            git clone https://github.com/ryan/project ryan
        else
            (cd ryan; git pull)
        fi
    
    Write a function generate_download_script that for each given id
    generates the commands shown above. Return all commands as a single string.

    For example, say ids == [ 'A', 'B', 'C' ], then you should return the following string:

        if [ ! -d A ]; then
            git clone https://github.com/A/project A
        else
            (cd A; git pull)
        fi

        if [ ! -d B ]; then
            git clone https://github.com/B/project B
        else
            (cd B; git pull)
        fi

        if [ ! -d C ]; then
            git clone https://github.com/C/project C
        else
            (cd C; git pull)
        fi


    The tests are flexible: empty lines are ignored, and so is indentation.
    It is important, however, to preserve the line structure:
    separate lines should remain separate. For example,

        if [ ! -d A ]; then git clone https://github.com/A/project A
        else (cd A; git pull)
        fi

    is not considered valid by the tests.
    The order of the lines also needs to be preserved.

    '''

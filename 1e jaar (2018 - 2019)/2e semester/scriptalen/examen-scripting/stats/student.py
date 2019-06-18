import argparse
import statistics
def stats():

    parser = argparse.ArgumentParser()
    Parser.add_Argument('integers', type=float, narg='+')
    parser.add_argument('-m', action='store_true')
    parser.add_argument('--min', action='store_true')
    parser.add_argument('-M', action='store_true')
    parser.add_argument('--max', action='store_true')
    parser.add_argument('--mean', action='store_true')
    parser.add_argument('--stdev', action='store_true')
    parser.add_argument('--mode', action='store_true')
    args = parser.parse_args()

    ret = ""

    if args.m or args.min:
        ret += str(min(args.integers)) + ' '

    if args.M or args.max:
        ret += str(max(args.integers)) + ' '

    if args.mean:
        ret += str(statistics.mean(args.integers)) + ' '

    if args.stdev:
        ret += str(statistics.stdev(args.integers)) + ' '

    if args.mode:
        ret += str(statistics.mode(args.integers)) + ' '

    return ret[:-1]

    '''
    We doen alsof deze functie 'stats' vanop de command line kan opgeroepen worden.
    M.a.w. je haalt de argumenten waar je normaalgezien de command line arguments
    vindt. Deze staan daar ook voorgesteld als een array van strings.

    De bedoeling is dat je dit script kan gebruiken om statistische
    berekeningen uit te voeren op getallen. De ondersteunde opties zijn

      -m of --min      Minimum
      -M of --max      Maximum
      --mean           Gemiddelde
      --stdev          Standaarddeviatie
      --mode           Modus

    Bijvoorbeeld, stel dat we als argumenten

       1 2 3 4 5 --max

    doorgegeven, dan moet als antwoord "5" (als string) teruggegeven worden.
    De volgorde maakt niet uit:

       --max 5 2 3 1 4

    geeft hetzelfde resultaat.

    Het moet tevens mogelijk zijn om meerdere berekeningen op te vragen:

       -m -M 3 4 5 6 7

    moet '3 7' opleveren. De volgorde waarin de statistische waarden worden
    teruggegeven staat vast, m.a.w. deze is onafhankelijk van de volgorde
    waarin ze opgesomd staan in de lijst argumenten.

      Indien het minimum wordt opgevraagd, dan komt eerst het minimum.
      Indien het maximum wordt opgevraagd, dan volgt het maximum.
      etc.

    De volgorde is minimum, maximum, gemiddelde, standaarddeviatie en modus.
    Bijvoorbeeld,

      -m -M 1 2 3
      -M -m 1 2 3
      -m 1 2 3 -M
      -M 1 2 3 -m
      -m -m -m -M 1 2 3 -M

    leveren allemaal hetzelfde resultaat '1 3' op.


    === ENGLISH ===

    For this exercise, we will pretend that the function 'stats'
    will be called from the shell, i.e., you will need
    to fetch the arguments from the same location
    as where you get command line arguments from.
    This also means the arguments will take the form
    of an array of strings.

    The purpose of this script is to allow you to perform
    statistical computations from the command line.
    The following options should be supported:

      -m of --min      Minimum
      -M of --max      Maximum
      --mean           Mean
      --stdev          Standard deviation
      --mode           Mode

    For example, say you are given

       1 2 3 4 5 --max

    Your function should then return the string "5"
    The order of the arguments is irrelevant:

       --max 5 2 3 1 4

    yields the same result.

    Additionally, it should also be possible to
    ask for multiple computations:

       -m -M 3 4 5 6 7

    should return '3 7'. The order in which the statistical
    values should be returned is fixed, i.e.,
    it is unrelated to the order in which they are mentioned in the arguments.

      If the minimum is requested, the minimum should be outputted first.
      If the maximum is requested, the maximum should come next.
      etc.

    The order is minimum, maximum, mean, standard deviation en mode.
    For example,

      -m -M 1 2 3
      -M -m 1 2 3
      -m 1 2 3 -M
      -M 1 2 3 -m
      -m -m -m -M 1 2 3 -M

    all yield the same result '1 3'.

    '''

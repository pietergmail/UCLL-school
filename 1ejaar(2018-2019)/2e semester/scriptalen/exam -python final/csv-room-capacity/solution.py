# Bereken maximaal aantal toegelaten mensen
import csv

lokaalt = []
datumt = []
dagdeelt = []

count = 1
with open("exam-schedule.csv", "r") as file:
    data = csv.DictReader(file)

    for row in data:
        lokaal = row["Lokaal"]
        lokaalt.append(lokaal)#get alle lokalen
        datum = row["Datum"]
        datumt.append(datum)#get alle data
        dagdeel = row["Dagdeel"]
        dagdeelt.append(dagdeel)#get alle dagdelen (vm, nm)

    for x in datumt:
        if datumt[x + 1] == datumt[x] and lokaalt[x + 1] == lokaalt[x] and dagdeelt[x +  1] == dagdeelt[x]:
            #everything is the same as before
            count = count + 1



'''
    print(lokaalt)
    print(datumt)
    print(dagdeelt)
'''


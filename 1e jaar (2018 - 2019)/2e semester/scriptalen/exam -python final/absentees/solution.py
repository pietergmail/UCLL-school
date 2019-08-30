all = []
attending = []
with open('all.txt') as file:
  for line in file:
    all.append(line.strip())

with open('attending.txt') as file:
  for line in file:
    attending.append(line.strip())

all = [item.lower() for item in all]
attending = [item.lower() for item in attending]

absentees = [x for x in all if x not in attending]

with open("absentees.txt", "w") as output:
    for line in absentees:
        output.write(str(line))
        output.write(str("\n"))
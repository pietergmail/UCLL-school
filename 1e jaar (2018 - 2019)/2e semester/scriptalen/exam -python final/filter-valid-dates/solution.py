# Write your solution in this file
import re
import time


def is_date_valid(year, month, day):
    this_date = '%d/%d/%d' % (month, day, year)
    try:
        time.strptime(this_date, '%m/%d/%Y')
    except ValueError:
        return False
    else:
        return True

list = []
lineList = []

with open('input.txt') as file:
  for line in file:
    lineList.append(line.strip())

print(lineList)

for row in lineList:
    match = re.fullmatch(r"^\d{1,2}\-\d{1,2}\-\d{4}", row)
    if match:
        day, month, year = row.split('-')
        day, month, year = int(day), int(month), int(year)
        if is_date_valid(year, month, day):
            list.append(row)

with open("output.txt", "w") as output:
    for line in list:
        output.write(str(line) + "\n")
    output.truncate(output.tell()-1)
    output.close()
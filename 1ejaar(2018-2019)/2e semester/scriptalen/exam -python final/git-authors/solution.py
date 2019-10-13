'''
input = []

with open('input.txt') as file:
  for line in file:
      if file.append(line.split(None, 1)[0]) == "Author:":
          input.append(line.strip())

print(input)
'''
list = []
f = open("input.txt", "r")

for line in f:
    list.append(f.readline().split(None, 1))

list = filter(None, list)

print(list)

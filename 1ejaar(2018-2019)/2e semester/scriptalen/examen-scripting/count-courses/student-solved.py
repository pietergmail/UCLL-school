import json

def count_courses(input):
    data = json.loads(input)
    ret = dict()

    for student in data:
        ret[student["studentId"]] = len(student["courses"])

    return ret

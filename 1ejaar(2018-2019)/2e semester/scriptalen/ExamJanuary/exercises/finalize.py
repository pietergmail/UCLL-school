import zipfile
import sys
import os



problem_names = [
    'collapse-empty-lines',
    'cyclic-list',
    'find-keys',
    'remove-duplicates',
    'successors',
    'zip-contains'
]


for expected_directory in problem_names:
    expected_file = "{}/student.py".format(expected_directory)

    if not os.path.isdir(expected_directory):
        print("Could not find directory {}!".format(expected_directory))
        sys.exit(-1)

    if not os.path.isfile(expected_file):
        print("Could not find file {}!".format(expected_file))
        sys.exit(-1)

    print("Found {}".format(expected_file))


print("Found all files!")

with zipfile.ZipFile('submission.zip', 'w') as zip:
    for problem_name in problem_names:
        filename = "{}/student.py".format(problem_name)

        print("Adding {} to zip".format(filename))
        zip.write(filename)

print('''
*** Success ***
All student.py files were written to submission.zip.
For safety, you should double check its contents.
If everything is ok, upload submission.zip to Toledo
''')

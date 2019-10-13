import subprocess
import zipfile
import shutil
import sys
import os
import re

import testing.logging
import testing.tests
import testing.run



class NullLog:
    def write(self, message):
        pass


problem_names = [
    'collapse-empty-lines',
    'cyclic-list',
    'find-keys',
    'remove-duplicates',
    'successors',
    'zip-contains'
]


main_path = os.getcwd()

for filename in sys.argv[1:]:
    sys.stderr.write("Processing {}\n".format(filename))

    if not os.path.isfile(filename):
        print("Missing file {}".format(filename))

    match = re.fullmatch(r'^(.*)\.zip', filename)

    if not match:
        print("Filename {} should have extension .zip".format(match))

    submission_name = match.group(1)

    with zipfile.ZipFile(filename, 'r') as zip:
        zip.extractall(submission_name)

    for problem_name in problem_names:
        source = "tests/{}/tests.py".format(problem_name)
        target = "{}/{}/tests.py".format(submission_name, problem_name)
        shutil.copy(source, target)

    try:
        os.chdir(submission_name)

        bindings = {}
        score = 0

        def score_receiver(s):
            global score
            score = s

        bindings['log'] = NullLog()
        bindings['show_context'] = False
        bindings['max_tests'] = float('inf')
        bindings['tested_file'] = 'student.py'
        bindings['show_passing_tests'] = False
        bindings['show_skipped_tests'] = False
        bindings['show_failed_tests'] = False
        bindings['show_file_path'] = False
        bindings['reference_file'] = 'solution.py'
        bindings['score_receiver'] = score_receiver
        bindings['skipped_tests'] = []
        bindings['passed_tests'] = []
        bindings['failed_tests'] = []
        bindings['condition'] = testing.conditions.limit_test_count()
        bindings['context'] = []
        bindings['test_path'] = []
        bindings['test_file_path'] = []

        with testing.environment.let(**bindings), testing.tests.cumulative():
            testing.run.load_tests_recursively()

        print("{}: {}".format(submission_name, score))

    finally:
        os.chdir(main_path)

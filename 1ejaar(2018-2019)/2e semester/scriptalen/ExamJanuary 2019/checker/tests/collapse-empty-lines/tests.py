from testing import *
from testing.tests import *
from testing.assertions import *
import random


with scale(3), all_or_nothing(skip_after_fail=True):
    with tested_function_name("collapse_empty_lines"):
        random.seed(3451)

        def check(original, expected, file_in='input.txt', file_out='output.txt'):
            @test('collapse_empty_lines')
            def _():
                with open(file_in, 'w') as fin:
                    fin.write(original)

                tested_function(file_in, file_out)

                with open(file_out, 'r') as fout:
                    actual = fout.read()

                with context("Original: {}".format(repr(original))), \
                     context("Expected: {}".format(repr(expected))), \
                     context("Actual: {}".format(repr(actual))):                
                    must_be_equal(actual, expected)

        check('a', 'a', 'in.txt', 'out.txt')
        check('a\na', 'a\na')
        check('a\n\na', 'a\n\na')
        check('a\n\n\na', 'a\n\na')
        check('a\n\n\n\na', 'a\n\na')
        check('a\n  a', 'a\n  a')
        check('a\n  \na', 'a\n\na')
        check('a\n\n  a', 'a\n\n  a')
        check('a\nb\nc', 'a\nb\nc', 'original.txt', 'actual.txt')
        check('a\nb\n\nc', 'a\nb\n\nc')
        check('a\n\nb\nc', 'a\n\nb\nc')
        check('a\n\n\nb\n\n\nc', 'a\n\nb\n\nc')
        check('a\n   \n      \nb\n        \nc', 'a\n\nb\n\nc')
        check('a    \n\n\n\n\nb\n\n\n\n\nc', 'a    \n\nb\n\nc')
        check('a\n       \nc', 'a\n\nc')

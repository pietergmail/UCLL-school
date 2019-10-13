from testing import *
from testing.tests import *
from testing.assertions import *
import random
import zipfile


with scale(3), all_or_nothing(skip_after_fail=True):
    with tested_function_name("zip_contains"):
        def create_zip(zip_filename, *contained_filenames):
            with zipfile.ZipFile(zip_filename, mode='w') as zip:
                for contained_filename in contained_filenames:
                    zip.writestr(contained_filename, 'x')
                        
        @test('zip_contains should return False on empty zip')
        def _():
            create_zip('test.zip')
            must_be_falsey(tested_function('test.zip', 'foo.txt'))

        @test('zip_contains should return False on zip not containing right file')
        def _():
            create_zip('test2.zip', 'bar.txt')
            must_be_falsey(tested_function('test.zip', 'foo.txt'))

        @test('zip_contains should return True on zip containing right file')
        def _():
            create_zip('test3.zip', 'foo.txt', 'bar.txt')
            must_be_falsey(tested_function('test.zip', 'foo.txt'))
            

        

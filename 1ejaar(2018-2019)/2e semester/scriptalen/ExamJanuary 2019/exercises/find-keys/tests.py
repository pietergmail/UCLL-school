from testing import *
from testing.tests import *
from testing.assertions import *
import random


with scale(3), all_or_nothing(skip_after_fail=True):
    with tested_function_name("find_keys"):
        random.seed(15676)

        alphabet = 'abcdefghijklmnopqrstuvwxyz'

        def check(map, v, expected):
            @test("find_keys({}, {}) should return {}", repr(map), repr(v), repr(expected))
            def _():
               must_be_equal(expected, tested_function(map, v))

        def generated_test():
            map = dict()
            expected = []

            val = random.randrange(1000)
            n = random.randrange(2, 5)

            while len(map) < n:
                k = random.randrange(1000)
                expected.append(k)
                map[k] = val

            expected = sorted(list(set(expected)))

            n = random.randrange(2, 5)
            while n > 0:
                k = random.randrange(1000)
                v = random.randrange(1000)

                if k not in map and v != val:
                    map[k] = v
                    n -= 1

            check(map, val, expected)


        check( {'a': 1}, 1, [ 'a' ] )
        check( {'a': 1, 'b': 2}, 1, [ 'a' ] )
        check( {'a': 1, 'b': 2}, 2, [ 'b' ] )
        check( {'a': 1, 'b': 1}, 1, [ 'a', 'b' ] )
        check( {'a': 1, 'b': 1}, 2, [] )
        check( {1: 'a', 2: 'a', 3: 'b'}, 'a', [1, 2] )

        for _ in range(1000):
            generated_test()

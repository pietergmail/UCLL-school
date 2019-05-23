from testing import *
from testing.tests import *
from testing.assertions import *
import random


with scale(3), all_or_nothing(skip_after_fail=True):
    with tested_function_name("remove_duplicates"):
        random.seed(1356)

        def check(xs, expected):
            @test("remove_duplicates({}) should return {}", repr(xs), repr(expected))
            def _():
               must_be_equal(expected, tested_function(xs))

        def generated_test():
            xs = []
            expected = set()

            for x in range(10):
                n = random.randrange(1, 3)

                if n == 1:
                    expected.add(x)

                xs = xs + [x] * n

            random.shuffle(xs)

            check(xs, expected)


        check( [], set() )
        check( [1], {1} )
        check( [1, 1], set() )
        check( [1, 2], {1, 2} )
        check( [2, 1], {1, 2} )
        check( [2, 1, 2], {1} )
        check( [2, 1, 1], {2} )
        check( [1, 2, 3], {1, 2, 3} )

        for _ in range(100):
            generated_test()

from testing import *
from testing.tests import *
from testing.assertions import *
import random


with scale(3), all_or_nothing(skip_after_fail=True):
    with tested_function_name("successors"):
        random.seed(58111)

        def check(xs, expected):
            @test("successors({}) should return {}", repr(xs), repr(expected))
            def _():
                must_be_equal(expected, tested_function(xs))

        def generate():
            last = random.randrange(1, 99)
            xs = [last]
            expected = {}

            for _ in range(random.randrange(1, 20)):
                current = last + random.randrange(1, 10)
                xs.append(current)
                expected[last] = current
                last = current

            expected[last] = xs[0]

            check(xs, expected)

        check([], {})
        check([1], {1: 1})
        check([1, 2], {1: 2, 2: 1})
        check([1, 2, 3], {1: 2, 2: 3, 3: 1})
        check([1, 3, 2], {1: 3, 3: 2, 2: 1})

        for _ in range(1, 100):
            generate()

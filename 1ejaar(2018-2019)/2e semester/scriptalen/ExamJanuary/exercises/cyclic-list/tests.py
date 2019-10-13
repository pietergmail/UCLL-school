from testing import *
from testing.tests import *
from testing.assertions import *
import random


with scale(5), cumulative(), path('CyclicList'):
    def clist(*args):
        return tested_module().CyclicList(*args)

    def eql(xs, ys):
        return len(xs) == len(ys) and all(xs[i] == ys[i] for i in range(len(xs)))

    with path('constructor'), all_or_nothing(skip_after_fail=True):
        @test('without argument')
        def _():
            cl = clist()
            must_be_equal(0, len(cl))

        @test('with argument')
        def _():
            cl = clist([1,2,3])
            must_be_equal(3, len(cl))

    with path('indexing'), all_or_nothing(skip_after_fail=True):
        def check(xs, i, expected):
            @test('cl{}[{}] == {}', repr(xs), i, expected)
            def _():
                cl = clist(xs)
                must_be_equal(expected, cl[i])

        check([1], 0, 1)
        check([1, 2, 3], 0, 1)
        check([1, 2, 3], 1, 2)
        check([1, 2, 3], 2, 3)
        check([1, 2, 3], 3, 1)
        check([1, 2, 3], 25, 2)
        check([1, 2, 3, 4, 5], 32, 3)

    with path('add'), all_or_nothing(skip_after_fail=True):
        @test('cl[].add(1)')
        def _():
            cl = clist([])
            cl.add(1)
            must_be_truthy(eql(clist([1]), cl))

        @test('cl[1].add(2)')
        def _():
            cl = clist([1])
            cl.add(2)
            must_be_truthy(eql(clist([1, 2]), cl))

        @test('cl[1, 2].add(3)')
        def _():
            cl = clist([1, 2])
            cl.add(3)
            must_be_truthy(eql(clist([1, 2, 3]), cl))


    with path('concatenation'), all_or_nothing(skip_after_fail=True):
        @test('cl[] + cl[]')
        def _():
            xs = clist([])
            ys = clist([])
            zs = clist([])

            must_be_truthy(eql(zs, xs + ys))

        @test('cl[1] + cl[]')
        def _():
            xs = clist([1])
            ys = clist([])
            zs = clist([1])

            must_be_truthy(eql(zs, xs + ys))

        @test('cl[1] + cl[2]')
        def _():
            xs = clist([1])
            ys = clist([2])
            zs = clist([1,2])

            must_be_truthy(eql(zs, xs + ys))

        @test('cl[1,2] + cl[3,4]')
        def _():
            xs = clist([1,2])
            ys = clist([3,4])
            zs = clist([1,2,3,4])

            must_be_truthy(eql(zs, xs + ys))

    with path('is_empty'), all_or_nothing(skip_after_fail=True):
        @test('cl[].is_empty')
        def _():
            must_be_truthy(clist([]).is_empty)

        @test('cl[1].is_empty')
        def _():
            must_be_falsey(clist([1]).is_empty)

import argparse
import math
import statistics

def stats():
    parser = argparse.ArgumentParser()
    parser.add_argument('integers', type=float, nargs='+')
    parser.add_argument('-m', action='store_true')
    parser.add_argument('--min', action='store_true')
    parser.add_argument('-M', action='store_true')
    parser.add_argument('--max', action='store_true')
    parser.add_argument('--mean', action='store_true')
    parser.add_argument('--stdev', action='store_true')
    parser.add_argument('--mode', action='store_true')
    args= parser.parse_args()

    ret = ""

    if args.m or args.min:
      ret += str(min(args.integers)) + " "

    if args.M or args.max:
      ret += str(max(args.integers)) + " "

    if args.mean:
      ret += str(sum(args.integers) / len(args.integers)) + " "

    if args.stdev:
      ret += str(statistics.stdev(args.integers)) + " "

    if args.mode:
      ret += str(statistics.mode(args.integers)) + " "

    return ret[:-1]

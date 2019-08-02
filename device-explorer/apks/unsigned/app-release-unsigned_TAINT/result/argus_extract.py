#!/usr/bin/env python
from __future__ import print_function
from argparse import ArgumentParser
import re

def parse_args():
    parser = ArgumentParser()
    parser.add_argument("Result", help="Argus_Result.txt")
    # parser.add_argument("tool", help="Tool report")
    return parser.parse_args()

def extract_leaks(file):
    # sink=set()#list()
    # sinkFull = set()#list()

    source = set()
    # source = list()
    count = 0

    for line in open(file, "r"):#.readlines()):
        if 'Call@' in line:# and '<init>' not in line:
            count+=1
            methods = line.split('Call@(')
            # source.append(str(methods[1].split(')')[0]) + '\t'+str(methods[-1].split(')')[0]))
            source.add(str(methods[1].split(')')[0]) + '\t'+str(methods[-1].split(')')[0]))

        #     match = re.search(r'\sList\(Call@\((.*?)(?=,)', line)#(?=\(\))', line)
        #     matchFull = re.search(r'\sList\(Call@\((.*)', line)
        #     sink.add('Sink '+str(count)+': '+match.group(1))
        #     # sinkFull.add('Sink '+str(count)+': '+matchFull.group())
        #     # count=len(sink)
        # elif 'Source:' in line:
        #     match = re.search(r'(?<=api_source:\s)(.*?)(?=\(\))', line)
        #     source.add('Source '+str(count)+': '+match.group(1))
        #     # sourceFull.add('Source '+str(count)+': '+match.group())
        #     count=len(source)
        else:
            continue
    if not source:
        source.add("No leaks found")
        # source.append("No leaks found")
        # sink.add("No leaks found")
    # print ("source:",len(source), "sink:", len(sink))
    # print(sink)
    # list1=list(sink)

    list2=list(source)

    # for i in range(0,len(source)):
    #     print(i+1,'source:',source[i], source[i+1],'\t\tsink:',sink[i], sink[i+1])

    #
    # list3=list()
    # for i in range(len(list1)):
    #     list3.append(list1[i]+'\t'+list2[i])
    #     print(list3[i])

    for item in list2:
    # for item in source:
        print (item)
    print("Number of leaks:", count)
    print("number of unique leaks:", len(list2))
    # print("number of unique leaks:", len(source))

    # print(len(list1), len(list2), count)
    #
    # return list3

def main():
    args = parse_args()
    leaks = extract_leaks(args.Result)
    # print(leaks)

if __name__ == '__main__':
    main()

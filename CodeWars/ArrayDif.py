# Difficulty 6 kyu
#Your goal in this kata is to implement an difference function, which subtracts one list from another.
#It should remove all values from list a, which are present in list b.
#
# @author Nick Pierre
#
def array_diff(a, b):
    return [x for x in a if x not in b]
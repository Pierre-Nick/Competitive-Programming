def last_digit(n1, n2):
    print "Testing %d and %d" % (n1, n2)
    digits = []
    exp = 1
    if n2 == 0: return 1
    elif n2 == 1: return int(str(n1)[-1])
    while True:
        last_dig = int(str(n1**exp)[-1])
        if last_dig not in digits:
            digits.append(last_dig);
        else:
            if len(digits) == 1 and digits[0] == 0 :
                print digits
                return digits[0]
            index = (n1%4) - 1
            print "Looking for %d index and size of list is %r" % (index, len(digits))
            return digits[index]
        exp += 1


print last_digit(4, 1)
print last_digit(4, 2)
print last_digit(9, 7)
print last_digit(10, 10 ** 10)
print last_digit(2 ** 200, 2 ** 300)

for num in range(1, 9):
    a = num ** num
    print "Testing %d and %d" % (a, 0)
    last_digit(a, 0)



print last_digit(3715290469715693021198967285016729344580685479654510946723, 68819615221552997273737174557165657483427362207517952651)
def pidgeyToCandy(pidgey, candy):
    pass


def pidgeyCalc(pidgey, candy):
    expSum = 0

    if candy < 12:
        candy_needed = 12 - candy
        if pidgey > candy_needed:
            candy += candy_needed
            pidgey -= candy_needed
            print "There was a difficiency from the start"
            print '*' * 29
            print "*\t Candy was %d now %d \t*" % ((candy - candy_needed), candy)
            print "*\t Pidgey was %d now %d \t*" % ((pidgey + candy_needed), pidgey)
            print '*' * 29
            print '\n'
        else:
            return expSum

    while candy >= 12 and pidgey > 0:
        print "Attempting a new Evolution from our %d pidgeys" % pidgey
        expSum += 500
        candy -= 11
        # candy += 1
        pidgey -= 1
        print "Evoled a Pidgey. Candy: %d \t Pidgey: %d" % (candy, pidgey)
        if candy < 12:
            candy_needed = 12 - candy
            if pidgey > candy_needed:
                candy += candy_needed
                pidgey -= candy_needed
                print "Converted %d pidgeys to Candy. Candy is now %d" % (candy_needed, candy)
            else:
                break
        print "EXP: %d" % expSum

    return expSum


print pidgeyCalc(1, 63)
print pidgeyCalc(10, 63)
# print pidgeyCalc(0, 0)

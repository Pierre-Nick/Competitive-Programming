# Difficulty: 4 kyu
#
# Business Rules:
# 
# A user starts at rank -8 and can progress all the way to 8.
# There is no 0 (zero) rank. The next rank after -1 is 1.
# Users will complete activities. These activities also have ranks.
# Each time the user completes a ranked activity the users rank progress is updated based off of the activity's rank
# The progress earned from the completed activity is relative to what the user's current rank is compared to the rank of the activity
# A user's rank progress starts off at zero, each time the progress reaches 100 the user's rank is upgraded to the next level
# Any remaining progress earned while in the previous rank will be applied towards the next rank's progress (we don't throw any progress away). 
# The exception is if there is no other rank left to progress towards (Once you reach rank 8 there is no more progression).
# A user cannot progress beyond rank 8.
# The only acceptable range of rank values is -8,-7,-6,-5,-4,-3,-2,-1,1,2,3,4,5,6,7,8. Any other value should raise an error.
# The progress is scored like so:
# 
# Completing an activity that is ranked the same as that of the user's will be worth 3 points
# Completing an activity that is ranked one ranking lower than the user's will be worth 1 point
# Any activities completed that are ranking 2 levels or more lower than the user's ranking will be ignored
# Completing an activity ranked higher than the current user's rank will accelerate the rank progression. The greater the difference 
# between rankings the more the progression will be increased. The formula is 10 * d * d where d equals the difference in ranking between the activity and the user.
#

class User(object):
    def __init__(self):
        self.rank = -8
        self.progress = 0
  
    def inc_progress(self, kata):
        print "Attempting a Kata of %r at %d rank" % (kata, self.rank)
        if kata > 8 or kata < -8 or kata == 0:
            self.error(kata)
        elif not (self.rank - 2 >= kata) and self.rank < 8:
            if self.rank - 1 == kata:
                self._boost(1)
            elif self.rank == kata:
                self._boost(3)
        else:
            self._boost(10 * (kata - self.rank) * (kata - self.rank))
  
    def _boost(self,points):
        print "Big points %d" % points
        print 'Progress starting at %d' % self.progress
        while self.progress + points >= 100:
            if self.rank == 0: self.rank += 1
            if not (self.rank >= 8): self.rank += 1
            diff = 100 - self.progrogree
            self.progress = (self.progress + diff) % 100
            points -= diff
            print '*' * 5
            print 'Cashing in %d points' % points
            print 'Progress is at %d' % self.progress
            print 'Rank is %d:' % self.rank
        self.progress += points

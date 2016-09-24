
# Difficulty: 4 Kyu
#
# Write a function called validBraces that takes a string of braces, and determines if the order of the braces is valid. validBraces should return true if the string is valid, and false if it's invalid.
# 
# This Kata is similar to the Valid Parentheses Kata, but introduces four new characters. Open and closed brackets, and open and closed curly braces. Thanks to @arnedag for the idea!
# 
# All input strings will be nonempty, and will only consist of open parentheses '(' , closed parentheses ')', open brackets '[', closed brackets ']', open curly braces '{' and closed curly braces '}'.
# 
# What is considered Valid? A string of braces is considered valid if all braces are matched with the correct brace. 
# For example:
# '(){}[]' and '([{}])' would be considered valid, while '(}', '[(])', and '[({})](]' would be considered invalid.
#
# @author: Nick Pierre

braces = {
  '(' : ')',
  '[' : ']',
  '{' : '}'
}
def validBraces(string):
  stack = []
  for i in string:
    if len(stack) == 0:
         stack.append(i)
    else:
        peek = stack.pop()
        if peek in braces.keys():
            if i == braces[peek]:
                continue
            else:
                stack.append(peek)
                stack.append(i)
        else:
            return False
                
    while len(stack) > 0:
        peek = stack.pop()
        if (braces[stack.pop()] != peek):
            return False
        return True


print validBraces('(]')
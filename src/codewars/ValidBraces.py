braces = {
    '(': ')',
    '[': ']',
    '{': '}'
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


string = 'Go'
print string[1]

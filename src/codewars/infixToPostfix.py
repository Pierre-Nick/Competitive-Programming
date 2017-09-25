paren = { '(' , ')' }
symbols = ['*', '-', '+', '/', '^']
symbol_stack = []
dig_stack = []	
post = ""

def to_postfix(infix):

	for i in infix:
		if len(symbol_stack) == len(dig_stack) == 0:
			dig_stack.append(i) if i.isdigit() else symbol_stack.append(i)
		else:
			if check_closing_parenth(i):
				
			else:
				if i.isdigit():
					dig_stack.append(i)
				elif i in symbols:
					symbol_stack.append(i)


	return post

def check_closing_parenth(i):
	done = False

	if not (i.isdigit()) and not (i in symbols):
		if i in paren.values():
			while len(dig_stack > 0):
				post += dig_stack.pop(0)



to_postfix("4*2")
print symbols.pop(0)
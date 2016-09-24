import re

strs = 'Ok, Ook, Ooo? Okk, Ook, Ok? Okk, Okk, Oo? Okk, Okk, Oo? Okk, Okkkk!'


dict = { 
    'Ok, Ook, Ooo' : 'H',
    'Okk, Ook, Ok' : 'e',
    'Okk, Okk, Oo' : 'l',
    'Okk, Okkkk' : 'o',
    'Ok, Ok, Okkk' : 'W',
    'Okk, Okkkk' : 'o',
    'Okkk, Ook, O' : 'r',
    'Okk, Okk, Oo' : 'l',
    '' : 'd',
    'Ook, Ooook!' : '!'

}

def test(str): 
	index = 0
	list = []
	regex = re.compile('[?]')
	while str[index] != '!':
		if regex.match(str[index]):
			list.append(str[0:index])
			str = str[index+2: len(str)]
			index = 0
		else:
			index += 1
	list.append(str[0:-1])
	print list

	return ''.join(dict[x] for x in list)


print test(strs)


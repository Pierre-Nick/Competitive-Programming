import string

def play_pass(s, n):
	print 'testing: %s' % s
	shift = ''
	for i in range (0, len(s)):
		if s[i].isalpha():
			old_char_index = string.ascii_uppercase.index(s[i])
			if i % 2 != 0:
				shift += string.ascii_lowercase[(old_char_index + n) % 26]
			else:
				shift += string.ascii_uppercase[(old_char_index + n) % 26]
		elif s[i].isdigit():
			old_num_index = string.digits.index(s[i])
			shift += string.digits[(-1) * n]
		else:
			shift += s[i]
	s = ''
	for i in shift[::-1]:
		s += i

	return s

print play_pass("MY GRANMA CAME FROM NY ON THE 23RD OF APRIL 2015", 2)
#print string.ascii_uppercase.index('B')
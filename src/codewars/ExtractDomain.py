stop_char = {'.','/',}

def domain_name(url):
	print url
	i =  url.rfind(".com") - 1
	new_url = ''
	while url[i] not in stop_char:
		new_url += url[i]
		i -= 1
	return new_url[::-1]

domain_name("https://www.cnet.com")
print "https://www.cnet.com".rfind('.')
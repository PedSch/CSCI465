 #Pedro Schmidt
#CSCI 465
#LEXICAL ANALYZER

import fileinput
import re
import os.path
import pandas as pd 

#this ask user for a file input and  will look for it , if not found print out an error
filename = input('Please enter a filename : ')   #rading keyboard input
print("User Input : ", filename)                 #printing keyboard input
fileinput = "input.txt"             #opening file and reading 

try:          
	with open(fileinput)as file:
		data = file.readlines()
	print('Printing File and Error Checking ')
	for line in data:
		#ID
		reserved_words =  "<input>, <print, <begin>, <end>, <if>,<else>"
		if re.search("^[a-zA-Z_]+\\w*\\d*",line,re.I):
			assignToken()
			print ('<ID>',line)
		else:
			print('!ERROR  ID!')
		#rel_op
		if re.search("(<|>|<=|>=|==|!=|\\+|-|\\*|/)",line,re.I):
			print ('<rel_op>',line)
		else:
			print('!ERROR  rel_op!')
		#comment
		if re.search("^#+.*", line, re.I):
			print ('<comment>' ,line)
		else:
			print('!ERROR  Comment!')
		#number
		if re.search("(\\+|-)?\\d+(\\.\\d+)?", line, re.I):
			print ('<number>',line)
		else:
			print('!ERROR  Number!')
		words = line.split()
		print (words , end='' )
except IOError as e:
	print(e)
	#keep preset values

 #Pedro Schmidt
#CSCI 465
#LEXICAL ANALYZER

import fileinput
import re
import os.path
import pandas as pd 

#reserved words
def assignToken():				#block
#string = '<input>, <print>, <begin>, <end>, <if>,<else>'
	token = ' ' 				 #decl
	white_space = ''			 #decl
	lexeme= ' '					 #decl
	i = 0						
	if token == 'input':
		print("<input>" + token)
	if token == 'print':
		print("<print>" + token)
	if token == 'begin':
		print("<begin>" + token)
	if token == 'end':
		print("<end>" + token)
	if token == 'if':
		print("<if>" + token)
	if token == 'else':
		print("<else>" + token)
	else:
		if token != white_space:
			lexeme += token # adding a char each time
		if (i+1 < len(token)): # prevents error
			if token[i+1] == white_space or token[i+1] in KEYWORDS or lexeme in KEYWORDS: # if next char == ' '
				if lexeme != '':
                    
					print(lexeme.replace('\n', '<newline>'))
					lexeme = '' 
                    
#end of assignToken
#this ask user for a file input and  will look for it , if not found print out an error
filename = input('Please enter a filename : ')   #rading keyboard input
print("User Input : ", filename)                 #printing keyboard input
fileinput = "input.txt"             #opening file and reading 

try:         
	with open(fileinput)as file:
		data = file.readlines()
	print('Printing File and Error Checking ')
	for line in data:
		dfObj = pd.DataFrame(line, columns= ['LEXEME', 'SPELLING'] , index = ['ID','rel_op','comment','number'])
		LEXEME = "'ID','rel_op','comment','number'"
		#SPELLING = "program example(input,output);var x,y:integer;function gcd(a,b:integer):integer;begin{gcd}if b=0then gcd:=a else gcd:=(b,a mod b)end;{gcd}begin{example}read(x,y);write(gcd(x,y));end.
 #" 
		print ("Dataframe : " , dfObj, sep='\n')
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
    #table_data = [['LEXEME','SPELLING'],]
   # for row in table_data:
       # print("{: >20} {: >20}".format(*row))

except IOError as e:
	print(e)
	#keep preset values

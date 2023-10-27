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
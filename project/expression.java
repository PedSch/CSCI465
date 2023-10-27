package hw1;
import java.util.regex.*;
import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class expression
{
   //private term objT = new term(); //INSTANCE OF CLASS term
  // private add obja = new add(); //INSTANCE OF CLASS multiply
   //private subtract objs = new subtract();  // instance of class divide 
   //private addop objaddop = new addop();  // instance of class mulop
   
   void expression(/*LinkedList<Token> tokens*/)
   {  
   //objT.term(); //Call to method term
   String addop = "[ ’+ ’ ,  ’−’ ]";
   Scanner reader = new Scanner (System.in);
   char operator = reader.next().charAt(0);
   Pattern p = Pattern.compile("term");   // the pattern to search for
	Matcher match = p.matcher(addop); // [ ’+ ’ ,  ’−’ ]
   
	while (match.find())
			 {				
			   if (match.find())
             {
					//begin 
            
				emitln  ("MOVED0,−(SP)") ; // -sp is a push //emitln() adds specified content 
				switch (operator)
             {
				case '+':
					
					//obja.add(); //Call to method multipy					
				break;
				
				case '-':
					
				//objs.subtract(); //Call to method multipy	
            					 
			     break;
               default:
				   } //end switch
            } //end if 
			  else
			   {
				 Expected();
					} //end else 
       } //end while
       //return tokens; 
	} //end expr
   

  void emitln (String s)
   {
      emitln (s);     
   }
 
 void Expected ()
  {  
    System.out.println ("Expected 'addop'");
    System.exit(0); 
  }

} //end class expression
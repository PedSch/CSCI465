package hw1;
import java.util.regex.*;
import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class mulop
	{
      
      //private factor objF = new factor(); //INSTANCE OF CLASS FACTOR 
      
      public void multiply(/*LinkedList<Token> tokens*/)
      {
		//begin
         final String txt = "*";
         System.out.println(txt.matches( "*" ));
			//objF.factor(); //Call to method FACTOR
			emitln("MULS(SP)+ ,D0");
		//end; 	
      //return tokens;	
	   } //end multiply
      
      void divide(/*LinkedList<Token> tokens*/)
      {
		//begin
      final String txt = "/";
      System.out.println(txt.matches( "/" ));
		//objF.factor(); //Call to method FACTOR
		emitln ("’MOVE(SP)+ ,D1 ’ ");
		emitln ("'DIVSD1,D0'");
	//end
   //return tokens;
	} //end divide

   void emitln (String s)
   {
      emitln (s);     
   }
   
}//end mulop class
 
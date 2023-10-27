package hw1;
import java.util.regex.*;
import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class subtract
{
   //private term objT = new term(); //INSTANCE OF CLASS term
   
   void subtract(/*LinkedList<Token> tokens*/)
   {
	//begin 
	 final String txt = "-";
   System.out.println(txt.matches( "-" ));
	//objT.term(); //Call to method term
	emitln ("SUB(SP)+ ,D0") ;
	emitln("EGD0 ");
	//end
   }
   
   void emitln (String s)
   {
      emitln (s);     
   }

} //end subtract

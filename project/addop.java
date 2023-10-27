import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class addop
{
   private term objT = new term(); //INSTANCE OF CLASS term
   
   void add(/*LinkedList<Token> tokens*/)
   {
	//begin
   final String txt = "+";
   System.out.println(txt.matches( "+" ));
	objT.term(); //Call to method term
	emitln("ADD(SP)+ ,D0 ");
	//end
   //return tokens;
   } //end add
   
   void subtract(/*LinkedList<Token> tokens*/)
   {
	//begin 
	 final String txt = "-";
   System.out.println(txt.matches( "-" ));
	objT.term(); //Call to method term
	emitln ("SUB(SP)+ ,D0") ;
	emitln("EGD0 ");
	//end
   //return tokens;
   } //end subtract
    void emitln (String s)
   {
      emitln (s);     
   }
}//end addop

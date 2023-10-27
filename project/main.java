import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.LinkedList ;

class main
{
    public static void main(String[] args) 
    {
      LinkedList<Token> tokens = new LinkedList<Token>();
 
      String s = "";
     
      parser symbol = new parser();    //create symbol object
      symbol.symbolTable();            // call symbol table method
      //parser list = new parser();
      //symbol.makeLinkedList(); 
      
      //factor
      factor fac = new factor();       //create token object
      fac.factor();                    // call factor
      fac.GetNum();                    //call GetNum
      fac.emitln('s');                    //call emitln
      //mulop
      mulop mul = new mulop();         //call mulop object
      mul.multiply();                  //call multiply
      mul.divide();
      mul.emitln(s);
      //term
      term ter = new term();           //call term object
      ter.term();
      ter.emitln(s);
      ter.Expected();
      //addop
      addop ad = new addop();          //call addop object
      ad.add();
      ad.subtract();
      ad.emitln(s);
      //expression
      expression expr = new expression();
      expr.expression();
      expr.emitln(s);
      expr.Expected();
      System.out.print("\n return list " + tokens);
    }


}

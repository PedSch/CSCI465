import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.LinkedList ;

class parser 
{
     void symbolTable() 
    {
        LinkedList<Token> tokens = new LinkedList<Token>();
    }
    
     void  makeLinkedList(LinkedList<Token>tokens) 
    {
         
        try 
        {
            File lexOutput = new File("lexOutput.txt");
            Scanner reader = new Scanner(lexOutput);
            while(reader.hasNext()) 
            {
                String data = reader.nextLine();
                String[] dataSplit = data.split("\\t+"); //Change lexer output to tabs
                Token token = new Token();
                token.setLexeme(dataSplit[0]);
                token.setToken(dataSplit[1]);

                tokens.add(token);
            } //end while 
        }// end try 
         catch (FileNotFoundException e) 
         {
            System.out.println("Lexer file not found.");
            e.printStackTrace();
            
         } //end catch
      
    //  return tokens;
    } //end make linked list
    
}//end parser 

class Token {
    String lexeme;
    String token;

    void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    void setToken(String token) {
        this.token = token;
    }

    String getLexeme() {
        return this.lexeme;
    }

    String getToken() {
        return this.token;
    }
}

class factor 
	{
   private static int num = 0; //global variable
   public void factor(/*LinkedList<Token> tokens*/)
   {
     
      //begin
      char f1;
      f1 = 0 ; 
      System.out.printf(" MOVE #%d,D0",f1 , GetNum());
		emitln(f1); //  where EmitLn is *
		//end 
	}
   public static int GetNum()
	{
		return num;
	}
   void emitln (char s)
   {
      emitln (s);     
   }
     
} //end factor class  

class mulop
	{
      
      private factor objF = new factor(); //INSTANCE OF CLASS FACTOR 
      
      public void multiply(/*LinkedList<Token> tokens*/)
      {
		//begin
         final String txt = "*";
         System.out.println(txt.matches( "*" ));
			objF.factor(); //Call to method FACTOR
			emitln("MULS(SP)+ ,D0");
		//end; 	
      //return tokens;	
	   } //end multiply
      
      void divide(/*LinkedList<Token> tokens*/)
      {
		//begin
      final String txt = "/";
      System.out.println(txt.matches( "/" ));
		objF.factor(); //Call to method FACTOR
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
 class term 
	{
      
      private factor objF = new factor(); //INSTANCE OF CLASS FACTOR 

      private multiply objm = new multiply(); //INSTANCE OF CLASS multiply

      private divide objd = new divide();  // instance of class divide 
      
      private mulop objmulop = new mulop();  // instance of class mulop
      
     void term(/*LinkedList<Token> tokens*/)
      {	
       //begin
		objF.factor(); //Call to method FACTOR
      Scanner reader = new Scanner (System.in);
		char operator = reader.next().charAt(0);
      String mulop = "[ ’∗’ ,  ’ / ’ ]";
      Pattern p = Pattern.compile("term");   // the pattern to search for
		Matcher match = p.matcher(mulop); // "[ ’∗’ ,  ’ / ’ ]"
     
		   while (match.find())
			 {				
			   if (match.find())
             {
					//begin 
					emitln ("MOVED0,−(SP)"); // -sp is a push //emitln() adds specified content 
					switch (operator)
               {
					case '*':						
					objm.multiply(); //Call to method multipy						
					break;					
					case '/':
				   objd.divide(); //Call to method multiply						 
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
	} //end term 
     
  void emitln (String s)
   {
      emitln (s);     
   }
   
    void Expected()
  {  
    System.out.println ("Expected 'Mulop'");
    System.exit(0); 
  }
} // end term class

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
 class expression
{
   private term objT = new term(); //INSTANCE OF CLASS term
   private add obja = new add(); //INSTANCE OF CLASS multiply
   private subtract objs = new subtract();  // instance of class divide 
   private addop objaddop = new addop();  // instance of class mulop
   
   void expression(/*LinkedList<Token> tokens*/)
   {  
   objT.term(); //Call to method term
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
					
					obja.add(); //Call to method multipy					
				break;
				
				case '-':
					
				objs.subtract(); //Call to method multipy	
            					 
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

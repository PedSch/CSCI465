import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.Scanner; 


class cradle
{
char Look;  ///look ahead 
final char  Tab = '\t' ; //global variable
Scanner sc = new Scanner(System.in);
//main
 public static void main(String[] args)
{
   String [] exp = {"231*+9-"};
   cradle main = new cradle();
   stack mains = new stack();
   main.init();
   main.expression();
   mains.main(exp);
}
void init()
{
   getChar();
}
//parsing 
void term()
{
   emitln(" MOVED0,D1 ’");
   getNum();
}
void add()
   {
   match('+');                      //call method match 
   term();               //Call to method term
   emitln ("ADDD1,D0 '"); 
   //return tokens   
   } //end add 
void subtract()
   {
   match('-');                      //Call to method term
   term();               //Call to method term
	emitln ("SUB(SP)+ ,D0") ;
	emitln("EGD0 ");
	//end
   //return tokens
   } //end subtract      
void expression()
{
   term();
   Scanner reader = new Scanner (System.in);
   char operator = reader.next().charAt(0);
   char look = ' ';
   emitln(" MOVED0,D1 ’");
   getNum();
   switch (operator)
   {
   case '+':
   add();
   break;
   case '-':
   subtract();
   break;
   default:
   } //end switch
   //else
   Expected("addop");
 }  //end expression
  // componenets 
void emitln (String s)
   {
      char w = 'w';
      emit (s); 
      write(w,s);   
   } 
 void emit (String s)
{
  write(Tab ,s);
   
}
 void match( char x )
  {
   char Look = x ; 
   
   if (Look == x )
   {
      getChar();
   }
   else 
   {
      Expected("");
   }     
  } //end match
 void getChar()
   {
      char Look[] = new char [26];
      //read(Look);
      //String str = " ";
      //char ch1 = str.charAt(0);
      //System.out.println("Character at 0 index is: "+ Look);
   } //end get char 
public int getNum()
{
  char look = 'c';
  int number = 0 ;
  double number2 = 0.0;
  //double number;
      do
       {
          if (isDigit(look))
         {
             //getNum();
             getChar();
             number = sc.nextInt();
             number2 = sc.nextDouble();
          }
          else 
            {
             Expected("integer");
            }
       }
        while ((number < 1) || (number > 10));  //error trap
         return number;  //return the number to main                
}//end getnum
public boolean isDigit (char c)
{

if (c >= '0' && c <= '9');
{
   Character.isDigit(c);
}
//int index = 9;
//Character.isDigit(String.charAt(index));
//isDigit(c);
return true;
}
public boolean isAlpha( char c ) 
{
   
   if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
   //{
      //System.out.print(Character.isLetter(c));
      //Character.isLetter(String.charAt(c));
  // }
   return true;
}
void Error (String s)
{
   emitln ("^G,  ’ Error :’ , s ,  ’ . ’");
 } // end error 
 void Abort (String s)
 {
   Error(s);
   //Halt;
 }// end abort 
//report what was expected 
void Expected (String s)
  {  
   Abort (s + "Expected 'addop'");
   // System.out.println ("Expected 'addop'");
   // System.exit(0); 
  } //end abort 
void write(char w , String r) 
 {
   Writer writer = new PrintWriter(System.out); 
    }
 } //end cradle
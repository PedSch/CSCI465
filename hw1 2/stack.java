import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.Stack; 
  
public class stack  
{ 
    // Method to evaluate value of a postfix expression 
    static int evaluatePostfix(String exp) 
    { 
        //create a stack 
        Stack<Integer> stack=new Stack<>(); 
          
        // Scan all characters one by one 
        for(int i=0;i<exp.length();i++) 
        { 
            char c=exp.charAt(i); 
              
            // If the scanned character is an operand (number here), 
            // push it to the stack. 
            if(Character.isDigit(c)) 
            stack.push(c - '0'); 
              
            //  If the scanned character is an operator, pop two 
            // elements from stack apply the operator 
            else
            { 
                int val1 = stack.pop(); 
                int val2 = stack.pop(); 
                  
                switch(c) 
                { 
                    case '+': 
                    stack.push(val2+val1); 
                    //return 1;
                    break; 
                     
                    case '-': 
                    stack.push(val2- val1); 
                    //return 2;
                    break; 
                      
                    case '/': 
                    stack.push(val2/val1); 
                    //return 3;
                    break; 
                      
                    case '*': 
                    stack.push(val2*val1);
                    //return 4; 
                    break; 
                    case '(': 
                    case ')': 
                    case '#':
                    //return 1; 
                   break; 
                  }
               } 
            }
        return stack.pop();     
    } 
      
    // Driver program to test above functions 
    public static void main(String[] args)  
    { 
        String exp="231*+9-"; 
        stack staxx = new stack();
        staxx.evaluatePostfix(exp);

        System.out.println("postfix evaluation: "+evaluatePostfix(exp)); 
    } 
} 
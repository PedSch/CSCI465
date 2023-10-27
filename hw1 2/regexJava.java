//Riley Dopkins
//CSCI 465
//Assignment 1: Lexical Analyzer

import java.util.regex.*;
import java.util.*;
import java.io.*;

class CompleteToken {
  private String type;
  private String token;
  private int line;
  private int linePos;

  void CompletedToken(String type, String token, int line, int linePos) {
    this.type = type;
    this.token = token;
    this.line = line;
    this.linePos = linePos;
  }

  int getTokenPos() {
    return linePos;
  }

  String getTokenType() {
    return type;
  }

  int getTokenLine() {
    return line;
  }

  String getTokenToken() {
    return token;
  }
}

public class regexJava {
  public static void main (String[] args) throws FileNotFoundException, IOException {
     Scanner input = new Scanner(System.in);
     System.out.println("Please enter the file name to be scanned: ");
     String fileName = input.next();
     LineNumberReader r = new LineNumberReader(new FileReader(fileName));
     String l;

     String relOp = "(<|>|<=|<>|>=|=|\\+|-|\\*|:=|:|;|,|\\(|\\[|\\]|\\)|\\.)";
     String assignMent = "=";
     String reserved2 = "(and|array|begin|char|chr|div|do|else|end|if|integer|mod|not|of|or|ord|procedure|program|read|readln|then|var|while|write|writeln)";
     String commentPattern = "^//+.*";
     String nums = "(\\+|-)?\\d+(\\.\\d+)?";
     String quoteString = "'.*'";
     String litChar = "'\\w'";
     String errorGex = "(^\\d+[a-zA-Z]|\\{|\\}|\\/)";

     Pattern idPattern = Pattern.compile("([a-zA-Z]+\\w*\\d*)");
     Pattern reservedPattern = Pattern.compile(reserved2);
     Pattern rel_op = Pattern.compile(relOp);
     Pattern comment = Pattern.compile(commentPattern);
     Pattern quotePattern = Pattern.compile(quoteString);
     Pattern charPattern = Pattern.compile(litChar);
     Pattern errorPattern = Pattern.compile(errorGex);
     Pattern numPattern = Pattern.compile(nums);
     Matcher match;
     String token;

    ArrayList<CompleteToken> obj = new ArrayList<CompleteToken>();
    int numTokens = 0;
    while ((l = r.readLine()) != null) {

    
     Scanner read = new Scanner(l);
     while (read.hasNext()) {
        int line = 0;
        boolean f = false;
        boolean reserved;
        token = read.next();
        
        match = idPattern.matcher(token);
        while(match.find()) {
          reserved = false;
          String[] reservedWords = {"and","array","begins","char","chr","div","do","else","end","if","integer","program","mod","not","of","or","ord","procedure","read","readln","then","var","while","write","writeln"};
          String matchedToken = match.group(0);

          for(int i = 0; i < reservedWords.length; i++) {
            if(matchedToken.equals(reservedWords[i])) {
              //System.out.println(reservedWords[i].toUpperCase() + "      " +token);
              CompleteToken object = new CompleteToken();
              line = r.getLineNumber();
              object.CompletedToken(reservedWords[i].toUpperCase(),matchedToken,line,match.start());
              obj.add(object);
              reserved = true;
              f = true;
            }
          }
          
          if (reserved == false) {
            //System.out.println("ID   " + matchedToken + "  line: "+line+" position: " +match.start() + " to " + match.end());
            CompleteToken object = new CompleteToken();
            line = r.getLineNumber();
            object.CompletedToken("ID",matchedToken,line,match.start());
            obj.add(object);
            f = true;
          }
          
          
        }

        match = numPattern.matcher(token);
        while(match.find()) {
          System.out.println("NUMBER "+token);
          String matchedToken = match.group(0);
          CompleteToken object = new CompleteToken();
          line = r.getLineNumber();
          object.CompletedToken("NUMBER",matchedToken,line,match.start());
          obj.add(object);
          f = true;
        }
        
        match = rel_op.matcher(token);
        while (match.find()) {
          String[] operations = {"<",">", "<>","<=",">=","=","+","-","*",":=",":",";",",","(","[","]",")","."};
          String[] names = {"LESSER","GREATER","NOTEQUAL","LESSEREQUAL","GREATEREQUAL","EQUAL","PLUS","MINUS","TIMES","ASSIGN","COLON","SEMICOLON","COMMA","LPAREN","LBRACK","RBRACK","RPAREN","PERIOD"};

          for(int j = 0; j < operations.length; j++) {
            if(match.group(0).equals(operations[j])) {
              CompleteToken object = new CompleteToken();
              line = r.getLineNumber();
              object.CompletedToken(names[j],match.group(0),line,match.start());
              obj.add(object);
              f = true;
            }
          }
          
        }

        match = comment.matcher(token);
        if(match.find()) {
          break;
        }

        match = quotePattern.matcher(token);
        while (match.find()) {
          CompleteToken object = new CompleteToken();
          line = r.getLineNumber();
          object.CompletedToken("STRING",match.group(0),line,match.start());
          obj.add(object);
          f = true;
        }

        match = charPattern.matcher(token);
        while (match.find()) {
          CompleteToken object = new CompleteToken();
          line = r.getLineNumber();
          object.CompletedToken("LITCHAR",match.group(0),line,match.start());
          obj.add(object);
          f = true;
        }

        match = errorPattern.matcher(token);
        while(match.find()) {
          CompleteToken object = new CompleteToken();
          line = r.getLineNumber();
          object.CompletedToken("ERROR",token,line,match.start());
          obj.add(object);
        }
        
    }
  }
  arrangeTokens(obj);
  printFile(obj);
    
//input|print|begin|end|if|else|for
  }

  static void arrangeTokens(ArrayList<CompleteToken> obj) {
    boolean sorted = false;
    int temp;
    while(!sorted) {
      sorted = true;
      
      for (int i = 0; i < obj.size() - 1; i++) {
        CompleteToken tok1 = obj.get(i);
        CompleteToken tok2 = obj.get(i+1);
        int line1 = tok1.getTokenLine();
        int line2 = tok2.getTokenLine();
        int pos1 = tok1.getTokenPos();
        int pos2 = tok2.getTokenPos();
        int final1 = line1 * 10000 + pos1;
        int final2 = line2 * 10000 + pos2;
        if (final1 > final2) {
          obj.set(i, tok2);
          obj.set(i+1, tok1);
          sorted = false;
        } 
         
      }
    }
  }

  static void printFile(ArrayList<CompleteToken> obj) throws IOException {
   
    File myFile = new File("lexOutput.txt");
    FileWriter writer = new FileWriter("lexOutput.txt");
    String type;
    String token;
    writer.write("LEXEME                SPELLING" + "\n");
    for (int i = 0; i < obj.size(); i++) {
      CompleteToken temp = obj.get(i);
      type = temp.getTokenType();
      token = temp.getTokenToken();
      if (type.equals("ERROR")) {
        //write line num
        writer.write("Illegal at line: " + temp.getTokenLine() + " column: " + temp.getTokenPos() + " spelling: " + token + "\n");
      } else {
        writer.write(type + "               " + token + "\n");
        //System.out.println(type + "               " + token);
      }
      
    }
    writer.write("EOF                         EOF" + "\n");
   
    writer.flush();
    writer.close();
    
  }

}


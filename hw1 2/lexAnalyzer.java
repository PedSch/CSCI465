//Riley Dopkins
//CSCI465
import java.io.*;
import java.util.*;

import javax.swing.SwingUtilities;

public class lexAnalyzer {
    
	ArrayList<String> tokens = new ArrayList();
	ArrayList<int[]> positions = new ArrayList();
	
    public void Data() {
        
        readFile();
        //print(tokens);
        countRowAndCharacter();
        for(int i=0;i<tokens.size();i++) {
        	
        }
        for (int i = 0, count = 0; i < positions.size(); i++, count++) {
        	if(tokens.get(i).equals(" ")) {
        		continue;
        	}
        	if(tokens.get(i).equals("\\n")){
        		continue;
        	}
        	else {
        		//System.out.println(tokens.get(i) +" "+Arrays.toString(positions.get(count)));
        		if(tokens.get(i).toString().equals(";")) {
            		System.out.println(tokens.get(i).toString()+" SEMInumber"+" "+convert(positions.get(count)));
            		continue;}
            	if(tokens.get(i).toString().equals(":")) {
            		System.out.println(tokens.get(i).toString()+" COLONnumber"+" "+convert(positions.get(count)));
            		continue;}
            	if(tokens.get(i).toString().equals(",")) {
            		System.out.println(tokens.get(i).toString()+" COMMMAnumber"+" "+convert(positions.get(count)));
            		continue;}
            	if(tokens.get(i).toString().equals(".")) {
            		System.out.println(tokens.get(i).toString()+" DOTnumber"+" "+convert(positions.get(count)));
            		continue;}
            	if(tokens.get(i).toString().equals("(")) {
            		System.out.println(tokens.get(i).toString()+" LPARENnumber"+" "+convert(positions.get(count)));
            		continue;}
            	if(tokens.get(i).toString().equals(")")) {
            		System.out.println(tokens.get(i).toString()+" LPARENnumber"+" "+convert(positions.get(count)));
            		continue;}
            	if(tokens.get(i).toString().equals("<")) {
            		System.out.println(tokens.get(i).toString()+" LTnumber"+" "+convert(positions.get(count)));
            		continue;}
            	if(tokens.get(i).toString().equals(">")) {
            		System.out.println(tokens.get(i).toString()+" GTnumber"+" "+convert(positions.get(count)));
            		continue;}
            	if(tokens.get(i).toString().equals("=")) {
            		System.out.println(tokens.get(i).toString()+" EQnumber"+" "+convert(positions.get(count)));
            		continue;}
            	if(tokens.get(i).toString().equals("-")) {
            		System.out.println(tokens.get(i).toString()+" MINUSnumber"+" "+convert(positions.get(count)));
            		continue;}
            	if(tokens.get(i).toString().equals("+")) {
            		System.out.println(tokens.get(i).toString()+" PLUSnumber"+" "+convert(positions.get(count)));
            		continue;}
            	if(tokens.get(i).toString().equals("'")) {
            		System.out.println(tokens.get(i).toString()+" TIMESnumber"+" "+convert(positions.get(count)));
            		continue;}
            	if(tokens.get(i).toString().equals("..")) {
            		System.out.println(tokens.get(i).toString()+" DOTDOTnumber"+" "+convert(positions.get(count)));
            		continue;}
            	if(tokens.get(i).toString().equals(":=")) {
            		System.out.println(tokens.get(i).toString()+" COLEQnumber"+" "+convert(positions.get(count)));
            		continue;}
            	if(tokens.get(i).toString().equals("<=")) {
            		System.out.println(tokens.get(i).toString()+" LEnumber"+" "+convert(positions.get(count)));
            		continue;}
            	if(tokens.get(i).toString().equals(">=")) {
            		System.out.println(tokens.get(i).toString()+" GEnumber"+" "+convert(positions.get(count)));
            		continue;}
            	if(tokens.get(i).toString().equals("<>")) {
            		System.out.println(tokens.get(i).toString()+" NEnumber"+" "+convert(positions.get(count)));
                    continue;}
                    


            	if(tokens.get(i).toString().equalsIgnoreCase("and")) {
            		System.out.println(tokens.get(i).toString()+" ANDnumber"+" "+convert(positions.get(count)));
            		continue;}
            	if(tokens.get(i).toString().equalsIgnoreCase("array")) {
            		System.out.println(tokens.get(i).toString()+" ARRAYnumber"+" "+convert(positions.get(count)));
            		continue;}
            	if(tokens.get(i).toString().equalsIgnoreCase("constrant")) {
            		System.out.println(tokens.get(i).toString()+" CONSTnumber"+" "+convert(positions.get(count)));
            		continue;}
            	if(tokens.get(i).toString().equalsIgnoreCase("div")) {
            		System.out.println(tokens.get(i).toString()+" DIVnumber"+" "+convert(positions.get(count)));
            		continue;}
            	if(tokens.get(i).toString().equalsIgnoreCase("downto")) {
            		System.out.println(tokens.get(i).toString()+" DOWNTOnumber"+" "+convert(positions.get(count)));
            		continue;}
            	if(tokens.get(i).toString().equalsIgnoreCase("and")) {
            		System.out.println(tokens.get(i).toString()+" IDnumber"+" "+convert(positions.get(count)));
            		continue;}
            	if(tokens.get(i).toString().equalsIgnoreCase("and")) {
            		System.out.println(tokens.get(i).toString()+" IDnumber"+" "+convert(positions.get(count)));
            		continue;}
            	// else
    			if (tokens.get(i).toString().equalsIgnoreCase("else")){
    				System.out.println(tokens.get(i).toString() + " ELSEnumber"+" "+convert(positions.get(count)));
    				continue;}
    			// elsif
    			if (tokens.get(i).toString().equalsIgnoreCase("elseif")) {
    				System.out.println(tokens.get(i).toString() + " ELSEIFnumbe"+" "+convert(positions.get(count)));
    				continue;}
    			// end
    			if (tokens.get(i).toString().equalsIgnoreCase("END") == true) {
    				System.out.println(tokens.get(i).toString() + " ENDnumber"+" "+convert(positions.get(count)));
    				continue;}
    			// endif
    			if (tokens.get(i).toString().equalsIgnoreCase("endif")) {
    				System.out.println(tokens.get(i).toString() + " ENDIFnumber"+" "+convert(positions.get(count)));
    				continue;}
    			// endloop
    			if (tokens.get(i).toString().equalsIgnoreCase("endloop")) {
    				System.out.println(tokens.get(i).toString() + " ENDLOOPnumber"+" "+convert(positions.get(count)));
    				continue;}
    			// andrec
    			if (tokens.get(i).toString().equalsIgnoreCase("andrec")) {
    				System.out.println(tokens.get(i).toString() + " ENDRECnumber"+" "+convert(positions.get(count)));
    				continue;}
    			// exit
    			if (tokens.get(i).toString().equalsIgnoreCase("exit")) {
    				System.out.println(tokens.get(i).toString() + " EXITnumber"+" "+convert(positions.get(count)));
    				continue;}
    			// for
    			if (tokens.get(i).toString().equalsIgnoreCase("for")) {
    				System.out.println(tokens.get(i).toString() + " FORnumber"+" "+convert(positions.get(count)));
    				continue;}
    			// forward
    			if (tokens.get(i).toString().equalsIgnoreCase("forward")) {
    				System.out.println(tokens.get(i).toString() + " FORWARDnumber"+" "+convert(positions.get(count)));
    				continue;}
    			// function
    			if (tokens.get(i).toString().equalsIgnoreCase("function")) {
    				System.out.print(tokens.get(i).toString() + " FUNCTIONnumber"+" "+convert(positions.get(count)));
    				continue;}
    			// if
    			if (tokens.get(i).toString().equalsIgnoreCase("if")) {
    				System.out.println(tokens.get(i).toString() + " IFnumber"+" "+convert(positions.get(count)));
    				continue;}
    			// IS
    			if (tokens.get(i).toString().equalsIgnoreCase("IS")) {
    				System.out.println(tokens.get(i).toString() + " ISnumber"+" "+convert(positions.get(count)));
    				continue;}
    			// loop
    			if (tokens.get(i).toString().equalsIgnoreCase("loop")) {
    				System.out.println(tokens.get(i).toString() + " LOOPnumber"+" "+convert(positions.get(count)));
    				continue;}
    			// not
    			if (tokens.get(i).toString().equalsIgnoreCase("not")) {
    				System.out.println(tokens.get(i).toString() + " NOTnumber"+" "+convert(positions.get(count)));
    				continue;}
    			// of
    			if (tokens.get(i).toString().equalsIgnoreCase("of")) {
    				System.out.println(tokens.get(i).toString() + " OFnumber"+" "+convert(positions.get(count)));
    				continue;}
    			// or
    			if (tokens.get(i).toString().equalsIgnoreCase("or")) {
    				System.out.println(tokens.get(i).toString() + " ORnumber"+" "+convert(positions.get(count)));
    				continue;}
    			// procedure
    			if (tokens.get(i).toString().equalsIgnoreCase("procedure")) {
    				System.out.println(tokens.get(i).toString() + " PRODUREnumber"+" "+convert(positions.get(count)));
    				continue;}
    			// program
    			if (tokens.get(i).toString().equalsIgnoreCase("program")) {
    				System.out.println(tokens.get(i).toString() + " PROGRAMnumber"+" "+convert(positions.get(count)));
    				continue;}
    			// record
    			else if (tokens.get(i).toString().equalsIgnoreCase("record")) {
    				System.out.println(tokens.get(i).toString() + " RECORDnumber"+" "+convert(positions.get(count)));
    				continue;}
    			// repeat
    			if (tokens.get(i).toString().equalsIgnoreCase("repeat")) {
    				System.out.println(tokens.get(i).toString() + " REPEATnumber"+" "+convert(positions.get(count)));
    				continue;}
    			// return
    			if (tokens.get(i).toString().equalsIgnoreCase("return")) {
    				System.out.println(tokens.get(i).toString() + " RETURNnumber"+" "+convert(positions.get(count)));
    				continue;}
    			// then
    			if (tokens.get(i).toString().equalsIgnoreCase("then")) {
    				System.out.println(tokens.get(i).toString() + " THENnumber"+" "+convert(positions.get(count)));
    				continue;}
    			// to
    			if (tokens.get(i).toString().equalsIgnoreCase("to")) {
    				System.out.println(tokens.get(i).toString() + " TOnumber"+" "+convert(positions.get(count)));
    				continue;}
    			// type
    			if (tokens.get(i).toString().equalsIgnoreCase("type")) {
    				System.out.println(tokens.get(i).toString() + " TYPEnumber"+" "+convert(positions.get(count)));
    				continue;}
    			// until
    			if (tokens.get(i).toString().equalsIgnoreCase("until")) {
    				System.out.println(tokens.get(i).toString() + " UNTILnumber"+" "+convert(positions.get(count)));
    				continue;}
    			// var
    			if (tokens.get(i).toString().equalsIgnoreCase("var")) {
    				System.out.println(tokens.get(i).toString() + " VARnumber"+" "+convert(positions.get(count)));
    				continue;}
    			// while
    			if (tokens.get(i).toString().equalsIgnoreCase("while")) {
    				System.out.println(tokens.get(i).toString() + " WHILEnumber"+" "+convert(positions.get(count)));
                    continue;}
                    

                    
            	if(tokens.get(i).toString().equals("([\'])(?:(?=(\\\\?))\\2.)*?\\1")) {
            		System.out.println(tokens.get(i).toString()+" CCONSTnumber"+" "+convert(positions.get(count)));
            		continue;}
            	if(tokens.get(i).toString().equals("([\"])(?:(?=(\\\\?))\\2.)*?\\1")) {
            		System.out.println(tokens.get(i).toString()+" SCONSTnumber"+" "+convert(positions.get(count)));
            		continue;}
            	if(tokens.get(i).toString().matches("[\\d]+")) {
            		System.out.println(tokens.get(i).toString()+" ICONSTnumber"+" "+convert(positions.get(count)));
            		continue;}
    			if(tokens.get(i).toString().matches("\\w+")) {
            		System.out.println(tokens.get(i).toString()+" IDnumber"+" "+convert(positions.get(count)));
            		continue;}
        	}
        }
    }
    private String convert(int[] element) {
    	String txt = Arrays.toString(element).trim();
    	txt = txt.substring(1, txt.length()-1).replace(",", "");
    	return txt;
    }
    int idx = 1;
	int idxRow = 1;
    private void countRowAndCharacter() {
    	idx = 1;
    	// will return start end startChar endChar;
    	int[] position;
    	int length;
    	String str;
    	for (int i = 0; i < tokens.size(); i++) {
    		str = tokens.get(i);
    		if (str.equals(" ")) {
    			idx++;
    			positions.add(new int[4]);
    			continue;
    		}
    		if (str.equals("\\n")) {
    			positions.add(new int[4]);
    			idxRow++;
    			idx = 1;
    			continue;
    		}
    		length = str.length();
    		position = new int[4];
    		position[0] = idxRow;
    		position[1] = idxRow;
    		position[2] = idx;
    		position[3] = length + idx - 1;
    		idx += length;
    		positions.add(position);
    	}
    }
    
    private void readFile() {
        
        String path = new File("").getAbsolutePath() + "\\src\\" + Data.class.getPackage().getName() + "\\";
        
        String fileName = "test.txt";//test05
        
        try (BufferedReader br = new BufferedReader(new FileReader(path + fileName))) {
            //int times = 1;
            String line = "";
            while(br.ready()) {
                
                line = br.readLine();
               
                processData(line);
                //if (times == 2) break;
                //times ++;
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
       
    }
    
    private void processData(String line) {
        
        char[] chars = line.toCharArray();
        //char[] chars = new char[]{'a','b','c','A','b',' '};
        setConcatChar(chars);
        idx++;
    }
    
    private void setConcatChar(char[] chars) {
        
        
        String str = "";
        boolean isSpecialCharacter = false;
        for (int i = 0; i < chars.length; i++) {
        	isSpecialCharacter = false;
            char c = chars[i];

            if ((c >= 'A' && c <= 'Z') || c >= 'a' && c <= 'z' || c >= '0' && c <= '9') {
                str += (c + "");
                if ((i + 1) >= chars.length) {
                	tokens.add(str);
                }
                
            }
            else if(c == ' ') {                
                if (!str.isEmpty()) tokens.add(str);
                tokens.add(c + "");
                str = "";
            }
            else {
            	    
            	if (c == '\t') {
            		for (int j = 0; j < 4; j++) {
            			tokens.add(" ");
            		}
            		continue;
            	}
            	// for special char
            	if (c == '<' && chars[i + 1] == '=') {
            		str = "<=";
            		i = i + 1; 
            		isSpecialCharacter = true;
            	}
            	else if (c == '>' && chars[i + 1] == '=') {
            		str = ">=";
            		i = i + 1; 
            		isSpecialCharacter = true;
            	} 
            	else if (c == ':' && chars[i + 1] == '=') {
            		str = ":=";
            		i = i + 1; 
            		isSpecialCharacter = true;
            	} 
            	else if (c == '<' && chars[i + 1] == '>') {
            		str = "<>";
            		i = i + 1; 
            		isSpecialCharacter = true;
            	}
            	else if (c == '.' && chars[i + 1] == '.') {
            		str = "..";
            		i = i + 1; 
            		isSpecialCharacter = true;
            	}
            	// dau :=, ==, dau' <=, 
                if (!str.isEmpty()) tokens.add(str);
                if(!isSpecialCharacter) tokens.add(c + "");
                str = "";
            }
        }
        tokens.add("\\n");       
      
    }
    private void print(ArrayList<String> tokens) {
        
        for (String s : tokens) {
            System.out.print("-|"+s + "|-");
                    
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            Data data = new Data();
            
        });
    }
    
}//lex
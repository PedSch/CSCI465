public class Token {
     String tokenType= "";
     String tokenValue = "";

     int lineCol = 0;
     int lineRow = 0;

    public Token(String tokenType, String tokenValue, int lineCol, int lineRow){
        this.tokenType = tokenType;
        this.tokenValue = tokenValue;

        this.lineCol = lineCol;
        this.lineRow = lineRow;
    }

    @Override
    public String toString(){
        return tokenValue;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public int getLineCol() {
        return lineCol;
    }

    public int getLineRow() {
        return lineRow;
    }
}
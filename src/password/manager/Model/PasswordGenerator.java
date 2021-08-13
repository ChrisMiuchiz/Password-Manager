package password.manager.Model;

public class PasswordGenerator extends FieldGenerator {
    private int length;
    private char[] charSet;
    java.util.Random random;
    public PasswordGenerator() {
        length = 5;
        String setStr = "abcdefghijklmnopqrstuvwxyz";
        charSet = setStr.toCharArray();
        random = new java.util.Random();
    }
    
    @Override
    public String generate() {
        String result = "";
        for (int i = 0; i < length; i++) {
            char newchar = charSet[random.nextInt(charSet.length)];
            result += newchar;
        }
        return result;
    }
    
    public void setCharSet(char[] set) {
        charSet = set;
    }
    
    public void setLength(int length) {
        this.length = length;
    }
    
    public int getLength() {
        return length;
    }
    
    public char[] getCharSet() {
        return charSet;
    }
}

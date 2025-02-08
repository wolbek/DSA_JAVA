package Strings;

public class StringCompression {
    public static String compressString(String str){
        StringBuilder sb = new StringBuilder("");

        for(int i=0;i<str.length();i++){
            int count = 1;
            char currentChar = str.charAt(i);
            while(i<=str.length()-2 && currentChar == str.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(currentChar);
            if(count > 1){
                sb.append(count);
            }
        }

        return sb.toString();
    }
    public static void main(String[] args){
        String str = "aaabbcccdd  ";
        System.out.println(compressString(str));
    }
}

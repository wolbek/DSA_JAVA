package Strings;

public class LettersToUppercase {
    public static String convertLettersToUppercase(String str) {
        StringBuilder sb = new StringBuilder("");

        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i=1;i<str.length();i++){
            ch = str.charAt(i);
            sb.append(ch);
            if(ch == ' ' && i<=str.length()-2){
                ++i;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        String sentence = "hi! i am aakash ";
        System.out.println(convertLettersToUppercase(sentence));
    }
}

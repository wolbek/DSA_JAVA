package Recursion;

public class RemoveDuplicatesInString {
    public static void removeDuplicates(String str, int index, boolean[] arr, StringBuilder newStr){
        if(index == str.length()-1){
            System.out.println(newStr);
            return;
        }

        char ch =  str.charAt(index);
        if(arr[ch - 'a'] == false){
            arr[ch - 'a'] = true;
            newStr.append(ch);
        }
        removeDuplicates(str, index+1, arr, newStr);
    }
    public static void main(String[] main){
        String str = "appnnacollege";
        int index = 0;

        removeDuplicates(str, index, new boolean[26], new StringBuilder(""));

    }
}

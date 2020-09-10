package java09092020;

public class StrReverse {
    public static void main(String[] args) {
        String inputStr = "ABCDEF";
        System.out.println(reverseString(inputStr));
        // 출력결과 : FEDCBA
    }

    public static String reverseString(String s){
        return (new StringBuffer(s)).reverse().toString();
    }
}
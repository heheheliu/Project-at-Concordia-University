import java.util.HashMap;
import java.util.Map;

class Solution {

    public static String convertToTitle(int columnNumber) {

        StringBuilder sb = new StringBuilder();
        while(columnNumber > 0){
            columnNumber--;//解决从1开始的关键
            int n = columnNumber % 26;
            sb.append((char)(n +'A'));
            columnNumber = columnNumber / 26;


        }
        System.out.println(sb);
        return sb.reverse().toString();


    }

    public static void main(String[] args) {
        convertToTitle(701);
    }
}

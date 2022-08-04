public class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbb = new StringBuilder();
        for(int i = 0; i<s.length(); i++){

            if(s.charAt(i)==' '){
                String r = sbb.reverse().toString()+ " ";
                sb.append(r);
                sbb = new StringBuilder();

            }else{
                sbb.append(s.charAt(i));
            }

        }
        sb.append(sbb.reverse().toString());
        return sb.toString();
    }
}

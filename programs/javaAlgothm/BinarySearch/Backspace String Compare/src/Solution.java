public class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb = new StringBuilder();
        StringBuilder bs = new StringBuilder();

        for(int i = 0; i< s.length();i++){
            if(s.charAt(i) == '#' && sb.length() > 0){
                sb.deleteCharAt(sb.length()-1);

            }else if(s.charAt(i) == '#' && sb.length() == 0){
                continue;
            }
            else{
                sb.append(s.charAt(i));
            }


        }
        for(int i =0; i< t.length(); i++){
            if(t.charAt(i) == '#' && bs.length() > 0){
                bs.deleteCharAt(bs.length()-1);

            }else if(t.charAt(i) == '#' && bs.length() == 0){
                continue;
            }
            else{
                bs.append(t.charAt(i));
            }
        }
        return sb.toString().equals(bs.toString());

    }
}

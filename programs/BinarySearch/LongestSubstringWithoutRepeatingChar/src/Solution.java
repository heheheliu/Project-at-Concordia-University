import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        for (int left = 0, i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(map.get(s.charAt(i)),left);

            }

            maxLen = Math.max(maxLen, i - left +1);
            map.put(s.charAt(i), i + 1);



        }
        return maxLen;
    }
}

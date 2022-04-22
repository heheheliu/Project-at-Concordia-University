import java.util.HashMap;
import java.util.Hashtable;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int answer =0;
        int n = s.length();
        for (int i = 0, j = 0; j<n; j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)), i);
            }

            answer = Math.max(answer, j-i+1);
            map.put(s.charAt(j),j+1);
        }

        return answer;
    }
}

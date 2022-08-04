import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    private HashMap<String, Boolean> memory;
    public boolean wordBreak_recursion(String s, List<String> wordDict){
        int[] g = new int[3];

        memory = new HashMap<>();
        memory.put(" ",true);
        Set<String> dict = new HashSet<>(wordDict);
        return helper(s,dict);
    }
    public boolean helper(String s, Set<String> dict){
        if(memory.containsKey(s)) return memory.get(s);
        if(dict.contains(s)){
            memory.put(s, true);
            return memory.get(s);
        }
        //try every break point
        for (int j = 1; j <= s.length(); j++){
            String left = s.substring(0,j);
            String right = s.substring(j);
            if(dict.contains(right) && helper(left,dict)){
                memory.put(s, true);
                return memory.get(s);
            }
        }
        memory.put(s,false);
        return memory.get(s);
    }


    public boolean wordBreak(String s, List<String> wordDict){
        int maxLen = 0;
        for(String str: wordDict){
            maxLen = Math.max(maxLen,str.length());
        }
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 1; i <= n; i++){
            for(int j = i - 1; j >= 0; j--){//int j = 0; j < i; j++
                if(i-j > maxLen){
                    continue;
                }
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

}

public class Solution {
    public static boolean canConstruct(String ransomNote, String magazine) {

        if(ransomNote.length()>magazine.length()){
            return false;
        }
        int[] array = new int[26];
         for (int i =0; i < magazine.length(); i++){
             array[magazine.charAt(i) - 'a']++;

         }
        for (int i =0; i < ransomNote.length(); i++){
            array[ransomNote.charAt(i) - 'a']--;

        }
         for(int n : array){
             if(n < 0){
                 return false;
             }
         }
         return true;
    }

    public static void main(String[] args) {
        String r = "aa";
        String m = "aab";
        System.out.println(canConstruct(r,m));
    }
}

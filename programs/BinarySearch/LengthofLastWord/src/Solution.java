public class Solution {


        public static int lengthOfLastWord(String s) {
          int count = 0;
          int len = s.length();
          int i = 0;
          for(i = len-1; i>0;i--){
              if(s.charAt(i)!= ' '){
                  count++;
                  if(s.charAt(i-1)==' '){
                      return count;
                  }

              }

          }
          if(i == 0 && s.charAt(i) != ' ')
          return count+1;
          return count;


    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }
}

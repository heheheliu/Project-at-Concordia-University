class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.toUpperCase().equals(word)){
            return true;
        }
        else if(word.toLowerCase().equals(word)){
            return true;
        }
        else{
            char first = word.charAt(0);
            if(Character.isUpperCase(first)){
                String s = word.substring(1);
                if(s.toLowerCase().equals(s)){
                    return true;
                }
                return false;
            }

        }
        return false;
    }
}
import java.util.*;

// given two non-empty arrays of intergers, write a function that determines whether the second array is a subsequence of the first one
// array =[5,1,22,25,6,-1,8,10]
// sequence = [1,6,-1,10]
// output : true
class ValidSubsequence {
    // O(n) time | O(1) space where n is the length of the array
    public  static  boolean isValidSubsequence(List<Integer> array, List<Integer> sequence){
        int arrindx =0;
        int seqindx =0;
        while(arrindx<array.size() && seqindx<sequence.size()){
            if(array.get(arrindx) == sequence.get(seqindx)){
                seqindx++;
            }
            arrindx++;
        }
        Boolean valid = (seqindx == sequence.size());
        return valid;
    }
    // O(n) time | O(1) space where n is the length of the array
    public static boolean isValidsubsequence2(List<Integer> array, List<Integer> sequence){
        //int arridx = 0;
        int seqidx = 0;
        for(Integer x : array){
            if(x == sequence.get(seqidx)){
                seqidx++;
            }
            if(seqidx == sequence.size()){
                break;
            }
        }
        return seqidx == sequence.size();
    }

    // public static void main(String[] args) {
    //     List<Integer> arr = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
    //     List<Integer> seq = Arrays.asList(1, 25, -1, 10);
    //     System.out.println(isValidSubsequence(arr,seq));
    //     System.out.println(isValidsubsequence2(arr,seq));
       
    // }



}


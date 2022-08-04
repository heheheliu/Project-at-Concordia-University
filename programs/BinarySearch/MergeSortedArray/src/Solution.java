import java.util.Arrays;

class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m,j=0;
        while(i<(m+n) && j<n){

            nums1[i] = nums2[j];
            i++;
            j++;

        }
        Arrays.sort(nums1);

    }



    public static void main(String[] args) {
        merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
    }

}

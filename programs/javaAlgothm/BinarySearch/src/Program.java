public class Program {
    public static int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len-1;
        while (left<=right){
            int mid = (left + right) / 2;
            int midnum = nums[mid];
            if (target < midnum) {
                right = mid-1;
            }
            if (target == midnum) {
                return mid;
            }
            if (target > midnum) {
                left = mid+1;

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        System.out.println(search(a,3));
    }
}

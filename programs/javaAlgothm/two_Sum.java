
import java.util.HashMap;

class two_Sum {
    public static int[] twoSum(int[] nums, int target) {
        int[] resul = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (map.containsKey(diff)) {

                resul[0] = i;
                resul[1] = map.get(diff);

            } else {
                map.put(nums[i], i);
            }

        }

        if (resul[1] < resul[0]) {
            int x = resul[0];
            resul[0] = resul[1];
            resul[1] = x;
        }
        return resul;

    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 1, 15 };
        int target = 8;
        int[] result = twoSum(nums, target);

        for (int i : result) {
            System.out.println(i + " ");

        }

    }

}
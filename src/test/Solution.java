package test;

/**
 * @author Jacky
 * @version 1.0
 * @date 2022/3/7
 */
public class Solution {

    //https://leetcode-cn.com/leetbook/read/array-and-string/yf47s/
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int sum1 = 0;
        for (int num : nums) {
            sum += num;
        }

        for (int i = 0; i < nums.length; i++) {

            if ((sum - nums[i] == 0) && (i == 0 || i == nums.length - 1)) {
                return i;
            }
            if (sum1 * 2 == sum - nums[i]) {
                return i;
            } else {
                sum1 += nums[i];
            }

        }

        for (int i = 0; i < nums.length; i++) {
            if (sum1*2+nums[i] ==sum) {
                return i;
            }else{
                sum1+=nums[i];
            }
        }

        return -1;
    }

}

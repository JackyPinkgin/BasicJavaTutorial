package test;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 专门为了写各种算法的问题
 * 2022/3/7
 */
public class Ctest {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-1,-1,1,1,1};
        System.out.println(pivotIndex(nums));
    }

    public static double average(int[] salary) {

        int max = salary[0];
        int min = salary[0];
        int sum = 0;

        for (int i : salary) {
            if (i > max) {
                max = i;
            } else if (i < min) {
                min = i;
            }
            sum += i;
        }
        return (double) (sum - max - min) / (salary.length - 2);
    }

    //https://leetcode-cn.com/problems/binary-search/
    public static int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;
        int mid = (max - min) / 2 + min;

        while (max >= min) {
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                min = mid + 1;
            }
            if (target < nums[mid]) {
                max = mid - 1;
            }
            mid = (max - min) / 2 + min;
        }
        return -1;
    }

    public static int searchInsert(int[] nums, int target) {

        int min = 0;
        int max = nums.length - 1;
        int mid = (max - min) / 2 + min;

        while (max >= min) {
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                min = mid + 1;
            }
            if (target < nums[mid]) {
                max = mid - 1;
            }
            mid = (max - min) / 2 + min;
        }
        return mid;
    }

    public static int firstBadVersion(int n) {
        int high = n;
        int low = 1;
        int mid = 0;
        while (high > low) {
            mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static boolean isBadVersion(int version) {
        return true;
    }

    //https://leetcode-cn.com/leetbook/read/array-and-string/yf47s/

    public static int pivotIndex(int[] nums) {
        int sum = 0;
        int sum1 = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum-nums[0]==0) {
            return 0;
        }

        for (int i = 0; i <= nums.length - 1; i++) {
            sum1 += nums[i];
            if (i == nums.length - 1 && sum1 == 0) {
                return i;
            } else if (i == nums.length - 1 && sum1 != 0) {
                return -1;
            }
            if (sum1 * 2 == (sum - nums[i + 1])) {
                return i + 1;
            }
        }
        return -1;

    }


}


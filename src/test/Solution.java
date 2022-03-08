package test;

import org.junit.jupiter.api.Test;

import java.time.format.SignStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Jacky
 * @version 1.0
 * @date 2022/3/7
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 3, 5, 6};
        String s1 = "hello world";

        String[] a = new String[]{"flower", "flow", "flight"};
        String s = solution.longestCommonPrefix(a);
        System.out.println(s);

    }

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
            if (sum1 * 2 + nums[i] == sum) {
                return i;
            } else {
                sum1 += nums[i];
            }
        }
        return -1;
    }

    //https://leetcode-cn.com/leetbook/read/array-and-string/cxqdh/
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int mid = 0;
        while (high >= low) {
            mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                low = mid + 1;
            }
            if (target < nums[mid]) {
                high = mid - 1;
            }
        }
        return low;
    }

    //https://leetcode-cn.com/leetbook/read/array-and-string/c5tv3/
    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        int[] ints = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (ints[1] >= intervals[i][0]) {
                ints[1] = Math.max(ints[1], intervals[i][1]);
            } else {
                list.add(ints);
                ints = intervals[i];
            }
        }
        list.add(ints);
        return list.toArray(new int[list.size()][2]);
    }

    //https://leetcode-cn.com/leetbook/read/array-and-string/clpgd/
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] matrixnew = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixnew[j][n - i - 1] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = matrixnew[i][j];
            }
        }
    }

    //https://leetcode-cn.com/leetbook/read/array-and-string/clpgd/
    public void rotateNew(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
    }

    //https://leetcode-cn.com/leetbook/read/array-and-string/ciekh/
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] row = new int[m];
        int[] col = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            prefix = calPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                return prefix;
            }
        }
        return prefix;
    }

    public String calPrefix(String s1, String s2) {
        int min = Math.min(s1.length(), s2.length());
        int index = 0;
        for (int i = 0; i < min; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
            index++;
        }
        return s1.substring(0, index);
    }

    //https://leetcode-cn.com/leetbook/read/array-and-string/conm7/
    //暴力解法
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        int maxlength = 1;
        int begin = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (j - i + 1 > maxlength && isreverse(chars, i, j)) {
                    maxlength = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin+maxlength);
    }

    public boolean isreverse(char[] arr, int left, int right) {
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


}






















package LeetcodePractice;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jacky
 * @version 1.0
 * @date 2022/3/16
 * 跟随B站课程练习基本的内容
 * start from 22/03/16
 * https://www.bilibili.com/video/BV1xt4y1e7q4/?spm_id_from=333.788.video.desc.click
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
    }

    //https://leetcode-cn.com/problems/two-sum/
    //1
    @SuppressWarnings("all")
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff) && map.get(diff) != i) {
                ans[0] = i;
                ans[1] = map.get(diff);
            }
        }
        return ans;
    }

    //https://leetcode-cn.com/problems/linked-list-cycle/
    //141
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    //https://leetcode-cn.com/problems/boats-to-save-people/
    //881
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        int light = 0;
        int heavy = people.length - 1;
        while (light <= heavy) {
            if (people[light] + people[heavy] <= limit) {
                light++;
            }
            heavy--;
            ans++;
        }
        return ans;
    }

    //https://leetcode-cn.com/problems/binary-search/
    //704  二分查找
    public int search(int[] nums, int target) {
        int small = 0;
        int big = nums.length - 1;
        while (small <= big) {
            int mid = (big - small) / 2 + small;
            int midnum = nums[mid];
            if (midnum == target) {
                return mid;
            } else if (midnum > target) {
                big = mid - 1;
            } else {
                small = mid + 1;
            }
        }
        return -1;
    }

    //https://leetcode-cn.com/problems/search-insert-position/
    //35 搜索插入位置
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num < target) {
                left = mid + 1;
            } else if (num > target) {
                right = mid - 1;
            }
        }
        return left;

    }

    //https://leetcode-cn.com/problems/find-peak-element/
    //162  寻找峰值
    //普通方式
    public int findPeakElement(int[] nums) {
        int ans = 0;
        if (nums.length == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                ans = i;
            }
        }
        return ans;
    }

    //找最大值
    public int findPeakElement2(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[ans]) {
                ans = i;
            }
        }
        return ans;
    }

    //二分查找
    public int findPeakElement3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int a = nums[mid];
            if (a > nums[mid + 1]) {
                r = mid;
            } else if (a < nums[mid + 1]) {
                l = mid + 1;
            }
        }
        return l;
    }

    //https://leetcode-cn.com/problems/search-a-2d-matrix/
    //74
    //暴力解法
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    //二分法
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int l = 0, r = row * col - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int ele = matrix[mid / col][mid % col];
            if (ele == target) {
                return true;
            } else if (ele > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    //https://leetcode-cn.com/problems/minimum-size-subarray-sum/
    //209
    //暴力解法  会超时
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int size = 1;
        while (size <= nums.length) {
            for (int i = 0; i < nums.length + 1 - size; i++) {
                int total = 0;
                for (int j = i; j < i + size; j++) {
                    total += nums[j];
                }
                if (total >= target) {
                    return size;
                }
            }
            size++;
        }
        return 0;
    }

    //滑动窗口法
    public int minSubArrayLen2(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0, j = 0, res = nums.length + 1, total = 0;
        while (j < nums.length) {
            total += nums[j];
            j++;
            while (total >= target) {
                res = Math.min(res, j - i);
                total -= nums[i];
                i++;
            }
        }
        return res == nums.length + 1 ? 0 : res;
    }


}





























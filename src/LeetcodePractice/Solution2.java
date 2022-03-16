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

        int len = nums.length;
        if (len%2==1){
            int mid = (len+1)/2;
            while ()
        }

        return -1;
    }

}





























package LeetcodePractice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Jacky
 * @version 1.0
 * @date 2022/3/7
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 3, 5, 6};
        int[] nums2 = new int[]{2, 2, 1};
        int[] nums4 = new int[]{4, 1, 2, 1, 2};
        int[][] num5 = {{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}};
        int[] num6 = new int[]{41, 65, 14, 80, 20, 10, 55, 58, 24, 56, 28, 86, 96, 10, 3, 84, 4, 41, 13, 32, 42, 43, 83, 78, 82, 70, 15, -41};
        int[] nums3 = {463, 191, -915, -438, 420, -135, -431, 611, 695, -605, 469, 917, 301, 70, 209, -66, 956, 7, 245, 147, 104, 633, -218, -879, -894, 208, -37, -344, -252, -684, 728, -943, 858, -557, 217, -655, -91, -308, 699, -152, -702, 916, -867, 447, 29, -207, 56, -149, 909, 980, 508, -747, -389, -718, 814, -790, 803, 299, 443, 932, -814, 495, 274, 88, -22, 373, -324, 144, -144, 421, -499, -178, -582, -124, 741, 526, 215, -538, -912, 400, 425, -693, -767, 862, -746, 462, 762, 148, 463, 191, -915, -438, 420, -135, -431, 611, 695, -605, 469, 917, 301, 70, 209, -66, 956, 7, 245, 147, 104, 633, -218, -879, -894, 208, -37, -344, -252, -684, 728, -943, 858, -557, 217, -655, -91, -308, 699, -152, -702, 916, -867, 447, 29, -207, 56, -149, 909, 980, 508, -747, -389, -718, 814, -790, 803, 299, 443, 932, -814, 495, 274, 88, -22, 373, -324, 144, -144, 421, -499, -178, -582, -124, 741, 526, 215, -538, -912, 400, 425, -693, -767, 862, -746, 462, 762, 148, -3};
        int[] num7 = {4, 1, 2};
        int[] num8 = {0, 1, 0, 3, 12};


        System.out.println(solution.feibonaqie(8));
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
        return s.substring(begin, begin + maxlength);
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

    //https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhbqj/
    public void reverseString(char[] s) {
        char tmp;
        for (int i = 0; i < s.length / 2; i++) {
            tmp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = tmp;
        }
    }

    public void reverseString2(char[] s) {
        char tmp;
        for (int i = 0, j = s.length - 1; i <= j; i++, j--) {
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }

    //https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn5z8r/
    public int firstUniqChar(String s) {
        Map<Character, Integer> count = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            count.put(aChar, count.getOrDefault(aChar, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (count.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            count[chars[i] - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (count[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar3(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (s.lastIndexOf(chars[i]) == s.indexOf(chars[i])) {
                return i;
            }
        }
        return -1;
    }

    //https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnmav1/
    //最长子串
    public String longestCommonPrefix2ndTime(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = prefixCal(prefix, strs[i]);
            if (prefix.length() == 0) {
                return prefix;
            }
        }
        return prefix;
    }

    public String prefixCal(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
            index++;
        }
        return s1.substring(0, index);
    }

    //https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnr003/
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
            if (j == needle.length()) {
                return i - j;
            }
        }
        return -1;
    }

    public int strStr2ndTime(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i + needle.length() <= haystack.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    //https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x248f5/
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) >= 2) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    //https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2jrse/
    //两数之和
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

    //https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x21ib6/
    //只出现一次的数字
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int a = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (m.get(nums[i]) == 1) {
                a = nums[i];
            }
        }
        return a;
    }

    public int singleNumber2(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            if (!s.add(num)) {
                s.remove(num);
            }
        }
        Object[] u = s.toArray();
        return (int) u[0];
    }

    public int singleNumber3(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }

    //https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/
    //两个数组的交集 II
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int l1 = nums1.length;
        int l2 = nums2.length;

        int i = 0, j = 0;
        while (i < l1 && j < l2) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        int[] res = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }

    //https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/
    //旋转数组
    public void rotate(int[] nums, int k) {
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = tmp[i];
        }
    }

    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int[] tmp = new int[k];
        int j = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            tmp[j++] = nums[i];
        }
        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = tmp[i];
        }
    }

    //https://leetcode-cn.com/problems/number-of-1-bits/
    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        char[] chars = s.toCharArray();
        int count = 0;
        for (char aChar : chars) {
            if (aChar == '1') {
                count++;
            }
        }
        return count;
    }

    //https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
    public int subtractProductAndSum(int n) {
        int time = 1;
        int sum = 0;
        char[] chars = Integer.toString(n).toCharArray();
        for (char aChar : chars) {
            int num = Character.getNumericValue(aChar);
            time *= num;
            sum += num;
        }
        return time - sum;
    }

    public int subtractProductAndSum2(int n) {
        int time = 1;
        int sum = 0;
        while (n > 0) {
            int i = n % 10;
            time *= i;
            sum += i;
            n = n / 10;
        }
        return time - sum;
    }

    //https://leetcode-cn.com/problems/largest-perimeter-triangle/solution/
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }

    //https://leetcode-cn.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE, ans = -1;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] != x && points[i][1] != y) {
                continue;
            }
            int a = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
            if (a < min) {
                min = a;
                ans = i;
            }
        }
        return ans;
    }

    //https://leetcode-cn.com/problems/sign-of-the-product-of-an-array/
    public int arraySign(int[] nums) {
        int chengji = 1;
        for (int num : nums) {
            if (num > 0) {
                chengji *= 1;
            }
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                chengji *= -1;
            }
        }
        return chengji;
    }

    //https://leetcode-cn.com/problems/can-make-arithmetic-progression-from-sequence/
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length == 1 || arr.length == 0) {
            return false;
        }
        Arrays.sort(arr);
        int a = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != a) {
                return false;
            }
        }
        return true;
    }

    //https://leetcode-cn.com/problems/happy-number/
    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<>();
        while (n != 1 && !s.contains(n)) {
            s.add(n);
            n = getNextNum(n);
        }
        return n == 1;
    }

    public int getNextNum(int n) {
        int res = 0;
        while (n > 0) {
            int tmp = n % 10;
            res += tmp * tmp;
            n = n / 10;
        }
        return res;
    }

    //https://leetcode-cn.com/problems/check-if-one-string-swap-can-make-strings-equal/
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int count = 0;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                count++;
                sb1.append(chars1[i]);
                sb2.append(chars2[i]);
            }
        }
        if (count > 2 || count == 1) {
            return false;
        }
        char[] ch1 = sb1.toString().toCharArray();
        char[] ch2 = sb2.toString().toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        for (int i = 0; i < ch1.length; i++) {
            if (ch1[i] != ch2[i]) {
                return false;
            }
        }
        return true;

    }

    public boolean areAlmostEqual2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] diff = new int[s1.length()];
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff[count++] = i;
            }
        }
        if (count > 2 || count == 1) {
            return false;
        } else if (count == 2) {
            if (s1.charAt(diff[0]) != s2.charAt(diff[1]) || s1.charAt(diff[1]) != s2.charAt(diff[0])) {
                return false;
            }
        }
        return true;
    }

    //https://leetcode-cn.com/leetbook/read/array-and-string/crmp5/
    public String reverseWords(String s) {
        String[] s1 = s.trim().split(" ");
        Stream<String> stream = Arrays.stream(s1);
        List<String> collect = stream.filter(sss -> sss.length() > 0).map(String::trim).collect(Collectors.toList());
        String[] strings = collect.toArray(new String[collect.size()]);
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 1; i--) {
            sb.append(strings[i]).append(" ");
        }
        sb.append(strings[0]);
        return sb.toString();
    }

    //https://leetcode-cn.com/leetbook/read/array-and-string/c24he/
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i <= nums.length - 1; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    //https://leetcode-cn.com/leetbook/read/array-and-string/cnkjg/
    public int[] twoSum3(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        int sum = 0;
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            }
            if (sum < target) {
                left++;
            }
            if (sum > target) {
                right--;
            }
        }
        return res;
    }

    //https://leetcode-cn.com/leetbook/read/array-and-string/cwuyj/
    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
                fast++;
            } else if (nums[fast] == val) {
                fast++;
            }
        }
        return slow;
    }

    //https://leetcode-cn.com/leetbook/read/array-and-string/cd71t/
    public int findMaxConsecutiveOnes(int[] nums) {

        return 0;
    }

    //https://leetcode-cn.com/problems/two-sum/
    public int[] twoSum5(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};

    }

    //https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (Node child : root.children) {
            helper(child, res);
        }
    }

    //https://leetcode-cn.com/problems/next-greater-element-i/
    //自己写的方法
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        //找到每一个值对应的nums2的下标
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    res[i] = j;
                }
            }
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = calGreaterEle(res[i], nums2);
        }
        return res;
    }

    public int calGreaterEle(int index, int[] num) {
        for (int i = index + 1; i < num.length; i++) {
            if (num[i] > num[index]) {
                index = num[i];
                return index;
            }
        }
        return -1;
    }

    //看题解后的暴力解法
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int m = nums1.length;
        int n = nums2.length;
        for (int i = 0; i < m; i++) {
            int j = 0;
            while (j < n && nums1[i] != nums2[j]) j++;
            while (j < n && nums1[i] >= nums2[j]) j++;
            res[i] = j < n ? nums2[j] : -1;
        }
        return res;
    }

    //看了题解后的单调栈解法
    public int[] nextGreaterElement3(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    //https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null || coordinates.length == 1) return false;

        int dx = coordinates[0][0] - coordinates[1][0];
        int dy = coordinates[0][1] - coordinates[1][1];

        for (int i = 0; i < coordinates.length; i++) {
            int x = coordinates[i][0] - coordinates[0][0];
            int y = coordinates[i][1] - coordinates[0][1];
            if (y * dx != x * dy) {
                return false;
            }
        }

        return true;
    }

    //https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for (int start = 0; start < n; start++) {
            for (int length = 1; start + length <= n; length += 2) {
                int end = start + length - 1;
                for (int i = start; i <= end; i++) {
                    sum += arr[i];
                }
            }
        }
        return sum;
    }

    //https://leetcode-cn.com/problems/move-zeroes/
    //自己写的方法
    public void moveZeroes(int[] nums) {
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != 0) {
                dq.push(nums[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 0;
        }
        int size = dq.size();
        for (int i = 0; i <= size - 1; i++) {
            nums[i] = dq.pop();
        }
    }

    //第二种方法
    public void moveZeroe2(int[] nums) {
        if (nums == null) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    //斐波那契数计算
    public int feibonaqie(int n) {
        if (n <= 1) {
            return n;
        }
        int res = 0;
        int a = 0, b = 1;

        for (int i = 2; i <= n; i++) {
            res = a+b;
            a=b;
            b=res;
        }

        return res;
    }
}




























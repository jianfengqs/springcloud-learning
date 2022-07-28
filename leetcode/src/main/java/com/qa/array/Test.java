package com.qa.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {

//        System.out.println(minSubArrayLen(new int[]{2, 3, 1, 2, 4, 3}, 7));

        // 两数之和
//        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 13)));

        // 53. 最大子序和
//        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

        // 415. 字符串相加
        System.out.println(addStrings("123", "99"));

        // 389. 找不同
//        System.out.println(findTheDifference("abcd", "abcde"));


    }

    /**
     * 389. 找不同
     * <p>
     * 将字符串 ss 中每个字符的 ASCII 码的值求和
     *
     * @param s 旧值
     * @param t 新值
     * @return char
     */
    public static char findTheDifference(String s, String t) {
        int as = 0;
        int at = 0;
        for (int i = 0; i < s.length(); ++i) {
            as += s.charAt(i);
        }

        for (int i = 0; i < t.length(); ++i) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }


    /**
     * 415. 字符串相加
     *
     * @param num1 num1
     * @param num2 num2
     * @return {@link String}
     */
    public static String addStrings(String num1, String num2) {

        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;


            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--;
            j--;
        }

        if (carry == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }


    /**
     * 53. 最大子序和
     *
     * @param nums 数组
     * @return int
     */
    public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > num) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }

        return ans;
    }


    /**
     * 两数之和
     *
     * @param nums   数组
     * @param target 目标
     * @return {@link int[]}
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }


    public static int[] erfen(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int l = -1;
        int r = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                l = mid;
                r = mid;
                break;
            }
        }
        if (l == -1) {
            return new int[]{-1, -1};
        }
        while (l > 0 && nums[l] == nums[l - 1]) {
            l--;
        }
        while (r < nums.length - 1 && nums[r] == nums[r + 1]) {
            r++;
        }
        return new int[]{l, r};
    }

    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须仅使用 $O(1)$ 额外空间并原地修改输入数组。
     * <p>
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 示例 1: 给定 nums = [3,2,2,3], val = 3, 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。 你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 示例 2: 给定 nums = [0,1,2,2,3,0,4,2], val = 2, 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums   数组
     * @param target 目标
     * @return int
     */
    public static int removeElement(int[] nums, int target) {

        int fastIndex = 0;
        int result;
        for (result = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != target) {
                // 原地移除所有数值
                nums[result] = nums[fastIndex];
                result++;
            }
        }

        return result;

    }

    /**
     * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
     * <p>
     * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
     * <p>
     * 将最终结果插入 nums 的前 k 个位置后返回 k 。
     * <p>
     * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 数组
     * @return int
     */
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, result = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[result] = nums[fast];
                result++;
            }
            fast++;
        }

//        for (fast =1;fast< n;fast++) {
//            if (nums[fast] != nums[fast - 1]) {
//                nums[result] = nums[fast];
//                result++;
//            }
//        }
        return result;
    }

    /**
     * 力扣：283
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * <p>
     * <p>
     * 里参考了快速排序的思想，快速排序首先要确定一个待分割的元素做中间点x，然后把所有小于等于x的元素放到x的左边，大于x的元素放到其右边。
     * 这里我们可以用0当做这个中间点，把不等于0(注意题目没说不能有负数)的放到中间点的左边，等于0的放到其右边。
     * 这的中间点就是0本身，所以实现起来比快速排序简单很多，我们使用两个指针i和j，只要nums[i]!=0，我们就交换nums[i]和nums[j]
     * 请对照动态图来理解：
     *
     * @param nums 数组
     */
    public static void moveZeroes(int[] nums) {

        if (nums == null) {
            return;
        }
        // 两个指针i和j
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            // 当前元素!=0，就把其交换到左边，等于0的交换到右边
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;

            }
        }

    }

    /**
     * 力扣：977
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     *
     * @param nums 数组
     * @return {@link int[]}
     */
    public static int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }


    /**
     * 力扣：209
     * <p>
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     * <p>
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums   数组
     * @param target 目标
     * @return int
     */
    public static int minSubArrayLen(int[] nums, int target) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum = sum + nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum = sum - nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;

    }


}

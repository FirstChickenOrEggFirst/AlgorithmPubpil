package com.itpubpil.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangjingbiao
 * createDate: 2021/11/12 周五 5:17 下午
 * desc: 四数之和
 */
public class Solution18 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSum(new int[]{2, 2, 2, 2, 2}, 8));
//        System.out.println(solution.fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0));
    }

    static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> lists = new ArrayList<>();
            if (nums.length < 4) {
                return lists;
            }
            // 1.对数组排序
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > target) {
                    // 该位大于target，后面的数不可能相加等于target
                    return lists;
                }

                if (i > 0 && nums[i] == nums[i - 1]) {
                    // 相等跳过，避免重复
                    continue;
                }

                for (int j = i + 1; j < nums.length; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        // 相等跳过，避免重复
                        continue;
                    }
                    int left = j + 1, right = nums.length - 1;
                    while (left < right) {
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum == target) {
                            lists.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            // 避免重复
                            while (left < right && nums[left + 1] == nums[left]) left++;
                            while (left < right && nums[right - 1] == nums[right]) right--;
                            left++;
                            right--;
                        } else if (sum > 0) {
                            // 相加大于0.说明右边的数太大，应该往左移
                            right--;
                        } else {
                            // 相加小于0，说明左边的数太小，应该往右移
                            left++;
                        }
                    }
                }
            }
            return lists;
        }
    }
}

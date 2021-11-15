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
        // 异常
        Solution solution = new Solution();
//        System.out.println(solution.fourSum(new int[]{2, 2, 2, 2, 2}, 8));
//        System.out.println(solution.fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0));
//        System.out.println(solution.fourSum(new int[]{-1, 0, 1, 2, -1, -4}, -1));
        System.out.println(solution.fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11));

        // 正常
        Solution2 solution2 = new Solution2();
//        System.out.println(solution2.fourSum(new int[]{2, 2, 2, 2, 2}, 8));
//        System.out.println(solution2.fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0));
//        System.out.println(solution2.fourSum(new int[]{-1, 0, 1, 2, -1, -4}, -1));
        System.out.println(solution2.fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11));
    }

    static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> lists = new ArrayList<>();
            if (nums.length < 4) {
                return lists;
            }
            // 1.对数组排序
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 3; i++) {
                if (nums[i] > target && nums[i] >= 0) {
                    // 该位大于target，后面的数不可能相加等于target
                    return lists;
                }

                if (i > 0 && nums[i] == nums[i - 1]) {
                    // 相等跳过，避免重复
                    continue;
                }

                for (int j = i + 1; j < nums.length - 2; j++) {
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
                        } else if (sum > target) {
                            // 相加大于target.说明右边的数太大，应该往左移
                            right--;
                        } else {
                            // 相加小于target，说明左边的数太小，应该往右移
                            left++;
                        }
                    }
                }
            }
            return lists;
        }
    }

    static class Solution2 {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
            if (nums == null || nums.length < 4) {
                return quadruplets;
            }
            Arrays.sort(nums);
            int length = nums.length;
            for (int i = 0; i < length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                // 最小值仍大于 target
                if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                    break;
                }
                // 最大值仍小于target
                if ((long) nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                for (int j = i + 1; j < length - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                        break;
                    }
                    if ((long) nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                        continue;
                    }
                    int left = j + 1, right = length - 1;
                    while (left < right) {
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum == target) {
                            quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            while (left < right && nums[left] == nums[left + 1]) {
                                left++;
                            }
                            left++;
                            while (left < right && nums[right] == nums[right - 1]) {
                                right--;
                            }
                            right--;
                        } else if (sum < target) {
                            left++;
                        } else {
                            right--;
                        }
                    }
                }
            }
            return quadruplets;
        }
    }

}

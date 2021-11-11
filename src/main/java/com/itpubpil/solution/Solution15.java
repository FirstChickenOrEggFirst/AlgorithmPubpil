package com.itpubpil.solution;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wangjingbiao
 * createDate: 2021/11/11 周四 4:51 下午
 * desc:
 */
public class Solution15 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(solution.threeSum(new int[]{7, -1, 14, -12, -8, 7, 2, -15, 8, 8, -8, -14, -4, -5, 7, 9, 11, -4, -15, -6, 1, -14, 4, 3, 10, -5, 2, 1, 6, 11, 2, -2, -5, -7, -6, 2, -15, 11, -6, 8, -4, 2, 1, -1, 4, -6, -15, 1, 5, -15, 10, 14, 9, -8, -6, 4, -6, 11, 12, -15, 7, -1, -9, 9, -1, 0, -4, -1, -12, -2, 14, -9, 7, 0, -3, -4, 1, -2, 12, 14, -10, 0, 5, 14, -1, 14, 3, 8, 10, -8, 8, -5, -2, 6, -11, 12, 13, -7, -12, 8, 6, -13, 14, -2, -5, -11, 1, 3, -6}));

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(solution2.threeSum(new int[]{7, -1, 14, -12, -8, 7, 2, -15, 8, 8, -8, -14, -4, -5, 7, 9, 11, -4, -15, -6, 1, -14, 4, 3, 10, -5, 2, 1, 6, 11, 2, -2, -5, -7, -6, 2, -15, 11, -6, 8, -4, 2, 1, -1, 4, -6, -15, 1, 5, -15, 10, 14, 9, -8, -6, 4, -6, 11, 12, -15, 7, -1, -9, 9, -1, 0, -4, -1, -12, -2, 14, -9, 7, 0, -3, -4, 1, -2, 12, 14, -10, 0, 5, 14, -1, 14, 3, 8, 10, -8, 8, -5, -2, 6, -11, 12, 13, -7, -12, 8, 6, -13, 14, -2, -5, -11, 1, 3, -6}));

    }

    /**
     * 能够解决问题，但是性能比较差，三重循环，时间复杂度为n^3
     */
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> dataList = new ArrayList<>();
            if (nums.length < 3) {
                return dataList;
            }
            // 遍历
            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            List<Integer> numList = new ArrayList<>();
                            numList.add(nums[i]);
                            numList.add(nums[j]);
                            numList.add(nums[k]);
                            dataList.add(numList);
                        }
                    }
                }
            }
            // 去重
            Set<String> distinctSet = new HashSet<>();
            List<List<Integer>> resultList = new ArrayList<>();
            dataList.forEach(numList -> {
                List<Integer> sortedList = numList.parallelStream().sorted().collect(Collectors.toList());
                String key = sortedList.toString();
                if (!distinctSet.contains(key)) {
                    distinctSet.add(key);
                    resultList.add(numList);
                }
            });
            return resultList;
        }
    }

    static class Solution2 {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> lists = new ArrayList<>();
            if (nums.length < 3) {
                return lists;
            }
            // 1.对数组排序
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    // 该位大于0，后面的数不可能相加等于0
                    return lists;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    // 相等跳过，避免重复
                    continue;
                }
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        lists.add(Arrays.asList(nums[i], nums[left], nums[right]));
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
            return lists;
        }
    }
}

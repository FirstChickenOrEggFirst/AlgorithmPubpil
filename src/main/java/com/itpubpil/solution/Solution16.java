package com.itpubpil.solution;

import java.util.Arrays;

/**
 * @author wangjingbiao
 * createDate: 2021/11/12 周五 2:15 下午
 * desc: 16号问题，最接近的三数之和
 */
public class Solution16 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(new int[]{1, 2, 4, 8, 16, 32, 64, 128}, 81));
    }

    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            if (nums.length < 3) {
                throw new RuntimeException("input error");
            }
            int n = nums.length;
            Arrays.sort(nums);
            int minSum = nums[0] + nums[1] + nums[2];
            for (int i = 0; i < n; i++) {
                int left = i + 1, right = n - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        return sum;
                    }
                    if (Math.abs(sum - target) < Math.abs(minSum - target)) {
                        minSum = sum;
                    }
                }
            }
            return minSum;
        }
    }
}

package com.roytrack.dailytest.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 新的一年 刷leetcode第一题 嘿嘿
 * Created by roytrack on 2017-01-03.
 */
public class TwoSum1 {
  public int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          result[0] = i;
          result[1] = j;
          break;
        }
      }
    }
    return result;
  }

  public int[] twoSumBetter(int[] numbers, int target) {
    int[] result = new int[2];
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < numbers.length; i++) {
      if (map.containsKey(target - numbers[i])) {
        result[1] = i + 1;
        result[0] = map.get(target - numbers[i]);
        return result;
      }
      map.put(numbers[i], i + 1);
    }
    return result;
  }
}

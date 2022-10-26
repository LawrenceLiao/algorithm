package week2;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        int max = 0;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
            first.putIfAbsent(nums[i], i);
            if (max == 0) {
                max = 1;
                result = 1;
                continue;
            }

            if (counts.get(nums[i]) > max) {
                max = counts.get(nums[i]);
                result = i - first.get(nums[i]) + 1;
            } else if (counts.get(nums[i]) == max) {
                result = Math.min(i - first.get(nums[i]) + 1, result);
            }
        }
        return result;
    }
}

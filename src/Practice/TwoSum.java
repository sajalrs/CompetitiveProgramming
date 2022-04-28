package Practice;

import java.util.*;

public class TwoSum {
    public int[] twoSumTrivial(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i != j) return new int[]{i, j};
            }
        }
        return null;
    }

    public int[] twoSumTwoPass(int[] nums, int target) {
        Map<Integer, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (indices.containsKey(complement)) {
                indices.get(complement).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                indices.put(complement, list);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (indices.containsKey(num)) {
                int counter = 0;
                List<Integer> list = indices.get(num);
                while (counter < list.size() && list.get(counter) == i) {
                    counter++;
                }
                if (counter < list.size()) {
                    return new int[]{i, list.get(counter)};
                }
            }
        }
        return null;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (indices.containsKey(complement)) {
                return new int[]{i, indices.get(complement)};
            }
            indices.put(nums[i], i);
        }
        return null;
    }
}

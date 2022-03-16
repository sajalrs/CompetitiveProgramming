package LeetCode;

import java.util.*;

public class FindKDistantIndices {
    public List<Integer> findKDistantIndicesTrivial(int[] nums, int key, int k) {

        Set<Integer> kDistantIndices = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                for (int j = Math.max(i - k, 0); j <= Math.min(i + k, nums.length - 1); j++) {
                    kDistantIndices.add(j);
                }
            }

        }

        List<Integer> toReturn = new ArrayList<>();
        for (int num : kDistantIndices) {
            toReturn.add(num);
        }
        Collections.sort(toReturn);
        return toReturn;
    }


    public List<Integer> findKDistantIndicesN(int[] nums, int key, int k) {
        List<Integer> left = new ArrayList<>();

        int count = 0;
        int lastAdded = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                count = k + 1;
            }
            if (count > 0) {
                if (lastAdded != i)
                    left.add(i);
                lastAdded = i;
            }
            count--;
        }
        List<Integer> right = new ArrayList<>();
        lastAdded = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == key) {
                count = k + 1;
            }
            if (count > 0) {
                if (lastAdded != i)
                    right.add(i);
                lastAdded = i;

            }
            count--;
        }

        List<Integer> kDistantIndices = new ArrayList<>();
        int i = 0, j = right.size() - 1;
        lastAdded = -1;
        while (i < left.size() && j >= 0) {
            if (left.get(i) == right.get(j)) {
                if (lastAdded != left.get(i))
                    kDistantIndices.add(left.get(i));
                lastAdded = left.get(i);
                i++;
                j--;
            } else if (left.get(i) < right.get(j)) {
                if (lastAdded != left.get(i))
                    kDistantIndices.add(left.get(i));
                lastAdded = left.get(i);
                i++;
            } else {
                if (lastAdded != right.get(j))
                    kDistantIndices.add(right.get(j));
                lastAdded = right.get(j);
                j--;
            }
        }

        while (i < left.size()) {
            if (lastAdded != left.get(i))
                kDistantIndices.add(left.get(i));
            lastAdded = left.get(i);
            i++;
        }


        while (j >= 0) {
            if (lastAdded != right.get(j))
                kDistantIndices.add(right.get(j));
            lastAdded = right.get(j);
            j--;
        }
        return kDistantIndices;
    }

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        return findKDistantIndicesN(nums, key, k);
    }
}

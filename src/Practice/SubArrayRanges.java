package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubArrayRanges {
    public long subArrayRangesSpace(int[] nums) {
        long total = 0;
        for (int[] subArray : generateSubArrayRanges(nums)) {
            if (subArray.length <= 1) continue;
            ;
            int max = subArray[0];
            int min = subArray[0];
            for (int i = 1; i < subArray.length; i++) {
                max = Math.max(max, subArray[i]);
                min = Math.min(min, subArray[i]);
            }
            total += (max - min);
        }
        return total;
    }

    public List<int[]> generateSubArrayPalindromes(int[] num) {
        if (num.length == 1) {
            List<int[]> toReturn = new ArrayList<>();
            toReturn.add(new int[]{num[0]});
            return toReturn;
        }

        int firstNum = num[0];
        int[] newArr = new int[num.length - 1];
        for (int i = 1; i < num.length; i++) {
            newArr[i - 1] = num[i];
        }

        List<int[]> toReturn = new ArrayList<>();
        toReturn.add(new int[]{firstNum});
        for (int[] arr : generateSubArrayRanges(newArr)) {
            toReturn.add(arr);
            int[] anotherArr = new int[arr.length + 1];
            anotherArr[0] = firstNum;
            for (int i = 0; i < arr.length; i++) {
                anotherArr[i + 1] = arr[i];
            }
            toReturn.add(anotherArr);
        }
        return toReturn;
    }

    public List<int[]> generateSubArrayRanges(int[] num) {
        List<int[]> subArrays = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            for (int j = i; j < num.length; j++) {
                int[] arr = new int[j - i + 1];
                int l = 0;
                for (int k = i; k <= j; k++) {
                    arr[l++] = num[k];
                }
                if (!(l == 0)) {
                    subArrays.add(arr);
                }
            }
        }
        return subArrays;
    }

    public long subArrayRangesN2(int[] nums) {
        long total = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i < 0 || i >= nums.length) continue;
                int min = nums[i];
                int max = nums[i];
                int l = 0;
                for (int k = i + 1; k <= j; k++) {
                    int curInt = nums[k];
                    min = Math.min(min, curInt);
                    max = Math.max(max, curInt);
                }
                total += (max - min);
            }
        }
        return total;
    }

    private class Number implements Comparable<Number> {
        int value;
        int index;

        public Number(int index, int value) {
            this.index = index;
            this.value = value;
        }


        @Override
        public int compareTo(Number number) {
            return Integer.compare(this.value, number.value);
        }
    }

    public long subArrayRanges(int[] nums) {
        List<Number> numbers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numbers.add(new Number(i, nums[i]));
        }
        Collections.sort(numbers);

        long total = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i < 0 || i >= nums.length) continue;
                int k = -1;
                int numIndex;
                do{
                    numIndex = numbers.get(++k).index;
                }while (numIndex < i || numIndex > j);
                int min = numbers.get(k).value;
                k= numbers.size();
                do{
                    numIndex = numbers.get(--k).index;
                }while (numIndex < i || numIndex > j);
                int max = numbers.get(k).value;
                total+=max-min;
            }
        }
        return total;

    }

    public static void main(String[] args) {
        SubArrayRanges subArrayRanges = new SubArrayRanges();
        System.out.println(subArrayRanges.subArrayRanges(new int[]{1, 2, 3}));
        System.out.println(subArrayRanges.subArrayRanges(new int[]{1,3,3}));
        System.out.println(subArrayRanges.subArrayRanges(new int[]{4,-2,-3,4,1}));

    }
}

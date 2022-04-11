package CrackingTheCodingInterview;

import java.util.ArrayList;

public class FlipBitToWin {
    public int longestSequenceO1ButLong(int num) {
        ArrayList<Integer> sequences = new ArrayList<>();
        boolean searchingFor = false;
        int counter = 0;
        int mask = 1;
        boolean found = ((mask & num) != 0) == searchingFor;
        if (found) {
            counter++;
        } else {
            searchingFor = true;
            sequences.add(counter);
            counter = 1;
        }
        for (int i = 1; i < 32; i++) {
            mask <<= 1;
            found = ((mask & num) != 0) == searchingFor;
            if (found) {
                counter++;
            } else {
                searchingFor = !searchingFor;
                sequences.add(counter);
                counter = 1;
            }
        }
        int max = 0;
        for (int i = 0; i < sequences.size(); i++) {
            int sequence = sequences.get(i);
            if (i % 2 == 0) {
                if (sequence == 1) {
                    int left = i > 0 ? sequences.get(i - 1) : 0;
                    int right = i < sequences.size() - 1 ? sequences.get(i + 1) : 0;
                    max = Math.max(max, left + right + 1);
                }
            } else {
                max = Math.max(max, sequence);
            }
        }
        return max;
    }

    public int longestSequenceNotConstantSpace(int num) {
        ArrayList<Integer> sequences = new ArrayList<>();
        boolean searchingFor = false;
        int counter = 0;
        while (num != 0){
            boolean curBit = (num & 1) != 0;
            if(curBit == searchingFor){
                counter++;
            }else {
                searchingFor = !searchingFor;
                sequences.add(counter);
                counter = 1;
            }
            num>>>=1;
        }
        int max = 0;
        for (int i = 0; i < sequences.size(); i++) {
            int sequence = sequences.get(i);
            if (i % 2 == 0) {
                if (sequence == 1) {
                    int left = i > 0 ? sequences.get(i - 1) : 0;
                    int right = i < sequences.size() - 1 ? sequences.get(i + 1) : 0;
                    max = Math.max(max, left + right + 1);
                }
            } else {
                max = Math.max(max, sequence);
            }
        }
        return max;
    }

    public int longestSequence(int num) {
        int curLength = 0;
        int prevLength = 0;
        int max = 1;

        while (num != 0){
            int curBit = (num & 1);
            if(curBit == 1){
                curLength++;
            }else if(curBit == 0) {
                prevLength = (num & 2) == 0? 0: curLength;
                curLength = 0;
            }
            max = Math.max(prevLength + curLength + 1, max);
            num>>>=1;
        }
        return max;
    }

    public static void main(String args[]) {
        FlipBitToWin flipBitToWin = new FlipBitToWin();
        System.out.println(flipBitToWin.longestSequence(1775));
    }
}

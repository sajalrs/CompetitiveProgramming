package CrackingTheCodingInterview;

import java.util.*;

public class PowerSet {
//    List<Set<Integer>> powerSet(Set<Integer> set){
//        List<Set<Integer>> returnValue = powerSetHelperDivideAndConquer(new ArrayList<>(set));
//        returnValue.add(new TreeSet<>());
//        return returnValue;
//    }

    List<Set<Integer>> powerSet(Set<Integer> set){
        return powerSetHelperBitWise(new ArrayList<>(set));
    }

    public List<Set<Integer>> powerSetHelperDivideAndConquer(List<Integer> list){
        if(list.size() == 1){
            List<Set<Integer>> returnValue = new ArrayList<>();
            returnValue.add(new TreeSet<>(list));
            return returnValue;
        }
        List<Set<Integer>> returnValue = new ArrayList<>();

        int firstItem = list.get(0);
        Set<Integer> setWithFirst = new TreeSet<>();
        setWithFirst.add(firstItem);
        returnValue.add(setWithFirst);

        List<Integer> remaining = new ArrayList<>();
        for(int i=1; i<list.size(); i++){
            remaining.add(list.get(i));
        }

        for(Set<Integer> set: powerSetHelperDivideAndConquer(remaining)){
            returnValue.add(set);
            Set<Integer> newSet = new TreeSet<>(set);
            newSet.add(firstItem);
            returnValue.add(newSet);
        }
        return returnValue;
    }

    public List<Set<Integer>> powerSetHelperBitWise(List<Integer> list){
        int i= (1<< list.size());
        List<Set<Integer>> returnValue = new ArrayList<>();
        for(int k=0; k<i; k++){
            returnValue.add(binaryDigitToSet(list, k));
        }
        return returnValue;
    }

    public Set<Integer> binaryDigitToSet(List<Integer> list, int binDigit){
        int index = 0;
        Set<Integer> returnValue = new HashSet<>();
        while (binDigit != 0){
            if((binDigit & 1) == 1){
                returnValue.add(list.get(index));
            }
            index++;
            binDigit>>=1;
        }
        return returnValue;
    }


    public List<String> generateCombinations(String string){
        List<String> returnValue = new ArrayList<>();
        int i = 1<<string.length();
        for(int j=1; j<i; j++){
            returnValue.add(binaryToString(j, string));
        }
        return returnValue;
    }

    public String binaryToString(int digit, String string){
        StringBuilder combination = new StringBuilder();
        int index = 0;
        for(int i=digit; i>0; i>>=1){
            if((i & 1) == 1) combination.append(string.charAt(index));

            index++;
        }
        return combination.toString();
    }


    public static void main(String[] args){
        PowerSet powerSet = new PowerSet();
//        Set<Integer> set = new TreeSet<>();
//        set.add(0);
//        set.add(2);
//        set.add(6);
//        set.add(123);
//        int count =1;
//        for(Set<Integer> subSet: powerSet.powerSet(set)){
//            System.out.print(count++ + ": ");
//            for(int item: subSet){
//                System.out.print(item + ",");
//            }
//            System.out.println();

        for(String string: powerSet.generateCombinations("ab")){
            System.out.println(string);
        }


    }
}

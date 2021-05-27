package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MaxAverageRatio {
    //Solution
    //Dynamic
    //Maximize Average Pass Ratio
    //Intuition 1: Assign to classes with lowest pass ratio

    class Classes {

        int pass;
        int total;
        double passAverage;
        double differenceMade;

        Classes (int pass, int total){
            differenceMade = (pass+1/(double) total+1) - (pass/(double) total);
            this.pass = pass;
            this.total = total;
            passAverage = pass/(double) total;

        }

        public void addStudents(int x){
            differenceMade = (pass+1/(double) total+1) - (pass/(double) total);
            pass+=x;
            total+=x;
            passAverage = pass/(double) total;

        }





    }


    public double maxAverageRatio(int[][] classes, int extraStudents) {

        List<Classes> classesList = new ArrayList<>();

        for(int i = 0; i< classes.length; i++){
            classesList.add(new Classes(classes[i][0], classes[i][1]));
        }

        quickSort(classesList);
        while (extraStudents > 0){
            classesList.get(classesList.size()-1).addStudents(1);
            extraStudents--;
            modifiedBubbleSort(classesList);
        }

        double totalPassRatio = 0;

        for(Classes classesInstance: classesList){
            System.out.println(classesInstance.passAverage);
            totalPassRatio+= classesInstance.passAverage;
        }

        return totalPassRatio/classesList.size();
    }

    private void modifiedBubbleSort(List<Classes> classesList){
        if(classesList.size()<2){
            return;
        }

        int i = classesList.size()-1;
        while (i > 0 && classesList.get(i).differenceMade < classesList.get(i-1).differenceMade){
            Classes temp = classesList.get(i);
            classesList.set(i, classesList.get(i-1));
            classesList.set(i-1, temp);
            i--;
        }


    }

    private int partition(List<Classes> classesList, int l, int r){
        double pivot = classesList.get(r).differenceMade;
        int origRight = r;
        r--;

        while (true){

            while(r>0 && classesList.get(r).differenceMade > pivot){
                r--;
            }

            while(l<classesList.size() && classesList.get(l).differenceMade < pivot){
                l++;
            }

            if(l>=r){
                break;
            }

            Classes temp = classesList.get(l);
            classesList.set(l, classesList.get(r));
            classesList.set(r, temp);
        }

        Classes temp = classesList.get(l);
        classesList.set(l, classesList.get(origRight));
        classesList.set(origRight, temp);

        return l;
    }

    private void quickSort(List<Classes> classesList, int l, int r){
        if(l<r){
            int partition = partition(classesList, l, r);
            quickSort(classesList, l, partition-1);
            quickSort(classesList, partition+1, r);
        }
    }

    private void quickSort(List<Classes> classesList){
        quickSort(classesList, 0, classesList.size()-1);
    }

    public static void main(String[] args){
        MaxAverageRatio maxAverageRatio = new MaxAverageRatio();
        int[][] classes = new int[][]{new int[]{1,2},new int[]{3,5},new int[]{2,2}};

        System.out.println(maxAverageRatio.maxAverageRatio(classes,2));


    }

}

package CrackingTheCodingInterview;

public class TowersOfHanoi {
    public void towersOfHanoi(int n) {
        moveBetween(n, 'A', 'B', 'C');
    }

    public void moveBetween(int n, char from, char helper, char to) {
        if (n==0) return;
        moveBetween(n-1, from, to, helper);
        System.out.printf("Move disk %d from %s to %s%n", n, from, to);
        moveBetween(n-1, helper, from, to);
    }

    public static void main(String[] args){
        TowersOfHanoi towersOfHanoi = new TowersOfHanoi();
        towersOfHanoi.towersOfHanoi(2);
        System.out.println();
        towersOfHanoi.towersOfHanoi(3);
    }
}

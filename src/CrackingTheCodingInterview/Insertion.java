package CrackingTheCodingInterview;

public class Insertion {
    public int insertion(int i, int j, int M, int N){
        if(i>j|| i<0 || j>=32) return 0;
        int allOnes = ~0;
        int left = j < 31 ? (allOnes << j+1):0;
        int right = ((1 << i) - 1);
        int mask = left | right;
        int M_shifted = M << i;
        int N_cleared = mask & N;
        return M_shifted | N_cleared;
    }
}

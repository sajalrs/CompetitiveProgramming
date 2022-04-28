package Practice;

public class KthFactor {
    public int kthFactor(int n, int k) {
        int i=1;
        for(; i<=n; i++){
            if(n%i == 0) k--;
            if(k==0) break;
        }
        return k==0? i: -1;
    }

    public static void main(String[] args){
        KthFactor kthFactor = new KthFactor();
        System.out.println(kthFactor.kthFactor(7,2));
        System.out.println(kthFactor.kthFactor(12,3));
        System.out.println(kthFactor.kthFactor(4,4));
    }
}

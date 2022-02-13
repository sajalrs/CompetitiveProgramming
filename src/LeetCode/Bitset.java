package LeetCode;

public class Bitset {
    boolean[] bits;
    int size;
    int ones = 0;
    boolean isInverse;

    public Bitset(int size) {
        bits = new boolean[size];
        this.size = size;
    }

    public void fix(int idx) {
        if (!isInverse) {
            if (!bits[idx] == true) {
                bits[idx] = true;
                ones = Math.min(size, ones + 1);
            }
        } else {
            if (!bits[idx] == false) {
                bits[idx] = false;
                ones = Math.min(size, ones + 1);
            }
        }
    }

    public void unfix(int idx) {
        if (!isInverse) {
            if (!bits[idx] == false) {
                bits[idx] = false;
                ones = Math.max(0, ones - 1);
            }
        } else {
            if (!bits[idx] == true) {
                bits[idx] = true;
                ones = Math.max(0, ones - 1);
            }
        }
    }

    public void flip() {
        isInverse = !isInverse;
        ones = size - ones;
    }

    public boolean all() {
        return size == ones;
    }

    public boolean one() {
        return ones > 0;
    }

    public int count() {
        return ones;
    }

    public String toString() {
        StringBuilder bitset = new StringBuilder(size);
        for (boolean bit : bits) {
            if (!isInverse) {
                bitset.append(bit ? '1' : '0');
            } else {
                bitset.append(bit ? '0' : '1');
            }
        }
        return bitset.toString();
    }

    public static void main(String[] args) {
        Bitset.bitsetCommandReader(new String[]{"Bitset", "flip", "unfix", "all", "fix", "fix", "unfix", "all", "count", "toString", "toString", "toString", "unfix", "flip", "all", "unfix", "one", "one", "all", "fix", "unfix"}, new int[]{2, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    }

    private static void bitsetCommandReader(String[] commands, int[] inputs) {
        Bitset bs = new Bitset(0);
        System.out.print("[");
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            int input = inputs[i];
            switch (command) {
                case "Bitset":
                    bs = new Bitset(input);
                    System.out.print("null");
                    break;
                case "flip":
                    bs.flip();
                    System.out.print("null");
                    break;
                case "fix":
                    bs.fix(input);
                    System.out.print("null");
                    break;
                case "unfix":
                    bs.unfix(input);
                    System.out.print("null");
                    break;
                case "one":
                    System.out.print(bs.one());
                    break;
                case "all":
                    System.out.print(bs.all());
                    break;
                case "count":
                    System.out.print(bs.count());
                    break;
                case "toString":
                    System.out.print(bs.toString());
            }
            System.out.print(",");
        }
        System.out.print("]");

    }
}

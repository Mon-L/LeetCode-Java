package easy;

public class _693_HasAlternatingBits {

    public boolean hasAlternatingBits(int n) {
        int x = n ^ (n >> 1);
        return (x & (x + 1)) == 0;
    }

    public static void main(String[] args) {
    }
}

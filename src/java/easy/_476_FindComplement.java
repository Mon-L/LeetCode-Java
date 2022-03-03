package easy;

public class _476_FindComplement {

    public int findComplement(int num) {
        int ans = 0;
        int i = 0;
        while (num != 0) {
            if ((num & 1) == 0) {
                ans += 1 << i;
            }
            i++;
            num >>>= 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new _476_FindComplement().findComplement(5));
        System.out.println(new _476_FindComplement().findComplement(1));
        System.out.println(new _476_FindComplement().findComplement(-1));
    }
}

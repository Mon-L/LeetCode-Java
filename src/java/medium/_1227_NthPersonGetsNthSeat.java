package medium;

public class _1227_NthPersonGetsNthSeat {
    public double nthPersonGetsNthSeat(int n) {
        return n == 1 ? 1.0 : 0.5;
    }

    public static void main(String[] args) {
        System.out.println(new _1227_NthPersonGetsNthSeat().nthPersonGetsNthSeat(1));
        System.out.println(new _1227_NthPersonGetsNthSeat().nthPersonGetsNthSeat(2));
        System.out.println(new _1227_NthPersonGetsNthSeat().nthPersonGetsNthSeat(3));
    }
}

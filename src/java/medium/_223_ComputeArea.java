package medium;

public class _223_ComputeArea {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area = (ax2 - ax1) * (ay2 - ay1) + (by2 - by1) * (bx2 - bx1);
        int l = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        if (l <= 0) {
            return area;
        }

        int w = Math.min(ay2, by2) - Math.max(ay1, by1);
        if (w <= 0) {
            return area;
        }

        return area - l * w;
    }

    public static void main(String[] args) {
        //ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2     --->  45
        System.out.println(new _223_ComputeArea().computeArea(-3, 0, 3, 4, 0, -1, 9, 2));

        //ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2   --->   16
        System.out.println(new _223_ComputeArea().computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
    }
}

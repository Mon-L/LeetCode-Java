package hard;

public class _1601_MaximumRequests {

    private int max;

    public int maximumRequests(int n, int[][] requests) {
        int[] delta = new int[n];
        process(0, requests, delta, n, 0);
        return max;
    }

    private void process(int pos, int[][] requests, int[] delta, int zero, int count) {
        if (pos == requests.length) {
            if (zero == delta.length) {
                max = Math.max(max, count);
            }
            return;
        }

        //处理
        int[] req = requests[pos];
        int a = req[0], b = req[1], z = zero;

        z -= delta[a] == 0 ? 1 : 0;
        delta[a]--;
        z += delta[a] == 0 ? 1 : 0;

        z -= delta[b] == 0 ? 1 : 0;
        delta[b]++;
        z += delta[b] == 0 ? 1 : 0;

        process(pos + 1, requests, delta, z, count + 1);
        delta[a]++;
        delta[b]--;

        //不处理
        process(pos + 1, requests, delta, zero, count);
    }

    public static void main(String[] args) {
        int[][] requests = new int[][]{
                {0, 1}, {1, 0}, {0, 1}, {1, 2}, {2, 0}, {3, 4}
        };
        System.out.println(new _1601_MaximumRequests().maximumRequests(5, requests));  //5

        requests = new int[][]{
                {0, 0}, {1, 2}, {2, 1}
        };
        System.out.println(new _1601_MaximumRequests().maximumRequests(3, requests));  //3

        requests = new int[][]{
                {0, 3}, {3, 1}, {1, 2}, {2, 0}
        };
        System.out.println(new _1601_MaximumRequests().maximumRequests(4, requests)); //4
    }
}

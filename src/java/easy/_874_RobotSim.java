package easy;

import java.util.HashSet;
import java.util.Set;

public class _874_RobotSim {

    private static final int[] dx = new int[]{0, 1, 0, -1};
    private static final int[] dy = new int[]{1, 0, -1, 0};

    public int robotSim(int[] commands, int[][] obstacles) {
        int di = 0, x = 0, y = 0, ret = 0;
        Set<Long> obstacleSet = new HashSet<>();
        for (int[] ob : obstacles) {
            long code = ((long) (ob[0] + 30000) << 16) + ob[1] + 30000;
            obstacleSet.add(code);
        }

        for (int c : commands) {
            if (c >= 1 && c <= 9) {
                for (int i = 1; i <= c; i++) {
                    int x2 = dx[di] + x, y2 = dy[di] + y;
                    long code = ((long) (x2 + 30000) << 16) + y2 + 30000;

                    if (!obstacleSet.contains(code)) {
                        x = x2;
                        y = y2;
                        ret = Math.max(ret, x * x + y * y);
                    } else {
                        break;
                    }
                }
            } else if (c == -1) {
                di = (di + 1) % 4;
            } else if (c == -2) {
                di = (di + 3) % 4;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] commands;
        int[][] obstacles;

        commands = new int[]{4, -1, 3}; //25
        obstacles = new int[][]{};
        System.out.println(new _874_RobotSim().robotSim(commands, obstacles));

        commands = new int[]{4, -1, 4, -2, 4};  //65
        obstacles = new int[][]{{2, 4}};
        System.out.println(new _874_RobotSim().robotSim(commands, obstacles));

        commands = new int[]{-2, 8, 9, 4, 2};  //529
        obstacles = new int[][]{{-5, 1}, {2, 0}, {3, 4}, {-5, 5}, {-4, 2}, {-1, 3}, {3, -4}, {-5, -2}, {5, 3}, {-3, -4}};
        System.out.println(new _874_RobotSim().robotSim(commands, obstacles));
    }

}

package p02.eve;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ex8 {

    static final int WIDTH = 80;
    static final int HEIGHT = 30;

    static final double X_MIN = -1.4, X_MAX = 1.4;
    static final double Y_MIN = -1.4, Y_MAX = 1.0;

    static final String RED = "\u001B[31m";
    static final String RESET = "\u001B[0m";

    public static void main(String[] args) throws InterruptedException {
        double cx = 0.0;
        double cy = -0.15;

        List<double[]> heartPoints = new ArrayList<>();
        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                double x = X_MIN + (X_MAX - X_MIN) * col / (WIDTH - 1);
                double y = Y_MAX - (Y_MAX - Y_MIN) * row / (HEIGHT - 1);
                if (isInsideHeart(x, y)) {
                    heartPoints.add(new double[]{row, col});
                }
            }
        }

        Collections.sort(heartPoints, new Comparator<double[]>() {
            @Override
            public int compare(double[] a, double[] b) {
                double angleA = angle(a, cx, cy);
                double angleB = angle(b, cx, cy);
                return Double.compare(angleA, angleB);
            }
        });

        boolean[][] visited = new boolean[HEIGHT][WIDTH];

        System.out.print("\u001B[2J");
        System.out.print("\u001B[H");

        for (int i = 0; i < heartPoints.size(); i++) {
            double[] p = heartPoints.get(i);
            int r = (int) p[0];
            int c = (int) p[1];
            visited[r][c] = true;

            if (i % 2 == 0) {
                printFrame(visited);
                Thread.sleep(20);
            }
        }

        printFrame(visited);
        System.out.println();
        System.out.println(RED + "        ***  Love is growing...  ***" + RESET);
    }

    static double angle(double[] p, double cx, double cy) {
        double x = X_MIN + (X_MAX - X_MIN) * p[1] / (WIDTH - 1);
        double y = Y_MAX - (Y_MAX - Y_MIN) * p[0] / (HEIGHT - 1);
        double a = Math.atan2(y - cy, x - cx);
        return Math.toDegrees((a + 2 * Math.PI - Math.PI / 2) % (2 * Math.PI));
    }

    static boolean isInsideHeart(double x, double y) {
        double t = x * x + y * y - 1;
        return t * t * t - x * x * y * y * y <= 0;
    }

    static void printFrame(boolean[][] visited) {
        StringBuilder sb = new StringBuilder();
        sb.append("\u001B[H");
        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                if (visited[row][col]) {
                    sb.append(RED).append('\u2665').append(RESET);
                } else {
                    sb.append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}

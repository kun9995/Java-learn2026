package JAVAlearning.own;

import java.util.Scanner;
import java.util.Random;

/**
 * 数字华容道小游戏（4x4，15宫格拼图）
 * 玩法：输入要移动的数字编号，把它滑入旁边的空格，
 * 目标是让数字按 1-15 顺序排列，右下角留空格。
 */
public class as {

    static final int SIZE = 4;        // 棋盘大小 4x4
    static int[][] board = new int[SIZE][SIZE];
    static int emptyR = 0;            // 空格所在行
    static int emptyC = 0;            // 空格所在列
    static int steps = 0;             // 已走步数

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("========== 欢迎来到数字华容道 ==========");
        System.out.println("目标：把数字按 1-15 顺序排列，右下角为空格");
        System.out.println("玩法：输入要移动的数字编号（1-15），它会滑入相邻空格");
        System.out.println("输入 0 退出游戏，输入 -1 重新开局");

        // 初始化棋盘：按顺序填 1-15，0 表示空格
        initBoard();
        // 通过模拟随机移动来打乱，保证一定有解
        shuffle(random, 200);

        printBoard();

        while (true) {
            System.out.print("请输入要移动的数字编号: ");
            if (!scanner.hasNextInt()) {
                scanner.next();  // 丢弃非法输入
                System.out.println("输入无效，请输入数字！");
                continue;
            }
            int num = scanner.nextInt();

            if (num == 0) {
                System.out.println("游戏结束，下次再玩！");
                break;
            }
            if (num == -1) {
                initBoard();
                shuffle(random, 200);
                steps = 0;
                System.out.println("已重新开局！");
                printBoard();
                continue;
            }

            if (num < 1 || num > 15) {
                System.out.println("请输入 1-15 之间的数字！");
                continue;
            }

            // 找到该数字的位置
            int tr = -1, tc = -1;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (board[i][j] == num) {
                        tr = i;
                        tc = j;
                    }
                }
            }

            // 判断是否与空格相邻（上下左右一格）
            int dr = Math.abs(tr - emptyR);
            int dc = Math.abs(tc - emptyC);
            if ((dr == 1 && dc == 0) || (dr == 0 && dc == 1)) {
                board[emptyR][emptyC] = num;   // 数字滑入空格
                board[tr][tc] = 0;             // 原位置变成新空格
                emptyR = tr;
                emptyC = tc;
                steps++;
                printBoard();

                if (isWin()) {
                    System.out.println("恭喜通关！你一共用了 " + steps + " 步，太棒了！");
                    break;
                }
            } else {
                System.out.println(num + " 旁边没有空格，无法移动，再想想～");
            }
        }
        scanner.close();
    }

    /** 按 1-15 顺序初始化棋盘，0 表示空格 */
    static void initBoard() {
        int value = 1;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = value;
                value++;
            }
        }
        board[SIZE - 1][SIZE - 1] = 0;  // 右下角为空格
        emptyR = SIZE - 1;
        emptyC = SIZE - 1;
        steps = 0;
    }

    /** 模拟 count 次随机合法移动来打乱棋盘 */
    static void shuffle(Random random, int count) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int lastR = -1, lastC = -1;  // 记录上一步位置，避免来回移动

        for (int k = 0; k < count; k++) {
            int r, c;
            do {
                int dir = random.nextInt(4);
                r = emptyR + dr[dir];
                c = emptyC + dc[dir];
            } while (r < 0 || r >= SIZE || c < 0 || c >= SIZE
                    || (r == lastR && c == lastC));  // 不允许立刻退回

            lastR = emptyR;
            lastC = emptyC;
            board[emptyR][emptyC] = board[r][c];
            board[r][c] = 0;
            emptyR = r;
            emptyC = c;
        }
    }

    /** 打印棋盘 */
    static void printBoard() {
        System.out.println("--------------------------");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) {
                    System.out.printf("%4s", " .");   // 空格用 . 表示
                } else {
                    System.out.printf("%4d", board[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println("当前步数: " + steps);
        System.out.println("--------------------------");
    }

    /** 判断是否完成：1-15 顺序排列，最后一个是空格 */
    static boolean isWin() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int expect = i * SIZE + j + 1;
                if (i == SIZE - 1 && j == SIZE - 1) {
                    if (board[i][j] != 0) {
                        return false;
                    }
                } else if (board[i][j] != expect) {
                    return false;
                }
            }
        }
        return true;
    }
}

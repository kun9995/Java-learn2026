package JAVAlearning.own;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class aa extends JPanel implements ActionListener {

    private static final int TILE_SIZE = 25;
    private static final int BOARD_WIDTH = 25;
    private static final int BOARD_HEIGHT = 25;
    private static final int SCREEN_WIDTH = TILE_SIZE * BOARD_WIDTH;
    private static final int SCREEN_HEIGHT = TILE_SIZE * BOARD_HEIGHT;
    private static final int INITIAL_DELAY = 120;

    private final ArrayList<Point> snake = new ArrayList<>();
    private Point food;
    private final Random random;
    private Timer timer;
    private int direction;
    private int nextDirection;
    private boolean running = true;
    private boolean paused = false;
    private int score = 0;

    private static final int UP = 0;
    private static final int DOWN = 1;
    private static final int LEFT = 2;
    private static final int RIGHT = 3;

    public aa() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        random = new Random();
        initGame();
    }

    private void initGame() {
        snake.clear();
        snake.add(new Point(5, 12));
        snake.add(new Point(4, 12));
        snake.add(new Point(3, 12));
        direction = RIGHT;
        nextDirection = RIGHT;
        score = 0;
        running = true;
        paused = false;
        spawnFood();
        if (timer != null) {
            timer.stop();
        }
        timer = new Timer(INITIAL_DELAY, this);
        timer.start();
    }

    private void spawnFood() {
        int x, y;
        do {
            x = random.nextInt(BOARD_WIDTH);
            y = random.nextInt(BOARD_HEIGHT);
        } while (isSnakeBody(x, y));
        food = new Point(x, y);
    }

    private boolean isSnakeBody(int x, int y) {
        for (Point p : snake) {
            if (p.x == x && p.y == y) return true;
        }
        return false;
    }

    private void move() {
        direction = nextDirection;
        Point head = snake.get(0);
        Point newHead;
        switch (direction) {
            case UP:
                newHead = new Point(head.x, head.y - 1);
                break;
            case DOWN:
                newHead = new Point(head.x, head.y + 1);
                break;
            case LEFT:
                newHead = new Point(head.x - 1, head.y);
                break;
            default:
                newHead = new Point(head.x + 1, head.y);
                break;
        }

        if (newHead.x < 0 || newHead.x >= BOARD_WIDTH ||
                newHead.y < 0 || newHead.y >= BOARD_HEIGHT) {
            running = false;
            return;
        }

        for (int i = 0; i < snake.size(); i++) {
            if (snake.get(i).equals(newHead)) {
                running = false;
                return;
            }
        }

        snake.add(0, newHead);

        if (newHead.equals(food)) {
            score += 10;
            spawnFood();
            if (timer.getDelay() > 50) {
                timer.setDelay(timer.getDelay() - 2);
            }
        } else {
            snake.remove(snake.size() - 1);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        g.setColor(new Color(30, 30, 30));
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            g.drawLine(i * TILE_SIZE, 0, i * TILE_SIZE, SCREEN_HEIGHT);
            g.drawLine(0, i * TILE_SIZE, SCREEN_WIDTH, i * TILE_SIZE);
        }

        if (food != null) {
            g.setColor(Color.RED);
            g.fillOval(food.x * TILE_SIZE + 2, food.y * TILE_SIZE + 2,
                    TILE_SIZE - 4, TILE_SIZE - 4);
        }

        for (int i = 0; i < snake.size(); i++) {
            if (i == 0) {
                g.setColor(new Color(0, 200, 0));
            } else {
                g.setColor(new Color(45, 180, 0));
            }
            g.fillRoundRect(snake.get(i).x * TILE_SIZE + 1,
                    snake.get(i).y * TILE_SIZE + 1,
                    TILE_SIZE - 2, TILE_SIZE - 2, 6, 6);
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
        FontMetrics fm = g.getFontMetrics();
        g.drawString("分数: " + score, 10, fm.getAscent() + 5);

        if (paused && running) {
            drawCenteredString(g, "已暂停", Color.YELLOW);
        }

        if (!running) {
            drawCenteredString(g, "游戏结束!  得分: " + score, Color.RED);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
            String hint = "按 R 重新开始";
            int hintW = fm.stringWidth(hint);
            g.drawString(hint, (SCREEN_WIDTH - hintW) / 2, SCREEN_HEIGHT / 2 + 40);
        }
    }

    private void drawCenteredString(Graphics g, String text, Color color) {
        g.setColor(color);
        g.setFont(new Font("Microsoft YaHei", Font.BOLD, 30));
        FontMetrics fm = g.getFontMetrics();
        int x = (SCREEN_WIDTH - fm.stringWidth(text)) / 2;
        int y = (SCREEN_HEIGHT + fm.getAscent()) / 2;
        g.drawString(text, x, y);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running && !paused) {
            move();
        }
        repaint();
    }

    private class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_R && !running) {
                initGame();
                return;
            }

            if (key == KeyEvent.VK_P || key == KeyEvent.VK_SPACE) {
                if (running) {
                    paused = !paused;
                }
                return;
            }

            if (paused) return;

            switch (key) {
                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    if (direction != DOWN) nextDirection = UP;
                    break;
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    if (direction != UP) nextDirection = DOWN;
                    break;
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
                    if (direction != RIGHT) nextDirection = LEFT;
                    break;
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    if (direction != LEFT) nextDirection = RIGHT;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("贪吃蛇");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        aa game = new aa();
        frame.add(game);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
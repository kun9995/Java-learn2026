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
    private static final int PANEL_HEIGHT = 40;
    private static final int INITIAL_DELAY = 120;
    private static final int MIN_DELAY = 50;

    private enum Direction { UP, DOWN, LEFT, RIGHT }

    private final ArrayList<Point> snake = new ArrayList<>();
    private Point food;
    private final Random random;
    private Timer timer;
    private Direction direction;
    private Direction nextDirection;
    private boolean running = true;
    private boolean paused = false;
    private int score = 0;
    private int tickCount = 0;

    private static final Color BG_COLOR = new Color(25, 25, 35);
    private static final Color GRID_COLOR = new Color(40, 40, 55);
    private static final Color SNAKE_HEAD = new Color(0, 220, 100);
    private static final Color SNAKE_BODY_START = new Color(0, 180, 80);
    private static final Color SNAKE_BODY_END = new Color(0, 100, 50);
    private static final Color FOOD_COLOR = new Color(230, 50, 60);
    private static final Color FOOD_HIGHLIGHT = new Color(255, 150, 150);
    private static final Color ACCENT_COLOR = new Color(80, 160, 255);
    private static final Color TEXT_COLOR = new Color(220, 220, 230);

    public aa() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT + PANEL_HEIGHT));
        this.setBackground(BG_COLOR);
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
        direction = Direction.RIGHT;
        nextDirection = Direction.RIGHT;
        score = 0;
        running = true;
        paused = false;
        tickCount = 0;
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
            timer.stop();
            return;
        }

        for (Point p : snake) {
            if (p.equals(newHead)) {
                running = false;
                timer.stop();
                return;
            }
        }

        snake.add(0, newHead);

        if (newHead.equals(food)) {
            score += 10;
            spawnFood();
            if (timer.getDelay() > MIN_DELAY) {
                timer.setDelay(timer.getDelay() - 2);
            }
        } else {
            snake.remove(snake.size() - 1);
        }
        tickCount++;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        draw(g2d);
    }

    private void draw(Graphics2D g) {
        drawBackground(g);
        drawFood(g);
        drawSnake(g);
        drawPanel(g);

        if (paused && running) {
            drawOverlay(g, "已  暂  停", Color.YELLOW, "按 P 或 空格 继续");
        }
        if (!running) {
            drawOverlay(g, "游 戏 结 束", new Color(255, 80, 80),
                    "得分: " + score + "  |  按 R 重新开始");
        }
    }

    private void drawBackground(Graphics2D g) {
        g.setColor(BG_COLOR);
        g.fillRect(0, PANEL_HEIGHT, SCREEN_WIDTH, SCREEN_HEIGHT);

        g.setColor(GRID_COLOR);
        g.setStroke(new BasicStroke(0.5f));
        for (int i = 0; i <= BOARD_WIDTH; i++) {
            g.drawLine(i * TILE_SIZE, PANEL_HEIGHT, i * TILE_SIZE, PANEL_HEIGHT + SCREEN_HEIGHT);
        }
        for (int i = 0; i <= BOARD_HEIGHT; i++) {
            g.drawLine(0, PANEL_HEIGHT + i * TILE_SIZE, SCREEN_WIDTH, PANEL_HEIGHT + i * TILE_SIZE);
        }

        g.setColor(new Color(60, 60, 80));
        g.setStroke(new BasicStroke(2f));
        g.drawRect(0, PANEL_HEIGHT, SCREEN_WIDTH - 1, SCREEN_HEIGHT - 1);
    }

    private void drawFood(Graphics2D g) {
        if (food == null) return;
        int px = food.x * TILE_SIZE;
        int py = food.y * TILE_SIZE + PANEL_HEIGHT;
        int size = TILE_SIZE - 4;

        g.setColor(new Color(FOOD_COLOR.getRed(), FOOD_COLOR.getGreen(), FOOD_COLOR.getBlue(), 40));
        g.fillOval(px, py, TILE_SIZE, TILE_SIZE);

        g.setColor(FOOD_COLOR);
        g.fillOval(px + 2, py + 4, size, size);

        g.setColor(FOOD_HIGHLIGHT);
        g.fillOval(px + 6, py + 6, 5, 5);

        g.setColor(new Color(60, 140, 30));
        g.setStroke(new BasicStroke(2f));
        g.drawLine(px + TILE_SIZE / 2, py + 3, px + TILE_SIZE / 2 + 3, py - 1);
    }

    private void drawSnake(Graphics2D g) {
        int totalLen = snake.size();
        for (int i = totalLen - 1; i >= 0; i--) {
            Point p = snake.get(i);
            int px = p.x * TILE_SIZE;
            int py = p.y * TILE_SIZE + PANEL_HEIGHT;

            Color color;
            if (i == 0) {
                color = SNAKE_HEAD;
            } else {
                float ratio = (float) i / totalLen;
                color = lerpColor(SNAKE_BODY_START, SNAKE_BODY_END, ratio);
            }

            g.setColor(color);
            if (i == 0) {
                g.fillRoundRect(px + 1, py + 1, TILE_SIZE - 2, TILE_SIZE - 2, 10, 10);
                drawEyes(g, p, color);
            } else {
                g.fillRoundRect(px + 2, py + 2, TILE_SIZE - 4, TILE_SIZE - 4, 8, 8);
            }
        }
    }

    private void drawEyes(Graphics2D g, Point head, Color headColor) {
        int px = head.x * TILE_SIZE;
        int py = head.y * TILE_SIZE + PANEL_HEIGHT;
        int eyeSize = 6;
        int pupilSize = 3;

        int ex1, ey1, ex2, ey2;
        switch (direction) {
            case UP:
                ex1 = px + 5; ey1 = py + 5;
                ex2 = px + TILE_SIZE - 5 - eyeSize; ey2 = py + 5;
                break;
            case DOWN:
                ex1 = px + 5; ey1 = py + TILE_SIZE - 5 - eyeSize;
                ex2 = px + TILE_SIZE - 5 - eyeSize; ey2 = py + TILE_SIZE - 5 - eyeSize;
                break;
            case LEFT:
                ex1 = px + 5; ey1 = py + 5;
                ex2 = px + 5; ey2 = py + TILE_SIZE - 5 - eyeSize;
                break;
            default:
                ex1 = px + TILE_SIZE - 5 - eyeSize; ey1 = py + 5;
                ex2 = px + TILE_SIZE - 5 - eyeSize; ey2 = py + TILE_SIZE - 5 - eyeSize;
                break;
        }

        g.setColor(Color.WHITE);
        g.fillOval(ex1, ey1, eyeSize, eyeSize);
        g.fillOval(ex2, ey2, eyeSize, eyeSize);

        g.setColor(Color.BLACK);
        g.fillOval(ex1 + 1, ey1 + 1, pupilSize, pupilSize);
        g.fillOval(ex2 + 1, ey2 + 1, pupilSize, pupilSize);
    }

    private void drawPanel(Graphics2D g) {
        GradientPanel(g);

        g.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
        g.setColor(TEXT_COLOR);
        FontMetrics fm = g.getFontMetrics();
        int ty = (PANEL_HEIGHT + fm.getAscent()) / 2;

        String scoreText = "🎯 分数: " + score;
        String lengthText = "🐍 长度: " + snake.size();
        int speed = (INITIAL_DELAY - timer.getDelay()) * 100 / (INITIAL_DELAY - MIN_DELAY);
        if (speed < 0) speed = 0;
        if (speed > 100) speed = 100;
        String speedText = "⚡ 速度: " + speed + "%";

        g.drawString(scoreText, 15, ty);
        g.drawString(lengthText, 180, ty);
        g.drawString(speedText, 350, ty);
    }

    private void GradientPanel(Graphics2D g) {
        GradientPaint gp = new GradientPaint(0, 0, new Color(35, 35, 50),
                SCREEN_WIDTH, 0, new Color(25, 25, 40));
        g.setPaint(gp);
        g.fillRect(0, 0, SCREEN_WIDTH, PANEL_HEIGHT);
        g.setColor(new Color(60, 60, 80));
        g.drawLine(0, PANEL_HEIGHT - 1, SCREEN_WIDTH, PANEL_HEIGHT - 1);
    }

    private void drawOverlay(Graphics2D g, String title, Color titleColor, String subtitle) {
        g.setColor(new Color(0, 0, 0, 140));
        g.fillRect(0, PANEL_HEIGHT, SCREEN_WIDTH, SCREEN_HEIGHT);

        g.setFont(new Font("Microsoft YaHei", Font.BOLD, 36));
        g.setColor(titleColor);
        FontMetrics fm = g.getFontMetrics();
        int tx = (SCREEN_WIDTH - fm.stringWidth(title)) / 2;
        int ty = PANEL_HEIGHT + (SCREEN_HEIGHT + fm.getAscent()) / 2 - 20;
        g.drawString(title, tx, ty);

        g.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
        g.setColor(TEXT_COLOR);
        fm = g.getFontMetrics();
        int sx = (SCREEN_WIDTH - fm.stringWidth(subtitle)) / 2;
        g.drawString(subtitle, sx, ty + 45);
    }

    private Color lerpColor(Color a, Color b, float t) {
        int r = (int) (a.getRed() + (b.getRed() - a.getRed()) * t);
        int gr = (int) (a.getGreen() + (b.getGreen() - a.getGreen()) * t);
        int bl = (int) (a.getBlue() + (b.getBlue() - a.getBlue()) * t);
        return new Color(r, gr, bl);
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
                repaint();
                return;
            }

            if (key == KeyEvent.VK_P || key == KeyEvent.VK_SPACE) {
                if (running) {
                    paused = !paused;
                }
                return;
            }

            if (paused || !running) return;

            switch (key) {
                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    if (direction != Direction.DOWN) nextDirection = Direction.UP;
                    break;
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    if (direction != Direction.UP) nextDirection = Direction.DOWN;
                    break;
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
                    if (direction != Direction.RIGHT) nextDirection = Direction.LEFT;
                    break;
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    if (direction != Direction.LEFT) nextDirection = Direction.RIGHT;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("🐍 贪吃蛇 Snake");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);

            aa game = new aa();
            frame.add(game);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
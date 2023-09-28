package Homework.Pr88;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

abstract class Shape {
    private Color color;
    private Point position;

    public Shape(Color color, Point position) {
        this.color = color;
        this.position = position;
    }

    public abstract void draw(Graphics g);
}

class RandomShape extends Shape {
    private int width;
    private int height;

    public RandomShape(Color color, Point position, int width, int height) {
        super(color, position);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getPosition().x, getPosition().y, width, height);
    }
}

public class RandomShapesWindow extends JFrame {
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private static final int NUM_SHAPES = 20;

    public RandomShapesWindow() {
        setTitle("Random Shapes");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Random random = new Random();
                for (int i = 0; i < NUM_SHAPES; i++) {
                    int x = random.nextInt(WINDOW_WIDTH);
                    int y = random.nextInt(WINDOW_HEIGHT);
                    Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
                    Shape shape = new RandomShape(color, new Point(x, y), 50, 50);
                    shape.draw(g);
                }
            }
        };

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RandomShapesWindow window = new RandomShapesWindow();
            window.setVisible(true);
        });
    }
}


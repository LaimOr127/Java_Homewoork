package Homework.Pr88;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageDisplayWindow extends JFrame {
    private BufferedImage image;

    public ImageDisplayWindow(BufferedImage image) {
        this.image = image;
        setTitle("Image Display");
        setSize(image.getWidth(), image.getHeight());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, this);
            }
        };

        add(panel);
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java ImageDisplayWindow <image_path>");
            System.exit(1);
        }

        try {
            BufferedImage image = ImageIO.read(new File(args[0]));
            SwingUtilities.invokeLater(() -> {
                ImageDisplayWindow window = new ImageDisplayWindow(image);
                window.setVisible(true);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


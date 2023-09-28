package Homework.Pr88;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationWindow extends JFrame {
    private int currentFrame = 0;
    private ImageIcon[] frames;
    private JLabel animationLabel;

    public AnimationWindow() {
        setTitle("Animation");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Загрузите изображения кадров в массив frames
        String[] framePaths = {"frame1.png", "frame2.png", "frame3.png"};
        frames = new ImageIcon[framePaths.length];
        for (int i = 0; i < framePaths.length; i++) {
            frames[i] = new ImageIcon(framePaths[i]);
        }

        animationLabel = new JLabel();
        add(animationLabel);

        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (frames != null && frames.length > 0) {
                    animationLabel.setIcon(frames[currentFrame]);
                    currentFrame = (currentFrame + 1) % frames.length;
                }
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AnimationWindow window = new AnimationWindow();
            window.setVisible(true);
        });
    }
}


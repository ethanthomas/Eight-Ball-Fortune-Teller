import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by user on 12/13/14.
 */
public class EightBall {

    private static JLabel label;
    private static JPanel contentPane;
    private static JFrame frame;
    private static JButton button;
    private static String[] strings = { "It is certain", "It is decidedly so", "Without a doubt",
            "Yes definitely", "You may rely on it", "As I see it, yes",
            "Most likely", "Outlook good", "Yes", "Signs point to yes",
            "Reply hazy try again", "Ask again later", "Better not tell you now",
            "Cannot predict now", "Concentrate and ask again", "Don't count on it",
            "My reply is no", "My sources say no", "Outlook not so good", "Very doubtful" };

    private final static int VIBRATION_LENGTH = 20;
    private final static int VIBRATION_VELOCITY = 5;

    public static void main(String[] args) {
        gui();
    }

    public static void gui() {
        frame = new JFrame("Magic Eight Ball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setOpaque(true);
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setLayout(null);

        label = new JLabel("", JLabel.CENTER);
        label.setSize(300, 30);
        label.setLocation(45, 35);
        label.setForeground(Color.WHITE);

        button = new JButton("Shake");
        button.setSize(100, 30);
        button.setLocation(145, 75);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vibrate(frame);
                Random random = new Random();
                label.setText(strings[random.nextInt(19)]);
            }
        });

        contentPane.add(label);
        contentPane.add(button);

        frame.setContentPane(contentPane);
        frame.setSize(400, 200);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

    }

    public static void vibrate(Frame frame) {

        try {

            final int originalX = frame.getLocationOnScreen().x;
            final int originalY = frame.getLocationOnScreen().y;
            for(int i = 0; i < VIBRATION_LENGTH; i++) {
                Thread.sleep(10);
                frame.setLocation(originalX, originalY + VIBRATION_VELOCITY);
                Thread.sleep(10);
                frame.setLocation(originalX, originalY - VIBRATION_VELOCITY);
                Thread.sleep(10);
                frame.setLocation(originalX + VIBRATION_VELOCITY, originalY);
                Thread.sleep(10);
                frame.setLocation(originalX, originalY);
            }

        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}

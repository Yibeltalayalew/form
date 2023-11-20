import javax.swing.*;
import java.awt.Rectangle;

class Main {
    private JFrame jFrame = null;
    private JPanel jContentPane = null;
    private JButton butButton = null;
    private JLabel labLabel = null;
    private Timer timer;
    private int counter = 0;

    private JFrame getJFrame() {
        if (jFrame == null) {
            jFrame = new JFrame();
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.setSize(300, 200);
            jFrame.setContentPane(getJContentPane());
            jFrame.setTitle("Application");
        }
        return jFrame;
    }

    private JPanel getJContentPane() {
        if (jContentPane == null) {
            labLabel = new JLabel();
            labLabel.setBounds(new Rectangle(50, 35, 194, 58));
            labLabel.setText("");
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.add(getButButton(), null);
            jContentPane.add(labLabel, null);
        }
        return jContentPane;
    }

    private JButton getButButton() {
        if (butButton == null) {
            butButton = new JButton();
            butButton.setBounds(new Rectangle(58, 110, 177, 46));
            butButton.setText("start");
            butButton.addActionListener(e -> startTimer());
        }
        return butButton;
    }

    private void startTimer() {
        timer = new Timer(1000, e -> {
            if (counter < 10) {
                SwingUtilities.invokeLater(() -> labLabel.setText("Number: " + counter++));
            } else {
                timer.stop();
            }
        });

        timer.start();
    }

    public static void main(String[] args) throws java.lang.Exception {
        SwingUtilities.invokeLater(() -> {
            Main application = new Main();
            application.getJFrame().setVisible(true);
        });
    }
}

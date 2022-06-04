import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartWindow extends JFrame implements ActionListener {

    JTextField tf;
    JButton start;
    StartWindow() {

        this.setTitle("WELCOME");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);

        JPanel panel = new JPanel();
        start = new JButton("START");

        tf = new JTextField(10); // accepts up to 10 characters
        panel.add(tf);
        String input = tf.getText();
        System.out.println(input);

        JLabel label = new JLabel("Enter your name: ");

        start.addActionListener(this);

        panel.add(label);
        panel.add(tf);
        panel.add(start);

        this.add(panel);
        this.getContentPane().add(BorderLayout.CENTER, panel);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
        new Thread(new Game(tf.getText())).start();

    }
}

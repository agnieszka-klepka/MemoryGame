import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    JTextField tf;

    MyFrame(String name){
        this.setTitle(name);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 1200);

        //Creating the MenuBar and adding components
        JMenuBar menuBar = new JMenuBar();

        JMenu menu1 = new JMenu("GAME");
        JMenu menu2 = new JMenu("Help");

        menuBar.add(menu1);
        menuBar.add(menu2);

        JMenuItem menu11 = new JMenuItem("Stop");
        JMenuItem menu22 = new JMenuItem("Reset");
        menu1.add(menu11);
        menu1.add(menu22);

        // Creating the buttons

        JPanel panel2 = new JPanel();

        ImageIcon image1 = new ImageIcon("src/ace_of_cups.png");

        JButton button1 = new JButton(image1);
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");

        button1.setPreferredSize(new Dimension(150, 200));
        button2.setPreferredSize(new Dimension(150, 200));
        button3.setPreferredSize(new Dimension(150, 200));
        button4.setPreferredSize(new Dimension(150, 200));
        button5.setPreferredSize(new Dimension(150, 200));
        button6.setPreferredSize(new Dimension(150, 200));
        button7.setPreferredSize(new Dimension(150, 200));
        button8.setPreferredSize(new Dimension(150, 200));

        panel2.setLayout(new GridLayout(2, 4));

        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);
        panel2.add(button4);
        panel2.add(button5);
        panel2.add(button6);
        panel2.add(button7);
        panel2.add(button8);


        //Creating the panel at bottom and adding components
        JPanel panel1 = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter your name");
        tf = new JTextField(10); // accepts up to 10 characters
        JButton start = new JButton("START");

        start.addActionListener(this);

        panel1.add(label); // Components Added using Flow Layout
        panel1.add(tf);
        panel1.add(start);
        String input = tf.getText();
        System.out.println(input);

        //Adding Components to the frame.
        this.getContentPane().add(BorderLayout.SOUTH, panel1);
        this.getContentPane().add(BorderLayout.CENTER, panel2);
        this.getContentPane().add(BorderLayout.NORTH, menuBar);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Thread thread = new Thread(new GameLogic());
        thread.start();
    }
}

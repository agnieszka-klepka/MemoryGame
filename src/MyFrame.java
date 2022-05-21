import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class MyFrame extends JFrame implements ActionListener {
    JTextField tf;
    JPanel panel2;

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

        // Creating the panel2 to store buttons

        panel2 = new JPanel();

        // Creating fields with images

        ImageIcon image1 = new ImageIcon("src/sun1.jpg");
        ImageIcon image1_1 = new ImageIcon("src/sun2.jpg");
        ImageIcon image2 = new ImageIcon("src/storm1.jpg");
        ImageIcon image2_1 = new ImageIcon("src/storm2.jpg");
        ImageIcon image3 = new ImageIcon("src/nature1.jpg");
        ImageIcon image3_1 = new ImageIcon("src/nature2.jpg");
        ImageIcon image4 = new ImageIcon("src/fire1.jpg");
        ImageIcon image4_1 = new ImageIcon("src/fire2.jpg");

        ArrayList<ImageIcon> images = new ArrayList<>();

        images.add(image1);
        images.add(image1_1);
        images.add(image2);
        images.add(image2_1);
        images.add(image3);
        images.add(image3_1);
        images.add(image4);
        images.add(image4_1);

        // Creating the buttons
        // List with our buttons -- to draw buttons

        JButton[] button = new JButton[8];

        for (int i = 0; i < 8; i++) {

            button[i] = new JButton("");
            button[i].setPreferredSize(new Dimension(150, 200));

        }

        // Randomly saving images to buttons
        
        Random random = new Random();
        for(int i = 0; i < 8; i++) {
            int n = random.nextInt(images.size());
            button[i] = new JButton(images.get(n));
            images.remove(n);
        }

        // The panel2 settings

        panel2.setLayout(new GridLayout(2, 4));

        for(int i = 0; i < 8; i++) {
            panel2.add(button[i]);
        }



        //Creating the panel1 at bottom and adding components
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

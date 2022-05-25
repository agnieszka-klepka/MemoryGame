import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class MyFrame extends JFrame implements ActionListener {

    JTextField tf;
    JTextArea ta;
    JPanel panel2;

    long time = 0;

    ImageIcon startImage;
    ImageIcon image1;
    ImageIcon image1_1;
    ImageIcon image2;
    ImageIcon image2_1;
    ImageIcon image3;
    ImageIcon image3_1;
    ImageIcon image4;
    ImageIcon image4_1;

    ArrayList<ImageIcon> storeImages;


    MyFrame(){
        this.setTitle("Memory Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 1000);
        this.setResizable(false);

        // Creating the panel2 to store buttons
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2, 4));

        randomlyChooseImages();     // tutaj wywoływana jest ta metoda, poniewaz w niej wywolywana jest metoda, ktora dodaje przyciski do panel2 ZAPISZ TO JAKOS PO POLSKU W ANGIELSKIM JEZYKU XD

        //Creating the panel1 at bottom and adding components
        JPanel panel1 = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter your name");
        JLabel timeLabel = new JLabel("Your current time");
        tf = new JTextField(10); // accepts up to 10 characters
        JTextField timeField = new JTextField(20);      // NA PRZYSZLE LICZENIE CZASU
        JButton start = new JButton("START");
        ta = new JTextArea(2, 10);

        start.addActionListener(this);

        panel1.setSize(new Dimension(1200, 100));
        panel1.add(label); // Components Added using Flow Layout
        panel1.add(tf);
        panel1.add(start);
        panel1.add(timeLabel);
        panel1.add(timeField);
        String input = tf.getText();
        System.out.println(input);

        //Adding Components to the frame.
        this.getContentPane().add(BorderLayout.SOUTH, panel1);
        this.getContentPane().add(BorderLayout.CENTER, panel2);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Thread thread = new Thread(new TimeCounter());
        thread.start();
        time = System.currentTimeMillis();

        System.out.println("Hello " + tf.getText());
    }

    public void randomlyChooseImages(){
        // Creating fields with images
        startImage = new ImageIcon("src/memoryGame.jpg");

        image1 = new ImageIcon("src/sun1.jpg");
        image1_1 = new ImageIcon("src/sun2.jpg");
        image2 = new ImageIcon("src/storm1.jpg");
        image2_1 = new ImageIcon("src/storm2.jpg");
        image3 = new ImageIcon("src/nature1.jpg");
        image3_1 = new ImageIcon("src/nature2.jpg");
        image4 = new ImageIcon("src/fire1.jpg");
        image4_1 = new ImageIcon("src/fire2.jpg");

        ArrayList<ImageIcon> images = new ArrayList<>();

        images.add(image1);
        images.add(image1_1);
        images.add(image2);
        images.add(image2_1);
        images.add(image3);
        images.add(image3_1);
        images.add(image4);
        images.add(image4_1);

        // array to store randomly chosen images
        storeImages = new ArrayList<>();

        // Randomly saving images to buttons

        Random random = new Random();
        for(int i = 0; i < 8; i++) {
            int n = random.nextInt(images.size());
            storeImages.add(images.get(n));
            images.remove(n);
        }

        setUpButtons();
    }

    public void setUpButtons(){

        // Creating the buttons
        // List with our buttons -- to draw buttons

        JButton[] button = new JButton[8];

        for (int i = 0; i < 8; i++) {

            button[i] = new JButton(startImage);
            button[i].setPreferredSize(new Dimension(130, 150));

        }

        for(int i = 0; i < 8; i++) {
            panel2.add(button[i]);
        }

        button[0].addActionListener(e -> {
            button[0].setIcon(storeImages.get(0));
            System.out.println("button 1 is pressed");
            System.out.println(storeImages.get(0));
        });
        button[1].addActionListener(e -> {
            button[1].setIcon(storeImages.get(1));
            System.out.println("button 1 is pressed");
        });
        button[2].addActionListener(e -> {
            button[2].setIcon(storeImages.get(2));
            System.out.println("button 1 is pressed");
        });
        button[3].addActionListener(e -> {
            button[3].setIcon(storeImages.get(3));
            System.out.println("button 1 is pressed");
        });
        button[4].addActionListener(e -> {
            button[4].setIcon(storeImages.get(4));
            System.out.println("button 1 is pressed");
        });
        button[5].addActionListener(e -> {
            button[5].setIcon(storeImages.get(5));
            System.out.println("button 1 is pressed");
        });
        button[6].addActionListener(e -> {
            button[6].setIcon(storeImages.get(6));
            System.out.println("button 1 is pressed");
        });
        button[7].addActionListener(e -> {
            button[7].setIcon(storeImages.get(7));
            System.out.println("button 1 is pressed");
        });
    }
}

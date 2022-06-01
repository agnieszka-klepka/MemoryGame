import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

class MyFrame extends JFrame implements ActionListener {

    JTextField tf;
    JTextArea ta;
    JPanel panel2;
    static JButton[] button;
    JButton start;

    // TIME COUNTING
    // long time = 0;

    // IMAGES
    ImageIcon startImage;
    ImageIcon image1;
    ImageIcon image1_1;
    ImageIcon image2;
    ImageIcon image2_1;
    ImageIcon image3;
    ImageIcon image3_1;
    ImageIcon image4;
    ImageIcon image4_1;

    static ArrayList<ImageIcon> storeImages;
    ArrayList<String> orderedImages;

    int firstChosenButton;
    int secondChosenButton;

    Boolean shown = true;
    // Boolean gameWin = false;

    int temp = 0;   // moves counter


    MyFrame(){
        this.setTitle("Memory Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 1000);
        //this.setResizable(false);

        // Creating the panel2 to store buttons
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2, 4));

        randomlyChooseImages();

        //Creating the panel1 at bottom and adding components
        JPanel panel1 = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter your name");
        JLabel timeLabel = new JLabel("Your current time");
        tf = new JTextField(10); // accepts up to 10 characters
        JTextField timeField = new JTextField(20);      // NA PRZYSZLE LICZENIE CZASU
        start = new JButton("START");
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

        //Adding Components to the frame
        this.getContentPane().add(BorderLayout.SOUTH, panel1);
        this.getContentPane().add(BorderLayout.CENTER, panel2);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent click) {
        Object source = click.getSource();

        if(source == start){
            System.out.println("kurwa start wcisniety " + tf.getText());
        }


        /////////////////////////////////////////////////////////////////
        for(int i =0;i<8;i++) {
            if(source == button[i]) {
                if (shown) {
                    if(temp<2){
                        switchSpot(i);
                    } else {
                        hideField();
                    }
                } else {
                    switchSpot(i);
                }
            }
        }
        /////////////////////////////////////////////////////////////////

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
        setUpButtonsEasy();
        compareImages(storeImages);
    }

    public void setUpButtonsEasy(){

        // Creating the buttons
        // List with our buttons -- to draw buttons

        button = new JButton[8];

        for (int i = 0; i < 8; i++) {

            button[i] = new JButton(startImage);
            button[i].setPreferredSize(new Dimension(130, 150));

        }
        for(int i = 0; i < 8; i++) {
            panel2.add(button[i]);
        }
        showImage();
    }

    public void showImage(){
        for(int i = 0;i < 8; i++) {
            button[i].addActionListener(this);
        }
    }
    public void hideField(){
        for(int i=0;i<8;i++){
            button[i].setIcon(startImage);
        }
        temp = 0;
        shown=true;
    }

    public void switchSpot(int i){
        if(shown){
            button[i].setIcon(storeImages.get(i));
            temp++;
            if (temp == 1) firstChosenButton = i;   // pierwszy raz przechodzi petle, jak karta jest wybrana
            if(temp == 2) {
                secondChosenButton = i;             // drugi raz przechodzi petle i zapisuje numerek drugiej karty --> i teraz uważaj
                compareButtons();
            }
        } else {
            button[i].setIcon(startImage);
            shown = true;
        }
    }
    public void compareImages(ArrayList<ImageIcon> storeImages){
        System.out.println(storeImages);

        orderedImages = new ArrayList<>();

        for(int i = 0; i < 8; i++){
            if(storeImages.get(i) == image1){
                orderedImages.add(i, "sun");
            }else if (storeImages.get(i) == image1_1){
                orderedImages.add(i, "sun");
            }
            if(storeImages.get(i) == image2){
                orderedImages.add(i, "storm");
            }else if (storeImages.get(i) == image2_1){
                orderedImages.add(i, "storm");
            }
            if(storeImages.get(i) == image3){
                orderedImages.add(i, "nature");
            }else if (storeImages.get(i) == image3_1){
                orderedImages.add(i, "nature");
            }
            if(storeImages.get(i) == image4){
                orderedImages.add(i, "fire");
            }else if (storeImages.get(i) == image4_1){
                orderedImages.add(i, "fire");
            }
        }
        // System.out.println(orderedImages);  // mamy posegregowane, gdzie mamy jakie symbole --> teraz sobie to mozemy porownac --> na tej tablicy pracowac
    }

    public void compareButtons(){

        // jak porównać obrazki na dwóch buttonach
        // mamy moze trzeba oddzielną funkcje???, ktora bedzie nam parowała te obrazki --> dobrze, zrobiłam to
        // to nie jest w sumie zły plan
        // i tutaj tylko sprawdzamy czy te buttony są w dobrej parze

        // TO DO
        // trzeba jeszcze jakies zmienne, ktore beda oznakować buttony
        // ogolnie teraz dazymy, żeby kod działał
        // ale jestem świadoma, że to nie jest elegancko

        if(Objects.equals(orderedImages.get(firstChosenButton), orderedImages.get(secondChosenButton))){

            button[firstChosenButton].setIcon(storeImages.get(firstChosenButton));  // trzeba by teraz zablokować jakos ten klawisz
            button[secondChosenButton].setIcon(storeImages.get(secondChosenButton));

            // blokujemy wybrane buttony --> JAK TO ZROBIC ŁADNIEJ???
            button[firstChosenButton].setEnabled(false);
            button[secondChosenButton].setEnabled(false);

            // TERAZ TRZEBA JESZCZE SPRAWDZIC ZWYCIESTWO

        }


        // if()
    }
}


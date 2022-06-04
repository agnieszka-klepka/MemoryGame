import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

class Game extends JFrame implements ActionListener, Runnable {

    JPanel panel2;
    JPanel panel1;
    static JButton[] button;

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
    int goodMoves = 0;

    Boolean shown = true;

    int size = 8;
    int temp = 0;   // moves counter

    Game(String name){
        this.setTitle("Memory Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 1000);

        // Creating the panel2 to store buttons
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2, 4));

        randomlyChooseImages();

        //Creating the panel1 at bottom and adding components
        panel1 = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Now " + name + " is playing");

        panel1.setSize(new Dimension(1200, 100));
        panel1.add(label); // Components Added using Flow Layout

        //Adding Components to the frame
        this.getContentPane().add(BorderLayout.SOUTH, panel1);
        this.getContentPane().add(BorderLayout.CENTER, panel2);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent click) {
        Object source = click.getSource();

        /////////////////////////////////////////////////////////////////
        for (int i = 0; i < size;i++) {
            if (source == button[i]) {
                if (shown) {
                    if (temp<2){
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
        for(int i = 0; i < size; i++) {
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

        button = new JButton[size];

        for (int i = 0; i < size; i++) {

            button[i] = new JButton(startImage);
            button[i].setPreferredSize(new Dimension(130, 150));

        }
        for(int i = 0; i < size; i++) {
            panel2.add(button[i]);
        }
        showImage();
    }

    public void showImage(){
        for(int i = 0;i < size; i++) {
            button[i].addActionListener(this);
        }
    }
    public void hideField(){
        for(int i = 0;i < size; i++){
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

        orderedImages = new ArrayList<>();

        for(int i = 0; i < size; i++){
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
    }

    public void compareButtons() {

        if (Objects.equals(orderedImages.get(firstChosenButton), orderedImages.get(secondChosenButton))){

            // blokujemy wybrane buttony --> JAK TO ZROBIC ŁADNIEJ???
            button[firstChosenButton].setEnabled(false);
            button[secondChosenButton].setEnabled(false);

            // TERAZ TRZEBA JESZCZE SPRAWDZIC ZWYCIESTWO !!!!!!!!!!!!
            goodMoves++;
            isWin();
        }

    }

    public void isWin(){
        if(goodMoves == 4){
            JFrame winningFrame = new JFrame("THE END");
            winningFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            winningFrame.setSize(200, 200);

            JLabel winningLabel = new JLabel("Congratulation");
            JPanel winningPanel = new JPanel();

            JButton button = new JButton("PLAY AGAIN");
            button.addActionListener(e -> {
                this.dispose();
                winningFrame.dispose();
                new StartWindow();
            });

            winningPanel.add(winningLabel);
            winningPanel.add(button);

            winningFrame.getContentPane().add(BorderLayout.CENTER, winningPanel);
            winningFrame.setVisible(true);

        }
    }

    @Override
    public void run() {
        System.out.println("MEMORY GAME MI AMIGOS");
    }
}

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        System.out.println("MEMORY GAME MI AMIGOS");

        Thread thread = new Thread(new GameLogic());
        thread.start();
    }
}

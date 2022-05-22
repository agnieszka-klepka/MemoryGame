import javax.swing.*;

public class GameLogic extends JFrame implements Runnable{

    GameLogic(){        // tu bedziemy sobie logike gry rozpisywac i moze tworzyc tez tableLayout?
        System.out.println("is thread working?");

        // Uncover and hide cards


    }

    @Override
    public void run() {
        System.out.println("yes");

    }

    public void run2() {
        System.out.println("run2");
    }



}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLogic extends JFrame implements Runnable{

    GameLogic(){        // tu bedziemy sobie logike gry rozpisywac i moze tworzyc tez tableLayout?
        System.out.println("is thread working?");

    }

    @Override
    public void run() {
        System.out.println("yes");

    }

    public static void run2() {
        System.out.println("run2");
    }

}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLogic extends MyFrame{

    GameLogic(){
        super();

        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moves();
            }
        });
        timer.setRepeats(false); // Only execute once
        timer.start(); // Go go go!

    }

    public void moves(){

        // odkrycie dwoch kart i sprawdzenie,
        // czy obrazek na nich jest taki sam


        // sprawdzanie, czy obrazek na karcie jest sloncem
        if (storeImages.get(1) == image1) {
            System.out.println("pasuje");
        } else {
            System.out.println("nie pasuje");
        }

        //
    }
}

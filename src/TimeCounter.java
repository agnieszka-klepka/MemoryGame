import javax.swing.*;

public class TimeCounter extends JFrame implements Runnable{

    TimeCounter(){
        // Time counter in thread which starts when start button is pressed
        System.out.println("is thread working?");

    }

    @Override
    public void run() {
        System.out.println("yes");

    }
}

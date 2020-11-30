import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MovementControl extends KeyAdapter {

    public static boolean up = false;
    public static boolean down = false;
    public static boolean left = false;
    public static boolean right = true;

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        System.out.println("Key Pressed");

        if(key == KeyEvent.VK_UP && !down) {
            up = true;
            down = false;
            left = false;
            right = false;
        }
        else if(key == KeyEvent.VK_DOWN && !up) {
            up = false;
            down = true;
            left = false;
            right = false;
        }
        else if(key == KeyEvent.VK_LEFT && !right) {
            up = false;
            down = false;
            left = true;
            right = false;
        }
        else if(key == KeyEvent.VK_RIGHT && !left) {
            up = false;
            down = false;
            left = false;
            right = true;
        }

    }

}

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    protected boolean key;
    public boolean up = false;
    public boolean down = false;
    public boolean left = false;
    public boolean right = true;

    @Override
    public void keyTyped(KeyEvent e) {

    }


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

    @Override
    public void keyReleased(KeyEvent e) {

    }

}

import javax.swing.*;

public class GameFrame extends JFrame {

    public static final int WIDTH = 700;
    public static final int HEIGHT = 700;
    GamePlay gamePlay = new GamePlay();

    GameFrame() {
        setFocusable(true);
        addKeyListener(gamePlay.keyManager);
        add(gamePlay.getRenderDriver());
        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

}

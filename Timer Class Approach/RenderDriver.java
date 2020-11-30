import javax.swing.*;
import java.awt.*;

public class RenderDriver extends JPanel {

    public RenderDriver() {
        setPreferredSize(new Dimension(GameFrame.WIDTH,GameFrame.HEIGHT));
        setBackground(Color.darkGray);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        draw(graphics);
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillRect(GamePlay.foodX,GamePlay.foodY,GamePlay.MATRIX_SIZE,GamePlay.MATRIX_SIZE);

        for(int i=0; i<Snake.snakeBody; i++) {
            if(i==0) {
                graphics.setColor(Color.CYAN);
                graphics.fillRect(Snake.SNAKE_X[i], Snake.SNAKE_Y[i], GamePlay.MATRIX_SIZE, GamePlay.MATRIX_SIZE);
            } else {
                graphics.setColor(Color.GREEN);
                graphics.fillRect(Snake.SNAKE_X[i], Snake.SNAKE_Y[i], GamePlay.MATRIX_SIZE, GamePlay.MATRIX_SIZE);
            }
        }
        if(!GamePlay.running) {
            gameOver(graphics);
        }
    }

    public void gameOver(Graphics graphics) {
        String str = "Game Over";
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("TimesRoman",Font.BOLD,100));
        FontMetrics m = getFontMetrics(graphics.getFont());
        graphics.drawString(str,(GameFrame.WIDTH - m.stringWidth(str))/2, (GameFrame.HEIGHT/2));
    }

}

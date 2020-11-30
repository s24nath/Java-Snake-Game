import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GamePlay implements ActionListener {

    public static final int MATRIX_SIZE = 10;
    public static final int MATIRIX_UNITS = GameFrame.HEIGHT * GameFrame.WIDTH / MATRIX_SIZE;

    static int foodX;
    static int foodY;

    public static boolean running = false;
    private Timer timer;
    private Random random;

    static MovementControl keyManager;
    private RenderDriver renderDriver;

    GamePlay() {
        Snake.SNAKE_X[0] = 300;
        Snake.SNAKE_Y[0] = 300;
        renderDriver = new RenderDriver();
        keyManager = new MovementControl();
        random = new Random();
        startGame();
    }

    public void startGame() {
        generateNewApple();
        running = true;
        timer = new Timer(100,this);
        timer.start();
    }

    public void foodEaten() {
        if(Snake.SNAKE_X[0] == foodX && Snake.SNAKE_Y[0] == foodY) {
            Snake.snakeBody++;
            generateNewApple();
        }
    }

    public void collision() {
        for(int i=Snake.snakeBody; i>0; i--) {
            if(Snake.SNAKE_X[0] == Snake.SNAKE_X[i] && Snake.SNAKE_Y[0] == Snake.SNAKE_Y[i]){
                running = false;
            }
        }

        if(Snake.SNAKE_Y[0] > GameFrame.HEIGHT) {
            running = false;
        }
        if(Snake.SNAKE_X[0] > GameFrame.WIDTH) {
            running = false;
        }
        if(Snake.SNAKE_Y[0] < 0) {
            running = false;
        }
        if(Snake.SNAKE_X[0] < 0) {
            running = false;
        }

        if(!running) {
            timer.stop();
            System.out.println("Game Over");
        }
    }

    public void generateNewApple() {
        foodX = random.nextInt((int)(GameFrame.WIDTH)/MATRIX_SIZE)*MATRIX_SIZE;
        foodY = random.nextInt((int)(GameFrame.HEIGHT)/MATRIX_SIZE)*MATRIX_SIZE;
    }

    public RenderDriver getRenderDriver() {
        return renderDriver;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running) {
            Snake.move();
            collision();
            foodEaten();
        }
        renderDriver.repaint();
    }
}

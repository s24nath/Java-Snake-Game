import java.awt.*;

public class Snake {

    Game game;
    int snakeBody;
    private int count = 4624;
    private int x[] = new int[count];
    private int y[] = new int[count];
    boolean bodyCollision = false;
    int foodX;
    int foodY;
    int random;

    public Snake(Game game) {
        this.game = game;
        snakeBody = 3;

        x[0] = 100;
        y[0] = 100;

        /*random = (int)(Math.random() * 50);
        foodX = random * 10;
        foodY = random * 10;

        while(foodX<11 && foodY<11) {
            random = (int)(Math.random() * 50);
            foodX = random * 10;
            foodY = random * 10;
        }*/

        do {
            random = (int)(Math.random() * 50);
            foodX = random * 10;
            foodY = random * 10;
        } while(foodX<11 && foodY<11);

    }

    public void footEaten() {
        if(x[0] == foodX && y[0] == foodY) {

            do {
                random = (int)(Math.random() * 50);
                foodX = random * 10;
                foodY = random * 10;
            } while(foodX<11 && foodY<11);

            snakeBody++;
        }
    }


    public void collision() {
        for(int i=snakeBody; i>0; i--) {
            if(x[0] == x[i] && y[0] == y[i]) {
                bodyCollision = true;
            }
        }

        if(bodyCollision) {
            Game.gameOver = true;
        }

        if(y[0] > 680) {
            Game.gameOver = true;
        }
        if(x[0] > 680) {
            Game.gameOver = true;
        }
        if(y[0] < 10) {
            Game.gameOver = true;
        }
        if(x[0] < 10) {
            Game.gameOver = true;
        }

    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.RED);

        graphics.fillRect(foodX,foodY,10,10);

        for(int i=0; i<snakeBody; i++) {
            if(i==0) {
                graphics.setColor(Color.GREEN);
                graphics.fillRect(x[i], y[i], 10, 10);
            }
            else {
                graphics.setColor(Color.WHITE);
                graphics.fillRect(x[i], y[i], 10, 10);
            }
        }
    }

    public void tick() {
        move();
        collision();
        footEaten();
    }

    public void move() {

        for(int i=snakeBody; i>0; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        if(game.getKeyManager().up) {
            y[0] -=10;
        }

        else if(game.getKeyManager().down) {
            y[0] +=10;
        }

        else if(game.getKeyManager().right) {
            x[0] +=10;
        }

        else if(game.getKeyManager().left) {
            x[0] -=10;
        }
    }

}

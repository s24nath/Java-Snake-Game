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

    public Snake(Game game) {
        this.game = game;
        snakeBody = 3;

        for(int i = 0; i< snakeBody; i++) {
            x[i] = 100 - i*10;
            y[i] = 100 - i*10;
        }

        int random = (int)(Math.random() * 50);
        foodX = random * 10;
        foodY = random * 10;
    }

    public void footEaten() {
        if(x[0] == foodX && y[0] == foodY) {
            snakeBody++;
            int random = (int)(Math.random() * 50);
            foodX = random * 10;
            foodY = random * 10;
        }
    }


    public void collision() {
        for(int i=snakeBody; i>0; i--) {
            if(i>4 && x[0] == x[i] && y[0] == y[i]){
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
        if(y[0] < 1) {
            Game.gameOver = true;
        }
        if(x[0] < 1) {
            Game.gameOver = true;
        }
    }

    public void render(Graphics graphics) {
        collision();
        footEaten();
        graphics.setColor(Color.RED);
        graphics.fillRect(foodX,foodY,10,10);

        for(int i=0; i<snakeBody; i++) {
            graphics.setColor(Color.WHITE);
            graphics.fillRect(x[i],y[i],10,10);
        }
    }

    public void tick() {
        move();
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

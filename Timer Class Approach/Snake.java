public class Snake {

    public static final int SNAKE_X[] = new int[GamePlay.MATIRIX_UNITS];
    public static final int SNAKE_Y[] = new int[GamePlay.MATIRIX_UNITS];
    static int snakeBody = 3;

    public static void move() {
        for(int i=Snake.snakeBody; i>0; i--) {
            Snake.SNAKE_X[i] = Snake.SNAKE_X[i-1];
            Snake.SNAKE_Y[i] = Snake.SNAKE_Y[i-1];
        }

        if(GamePlay.keyManager.up) {
            Snake.SNAKE_Y[0] -=10;
        }

        else if(GamePlay.keyManager.down) {
            Snake.SNAKE_Y[0] +=10;
        }

        else if(GamePlay.keyManager.right) {
            Snake.SNAKE_X[0] +=10;
        }

        else if(GamePlay.keyManager.left) {
            Snake.SNAKE_X[0] -=10;
        }

    }

}

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

    // Display Canvas
    private Display display;
    private int width, height;
    private String title;

    // Thread
    Thread thread;
    private boolean isRunning = false;

    // Graphics
    private BufferStrategy bufferStrategy;
    private Graphics graphics;
    private BufferedImage image;

    // Snake
    Snake snake;

    // Key Manager
    KeyManager keyManager;

    public static boolean gameOver = false;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
    }

    private void initialize() {
        display = new Display(title,width,height);
        display.getFrame().addKeyListener(keyManager);
        snake = new Snake(this);

    }

    private void render() {
        bufferStrategy = display.getCanvas().getBufferStrategy();

        if(bufferStrategy == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        graphics = bufferStrategy.getDrawGraphics();

        // Clear previous Graphics
        graphics.clearRect(0,0,width,height);

        // Rendering Process
        graphics.setColor(Color.white);
        graphics.drawRect(10,10,681,681);
        graphics.setColor(Color.black);
        graphics.fillRect(11,11,680,680);

        if(snake != null) {
            snake.render(graphics);
        }

        bufferStrategy.show();
        graphics.dispose();
    }


    private void tick() {
        if(snake != null) {
            snake.tick();
        }
    }

    public synchronized void start() {
        if(!isRunning) {
            isRunning = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    public synchronized void stop() {
        if(isRunning) {
            isRunning = false;
            try{ thread.join(); }catch(Exception e) {}
        }
    }

    @Override
    public void run() {
        initialize();
        int fps = 10;
        double perTick = 1000000000 / fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long now;

        while (isRunning) {
            now = System.nanoTime();
            delta = delta + (now - lastTime) / perTick;
            lastTime = now;
            if (delta >= 1) {
                if(gameOver) {
                    System.out.println("Game Over");
                    break;
                }
                render();
                tick();           
                delta--;
            }
        }
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }
}

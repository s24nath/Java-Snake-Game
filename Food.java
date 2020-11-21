import java.awt.*;

public class Food {

    static int x, y;

    public Food(Graphics graphics, int x, int y) {
        this.x = x;
        this.y = y;
        graphics.setColor(Color.RED);
        graphics.fillRect(x,y,10,10);
    }

    public void render(Graphics graphics) {
        int random = (int)(Math.random() * 60);
        x = random * 10;
        y = random * 10;
        graphics.setColor(Color.RED);
        graphics.fillRect(x,y,10,10);
    }

    public void tick() {

    }

}

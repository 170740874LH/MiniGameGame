import java.awt.*;

public class square {
    private int x, y, width, height;
    private Color colour;

    public square(int x, int y, int width, int height, Color colour) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.colour = colour;
    }

    public void paint(Graphics g) {
        g.setColor(colour);
        g.fillRect(x, y, width, height);
    }
}
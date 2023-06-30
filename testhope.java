import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class testhope extends JPanel {
    private square cube;

    public testhope() {
        cube = new square(50, 100, 30, 50, Color.BLUE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("working");
        cube.paint(g);
    }
}

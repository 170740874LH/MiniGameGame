import java.awt.*;
import javax.swing.JPanel;

public class joinFourScreen extends JPanel {

    private square[] colloum = new square[8];
    private square[] period = new square[7];
    private Graphics y;
    joinFourScreen() {

        final int colloumCounter = 80;
        final int periodCounter = 90;

        for (int i = 0; i < 8; i++) {
            colloum[i] = new square(colloumCounter*i, 100, 30, periodCounter*6+30, Color.BLUE);
        }
        for (int i = 0; i < period.length; i++) {
            period[i] = new square(0, (periodCounter*i)+100, colloumCounter*7+30, 30, Color.BLUE);
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        System.out.println("working");
        y = g;
        super.paintComponent(g);

    }
    public void repaint() {
        
        for (int i = 0; i < colloum.length; i++) {
            colloum[i].paint(y);
        }
        for (int i = 0; i < period.length; i++) {
            period[i].paint(y);
        }
    }

}
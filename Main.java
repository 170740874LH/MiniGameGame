import javax.swing.*;


public class Main {
    static JFrame frame = new JFrame("mini Games");

    public static void main(String[] args) {
        Mainmenu menu = new Mainmenu(frame);
        //setting up the screen and adding new panels
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(650,500);
        frame.setVisible(true);
        frame.setLayout(null);


        frame.add(menu);
        frame.add(joinFourMain.joinFourGetPanel());
        frame.add(joinFourMain.joinFourGetButtonPanel());

    }
}
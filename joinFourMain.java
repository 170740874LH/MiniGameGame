import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;





public class joinFourMain {
    //setting up varibles
    static JPanel buttonPanel = new JPanel();
    static JPanel JoinFourPannel = new JPanel();

    JButton resetButton;
    JButton one;
    JButton two;
    JButton three;
    JButton four;
    JButton five;
    JButton six;
    JButton seven;
    Timer timer;
    Timer timer2;
    JFrame frame;
    joinFourLogic joinFourCalculations = new joinFourLogic();

    private boolean cooldown = false;
    public int joinFourColoumnNumber = -1;

    public void prepareJoinFourGame(JButton button, JButton button2, JButton resetButton, JButton one, JButton two,
                                    JButton three, JButton four, JButton five, JButton six, JButton seven) {
        //setting up the game - changing from the mainmeunu to the actual game

        button.setVisible(false);
        button2.setVisible(false);
        buttonPanel.setVisible(true);

        this.resetButton = resetButton;
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
        this.five = five;
        this.six = six;
        this.seven = seven;

        one.setVisible(true);
        two.setVisible(true);
        three.setVisible(true);
        four.setVisible(true);
        five.setVisible(true);
        six.setVisible(true);
        seven.setVisible(true);
    }

    int player = 2;

    joinFourMain(JFrame frame) {
        //the constructor makes the panels and is responsible for the main game loop
        JoinFourPannel.setBackground(Color.black);
        JoinFourPannel.setBounds(0,50,650,450);
        JoinFourPannel.setVisible(true);
        JoinFourPannel.setLayout(null);

        buttonPanel.setBackground(Color.green);
        buttonPanel.setBounds(0,0,650,50);
        buttonPanel.setVisible(false);
        buttonPanel.setLayout(null);



        timer = new Timer(1, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            
                if (joinFourColoumnNumber != -1 && cooldown == true) {
                    joinFourCalculations.moveChipToCorrectPosition(joinFourCalculations.board, player,
                            joinFourColoumnNumber);
                    joinFourCalculations.connectFourLogicTempScreen();

                    if (joinFourCalculations.hasPlayerWon(joinFourCalculations.board, player) == true) {
                        timer.stop();
                    }

                    player = joinFourCalculations.changePlayer(player);
                    joinFourColoumnNumber = -1;
                    cooldown = false;
                }


            }
        });
        timer.start();

        //thread used to display everything on the screen - the grid and the circles

        joinFourScreen joinFourImage = new joinFourScreen();
        JoinFourPannel.add(joinFourImage);


        testhope display = new testhope();

        JoinFourPannel.add(display);
        
        timer2 = new Timer(1, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JoinFourPannel.revalidate();

                display.repaint();
                joinFourImage.repaint();
            }
        });
        timer2.start();
    }

    //allows the main to add the panles to the screen
    public static JPanel joinFourGetButtonPanel() {
        return buttonPanel;
    }
    public static JPanel joinFourGetPanel() {
        return JoinFourPannel;
    }
    //stops multiple button presses at once
    public boolean joinFourIsCooldownActive() {
        if (cooldown == true) {
            return true;
        } else {
            return false;
        }
    }

    public void joinFourChangeCooldown() {
        cooldown = true;
    }
}

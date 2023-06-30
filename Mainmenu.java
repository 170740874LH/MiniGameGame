import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mainmenu extends JPanel implements ActionListener {

    private JButton squareGameButton;
    private JButton joinFour;
    private JButton resetButton;
    private JButton coloumn1;
    private JButton coloumn2;
    private JButton coloumn3;
    private JButton coloumn4;
    private JButton coloumn5;
    private JButton coloumn6;
    private JButton coloumn7;
    JFrame frame;
    JPanel buttonPanel;
    joinFourMain joinFourGame;

    Mainmenu (JFrame frame) {
        //this whole thing is just setting up the buttons and other needed functions
        this.buttonPanel = joinFourMain.joinFourGetButtonPanel();
        this.frame = frame;
        setLayout(null);

        squareGameButton = button.setButton(50, 50,200, 50, "squareGame", Color.red, Color.CYAN,true);
        joinFour = button.setButton(300, 200, 200, 50, "game2", Color.red, Color.CYAN,true);
        resetButton = button.setButton(200, 300, 200, 50, "Reset", Color.red, Color.CYAN,false);
        coloumn1 = button.setButton(10, 10, 50, 50, "1", Color.red, Color.CYAN,false);
        coloumn2 = button.setButton(115, 10, 50, 50, "2", Color.red, Color.CYAN,false);
        coloumn3 = button.setButton(220, 10, 50, 50, "3", Color.red, Color.CYAN,false);
        coloumn4 = button.setButton(325, 10, 50, 50, "4", Color.red, Color.CYAN,false);
        coloumn5 = button.setButton(430, 10, 50, 50, "5", Color.red, Color.CYAN,false);
        coloumn6 = button.setButton(535, 10, 50, 50, "6", Color.red, Color.CYAN,false);
        coloumn7 = button.setButton(600, 10, 50, 50, "7", Color.red, Color.CYAN,false);
        

        frame.add(squareGameButton);
        frame.add(joinFour);
        frame.add(resetButton);
        
        buttonPanel.add(coloumn1);
        buttonPanel.add(coloumn2);
        buttonPanel.add(coloumn3);
        buttonPanel.add(coloumn4);
        buttonPanel.add(coloumn5);
        buttonPanel.add(coloumn6);
        buttonPanel.add(coloumn7);
        
        coloumn1.addActionListener(this);
        coloumn2.addActionListener(this);
        coloumn3.addActionListener(this);
        coloumn4.addActionListener(this);
        coloumn5.addActionListener(this);
        coloumn6.addActionListener(this);
        coloumn7.addActionListener(this);

        squareGameButton.addActionListener(this);
        joinFour.addActionListener(this);
        resetButton.addActionListener(this);

    }
    //this waits for a button press and does the needed thing afterwards
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == squareGameButton) {

            squareGameMain squareGame = new squareGameMain(frame); 

            squareGame.prepareSquareGame(squareGameButton,joinFour,resetButton);

        }
        else if (e.getSource() == joinFour) {
            joinFourGame = new joinFourMain(frame);

            joinFourGame.prepareJoinFourGame(squareGameButton,joinFour,resetButton,coloumn1,coloumn2,coloumn3,coloumn4,coloumn5,coloumn6,coloumn7);
        }
        else if (e.getSource() == resetButton) {
            frame.getContentPane().removeAll();
            Mainmenu menu = new Mainmenu(frame);
            frame.add(menu);
            frame.revalidate();
            frame.repaint();
        }
        else if (e.getSource() == coloumn1) {
            if (joinFourGame.joinFourIsCooldownActive() == false) {
                joinFourGame.joinFourColoumnNumber = 0;
                joinFourGame.joinFourChangeCooldown();
            }
        }
        else if (e.getSource() == coloumn2) {
            if (joinFourGame.joinFourIsCooldownActive() == false) {
                joinFourGame.joinFourColoumnNumber = 1;
                joinFourGame.joinFourChangeCooldown();
            }
        }
        else if (e.getSource() == coloumn3) {
            if (joinFourGame.joinFourIsCooldownActive() == false) {
                joinFourGame.joinFourColoumnNumber = 2;
                joinFourGame.joinFourChangeCooldown();
            }
        }
        else if (e.getSource() == coloumn4) {
            if (joinFourGame.joinFourIsCooldownActive() == false) {
                joinFourGame.joinFourColoumnNumber = 3;
                joinFourGame.joinFourChangeCooldown();
            }
        }
        else if (e.getSource() == coloumn5) {
            if (joinFourGame.joinFourIsCooldownActive() == false) {
                joinFourGame.joinFourColoumnNumber = 4;
                joinFourGame.joinFourChangeCooldown();
            }
        }
        else if (e.getSource() == coloumn6) {
            if (joinFourGame.joinFourIsCooldownActive() == false) {
                joinFourGame.joinFourColoumnNumber = 5;
                joinFourGame.joinFourChangeCooldown();
            }
        }
        else if (e.getSource() == coloumn7) {
            if (joinFourGame.joinFourIsCooldownActive() == false) {
                joinFourGame.joinFourColoumnNumber = 6;
                joinFourGame.joinFourChangeCooldown();
            }
        }
        
    }

}

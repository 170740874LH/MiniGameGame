
import javax.swing.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class squareGameMain {
    squareGameLogic squareGame = new squareGameLogic();
    Timer timer;
    JButton resetButton;

    public void prepareSquareGame (JButton button, JButton button2, JButton resetButton) {
        button.setVisible(false);
        button2.setVisible(false);
        this.resetButton = resetButton;

    }
    
    squareGameMain (JFrame frame) {
        frame.add(squareGame);
        
        timer = new Timer(1, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                
                squareGame.repaint();

                try {
                    squareGame.gameLogic();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                if (squareGame.haveYouWon()) {
                    resetButton.setVisible(true);

                    timer.stop();

                    
                } 

            }
        });
            timer.start();

        
    }
}

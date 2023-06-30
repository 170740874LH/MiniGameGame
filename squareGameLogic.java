import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

public class squareGameLogic extends JPanel implements MouseMotionListener{
    enum colours {
        RED,
        GREEN,
        BLUE,
        MAGENTA,
        CYAN,
        YELLOW,
        WHITE,
    }

    static final int windowWidth = 640,windowHeight = 480;
    private final int foodNumber = 5;
    private int score;
    private int health = 640 * 16;
    private boolean finshed,won;
    Random rand = new Random(); 
    private  colours [] enumArray = colours.values();

    private squareGamePlayer player;
    private squareGameHighScores scores = new squareGameHighScores();
    
    private squareGameHealthBar life;
    ArrayList<squareGameFood> Food = new ArrayList<squareGameFood>();

    private int userMouseY,userMouseX;

    public squareGameLogic() {
        life = new squareGameHealthBar(0, 480, 15,Color.RED, health/16);
        player = new squareGamePlayer(200,200,50,1,Color.ORANGE);
        Food = new ArrayList<squareGameFood>();
        for (int index = 0; index < foodNumber; index++) {
            Food.add(new squareGameFood(getRandomNumber(620),getRandomNumber(460),getRandomSelection(3),getRandomSelection(3),(getRandomNumber(4)+3),getColor(getColourType()),15));
        }
        addMouseMotionListener(this);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        life.paint(g);


        paintBackGround(g);
        
        player.paint(g);
        //painting each individual food
        for (int i = 0; i < foodNumber; i++) {
            Food.get(i).paint(g);
        }
        //displaying score at the top of the screen
        g.setColor(Color.WHITE);
        g.drawString("Your score is " + Math.abs(score/100),250,20);

        if (health < 0) {
            gameOverScreen(g);
            finshed = true;
        }

    }
    public void gameLogic () throws IOException{
        System.out.println(health);
        if (health > 0) {
            for (int i = 0; i < foodNumber; i++) {
                Food.get(i).bounceOfEdeges(0,windowHeight,0,windowWidth);
                Food.get(i).movefood();
            }
            player.moveTowards(userMouseX,userMouseY);
            checkCollision();
            addNewfood();
        }  
        lost();
        score++;
        if (health < 0 && finshed) {
            try {
                scores.writeHighScoreToFile(Math.abs(score / 100));
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
            won = true;
        }

    }
    public void paintBackGround(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0, 640, 480);
    }
    public void gameOverScreen(Graphics g) {
            g.setColor(Color.WHITE);
            Font font = new Font("Arial", Font.BOLD, 60);
            g.setFont(font);
            g.drawString("You lost " + "- score = " + Math.abs(score / 100) ,25,240);
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finshed = true;
    }
    public boolean haveYouWon () {
        return won;
    }
    

    public void lost () {
        health -= 1000;
        life.updateHealth(Math.abs(health/16));

    }
    public void addNewfood() {

        if (Food.size() != foodNumber) {
            int number =  foodNumber - Food.size();
            for (int i = 0; i < number; i++) {
                Food.add(new squareGameFood(getRandomNumber(620),getRandomNumber(460),getRandomSelection(getRandomNumber(4)+1),getRandomSelection(getRandomNumber(4)+1),(getRandomNumber(4)+3),getColor(getColourType()),15));
            }
        }
    }
    public void checkCollision() {
        int bottomY = player.getY() + player.findHeight();
        int rightX = player.getX() + player.findHeight();
        int removed = 0;
        for (int i = 0; i < foodNumber - removed; i++) {
            if (Food.get(i).getX() > (player.getX() - Food.get(i).getSize()) && Food.get(i).getX() < rightX) {
                if (Food.get(i).getY() > player.getY() - Food.get(i).getSize() && Food.get(i).getY() < bottomY) {
                    health = health + 100;
                    Food.remove(i);
                    removed++;

                }
            }
        }
    }

    public int getRandomNumber (int limit) {
        int randomNumber = rand.nextInt(limit);
        return randomNumber;
    }
    public int getRandomSelection(int number) {
        int randomNumber = rand.nextInt(2);
        if (randomNumber == 1) {
            number *= -1;
            
        }
        
        return number;
        
    }

    public squareGameLogic.colours getColourType() {
        squareGameLogic.colours colour = enumArray[rand.nextInt(3)];
        return colour;
    }

    private Color getColor(squareGameLogic.colours colourss) {
        switch (colourss) {
            case YELLOW:
                return Color.YELLOW;
            case RED:
                return Color.RED;
            case BLUE:
                return Color.BLUE;
            case MAGENTA:
                return Color.MAGENTA;
            case CYAN:
                return Color.CYAN;
            case GREEN:
                return Color.GREEN;
            case WHITE:
                return Color.WHITE;
            default:
                return Color.BLACK;
        }
    }  
    @Override
    public void mouseDragged(MouseEvent e) {

    }
    @Override
    public void mouseMoved(MouseEvent e) {
        userMouseY = e.getY();
        userMouseX = e.getX();
    }
}

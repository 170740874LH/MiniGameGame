import java.util.Scanner;
import java.io.*;

public class squareGameHighScores {

    static Scanner keyboard = new Scanner(System.in);

    public void writeHighScoreToFile(int score) throws IOException{
        String fileName = "HighScoresSquareGame.txt";

        File writeFile = new File(fileName);

        if(!writeFile.exists()){
            writeFile.createNewFile();
        }

        FileWriter fw = new FileWriter(writeFile.getAbsoluteFile(), true);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(""+ score);
        bw.newLine();


        bw.close();
    }
}


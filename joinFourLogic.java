
public class joinFourLogic {
    static int boardX = 7;
    static int boardY = 6;
    static int currentPlayedX = 0;
    static int currentPlayedY = 0;

    int[][] board = new int[7][6];
    boolean won = false;
    public void connectFourLogicTempScreen() {
    
        // Displaying the board on screen
        for (int i = 0; i < boardY; i++) {
            for (int j = 0; j < boardX; j++) {
                System.out.print(board[j][i] + " ");
            }
            System.out.println("");
        }

        System.out.println("");
    }
    
    public boolean hasPlayerWon(int[][] board, int player) {
        if (checkRow(1, 1, board, player) ||
            checkRow(0, 1, board, player) ||
            checkRow(1, -1, board, player) ||
            checkRow(1, 0, board, player)) {

            return true;
        }
        return false;
    }

    public boolean checkRow(int xShift, int yShift, int[][] board, int player) {
        int counter = 1;
        int newPositionX = currentPlayedX + xShift;
        int newPositionY = currentPlayedY + yShift;
        
        while (counter != 4) {
            if (newPositionX < 0 || newPositionX >= boardX ||
                newPositionY < 0 || newPositionY >= boardY) {
                break;
            }

            if (board[newPositionX][newPositionY] == player) {
                counter++;
            } else {
                break;
            }

            newPositionX += xShift;
            newPositionY += yShift;
        }

        newPositionX = currentPlayedX - xShift;
        newPositionY = currentPlayedY - yShift;

        while (counter != 4) {
            if (newPositionX < 0 || newPositionX >= boardX || newPositionY < 0 || newPositionY >= boardY) {
                break;
            }

            if (board[newPositionX][newPositionY] == player) {
                counter++;
            } 
            else {
                break;
            }

            newPositionX -= xShift;
            newPositionY -= yShift;
        }

        if (counter >= 4) {
            return true;
        }
        else {
            return false;
        }
    }

    public int[][] moveChipToCorrectPosition(int[][] board, int player, int column) {
        int counter = 0;
        currentPlayedX = column;

        while (counter < boardY) {
            if (board[column][counter] != 0) {
                board[column][counter - 1] = player;
                currentPlayedY = counter - 1;
                return board;
            }
            counter++;
        }

        board[column][boardY - 1] = player;
        currentPlayedY = boardY - 1;
        return board;
    }

    

    public int changePlayer(int player) {
        if (player == 2) {
            player = 1;
            return player;
        } else {
            player = 2;
            return player;
        }
    }
}


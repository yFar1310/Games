public class TicTacToeBoard {

    //Attributs
    private String[][] board;
    private int size = 3;
    public Player currentPlayer;
    
    //Constructeur par défaut
    public TicTacToeBoard()
    {
        currentPlayer = new Player("X");
        board = new String[size][size];
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                board[i][j] = " ";
            }
        }
    }

    public void displayBoard()
    {
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                System.out.print(board[i][j]);
                if(j < size-1) System.out.print(" | ");
            }
             System.out.println();
            if(i < size - 1) System.out.print("---------");
            System.out.println();
        }
    }

    public boolean isValidMove(int row, int col)
    {
        return row >= 1 && row <= 3 && col >= 1 && col <= 3 && board[row - 1][col - 1].equals(" ");
    }
    
    public void makeMove(int row, int col)
    {
        board[row - 1][col - 1] = currentPlayer.getSymbol();
    }
    public boolean checkWin() {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(currentPlayer.getSymbol()) &&
                board[i][1].equals(currentPlayer.getSymbol()) &&
                board[i][2].equals(currentPlayer.getSymbol())) {
                return true;
            }

            if (board[0][i].equals(currentPlayer.getSymbol()) &&
                board[1][i].equals(currentPlayer.getSymbol()) &&
                board[2][i].equals(currentPlayer.getSymbol())) {
                return true;
            }
        }

        if (board[0][0].equals(currentPlayer.getSymbol()) &&
            board[1][1].equals(currentPlayer.getSymbol()) &&
            board[2][2].equals(currentPlayer.getSymbol())) {
            return true;
        }

        if (board[0][2].equals(currentPlayer.getSymbol()) &&
            board[1][1].equals(currentPlayer.getSymbol()) &&
            board[2][0].equals(currentPlayer.getSymbol())) {
            return true;
        }

        return false;
    }

    public boolean checkDraw()
    {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;


    }

    }


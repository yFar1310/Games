import java.util.Scanner;

public class main{
 public static void main(String[] args)
  {
        TicTacToeBoard game = new TicTacToeBoard();
        Scanner scanner = new Scanner(System.in);

        while (true) 
        {
            game.displayBoard();
            System.out.println("Player " + game.currentPlayer.getSymbol() + "'s turn (Enter row and column, e.g., 1 2):");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (game.isValidMove(row, col))
            {
                game.makeMove(row, col);
                if (game.checkWin()) 
                {
                    game.displayBoard();
                    System.out.println("Player " + game.currentPlayer.getSymbol() + " wins! Congratulations!");
                    break;
                }
                 else if (game.checkDraw())
                 {
                    game.displayBoard();
                    System.out.println("It's a draw! The game is over.");
                    break;
                }
                game.currentPlayer = (game.currentPlayer.getSymbol().equals("X")) ? new Player("O") : new Player("X");
            }
            else 
            {
                System.out.println("Invalid move. Try again.");
            }
        }

        scanner.close();
    }
 }
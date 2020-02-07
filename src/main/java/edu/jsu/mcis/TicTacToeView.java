package edu.jsu.mcis;

import java.util.Scanner;

public class TicTacToeView {
    
    private final Scanner keyboard;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView() {
        
        /* Initialize scanner (for console keyboard) */
        
        keyboard = new Scanner(System.in);
        
    }
	
    public TicTacToeMove getNextMove(boolean isXTurn) {
        
        /* Prompt the player to enter the row and the column of their next move.
           Return as a TicTacToeMove object. */
        
        // INSERT YOUR CODE HERE
        if (isXTurn == false)
        {
            System.out.println("\nPlayer 2 (O) Move:");
        }
        else
        {
            System.out.println("\nPlayer 1 (X) Move:");
        }
        
        System.out.print("Enter the row and column numbers, separated by a space: ");
        
        String input = keyboard.nextLine();
        System.out.println("");
        String[] inputArray = input.split(" ");
        
        int row;
        int col;
        
        try
        {
            row = Integer.parseInt(inputArray[0]);
            col = Integer.parseInt(inputArray[1]);
        }
        catch(Exception e)
        {
            row = -1;
            col = -1;
        }
        
        TicTacToeMove move = new TicTacToeMove(row, col);

        return move;

    }

    public void showInputError() {

        System.out.println("Entered location is invalid, already marked, or out of bounds.");

    }

    public void showResult(String r) {

        System.out.println(r + "!");

    }
    
    public void showBoard(String board) {
        
        System.out.println("\n\n" + board);
        
    }
	
}

package edu.jsu.mcis;

public class TicTacToeModel {
    
    private Mark[][] board; /* Game board */
    private boolean xTurn;  /* True if X is current player */
    private int width;      /* Size of game board */
    
    /* ENUM TYPE DEFINITIONS */
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a TIE,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("TIE"), 
        NONE("NONE");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        this(TicTacToe.DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create board (width x width) as a 2D Mark array */
        
        board = new Mark[width][width];

        /* Initialize board by filling every square with empty marks */
        
        // INSERT YOUR CODE HERE
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < width; j++)
            {
                board[i][j] = Mark.EMPTY;
            }
        }
        
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Use "isValidSquare()" to check if the specified location is in range,
           and use "isSquareMarked()" to see if the square is empty!  If the
           specified location is valid, make a mark for the current player, then
           toggle "xTurn" from true to false (or vice-versa) to switch to the
           other player before returning TRUE.  Otherwise, return FALSE. */
        
        // INSERT YOUR CODE HERE
        boolean markCheck = false;
        
        if ((isSquareMarked(row, col) == false) && (isValidSquare(row, col) == true))
        {
            if (xTurn)
            {
                board[row][col] = Mark.X;
                xTurn = !xTurn;
                markCheck = true;
            }
            
            else
            {
                board[row][col] = Mark.O;
                xTurn = !xTurn;
                markCheck = true;
            }
        }
        
        else
        {
            markCheck = false;
        }
        
        return markCheck;
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return TRUE if the specified location is within the bounds of the board */
        
        // INSERT YOUR CODE HERE
        if ((row >= 0) && (row < width) && (col >= 0) && (col < width))
        {
            return true;
        }
        
        else
        {
            return false;
        }
        
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return TRUE if the square at specified location is marked */
        
        // INSERT YOUR CODE HERE
        if ((board[row][col] == Mark.X) || (board[row][col] == Mark.O))
            {
                return true;
            }
                
            else
            {
                return false;
            }
            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return the mark from the square at the specified location */
        
        // INSERT YOUR CODE HERE
        if (isValidSquare(row, col)) {
        
            return board[row][col];
            
        }
        
        else {
            
            System.err.println("Invalid Square!");
            return null;
        }
            
    }
	
    public Result getResult() {
        
        /* Call "isMarkWin()" to see if X or O is the winner, if the game is a
           TIE, or if the game is not over.  Return the corresponding Result
           value */
        
        // INSERT YOUR CODE HERE
        if ((isTie() == true) && (!isMarkWin(Mark.X)) && (!isMarkWin(Mark.O)))
        {
            return Result.TIE;
        }
        
        else if (isMarkWin(Mark.X) == true)
        {
            return Result.X;
        }
        
        else if (isMarkWin(Mark.O) == true)
        {
            return Result.O;
        }
        
        else
        {
            return Result.NONE;
        }
        
    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        // INSERT YOUR CODE HERE
        boolean horiWinCheck = false;
        boolean vertWinCheck = false;
        boolean diagWinCheckA = false;
        boolean diagWinCheckB = false;
        
        boolean winCheck;
        
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < width; j++)
            {
                // Horizontal Test //
                if (board[i][0] == mark)
                {
                    horiWinCheck = true;
                    
                    for (int k = 0; k < width; k++)
                    {
                        if (board [i][k] != mark)
                        {
                            horiWinCheck = false;
                            break;
                        }
                    }
                }

                // Vertical Test //
                else if (board[0][j] == mark)
                {
                    vertWinCheck = true;
                    
                    for (int k = 0; k < width; k++)
                    {
                        if (board[k][j] != mark)
                        {
                            vertWinCheck = false;
                            break;
                        }
                    }
                }
                
                // Diagonal Test #1 (left to right)
                else if (board[0][0] == mark)
                {
                    diagWinCheckA = true;
                    
                    for (int k = 0; k < width; k++)
                    {
                        if (board[k][k] != mark)
                        {
                            diagWinCheckA = false;
                            break;
                        }
                    }
                }
                
                // Diagonal Test #2 (right to left)
                else if (board[0][(width - 1)] == mark)
                {
                    diagWinCheckB = true;
                    
                    for (int k = 0; k < width; k++)
                    {
                        if (board[k][width - (1 + k)] != mark)
                        {
                            diagWinCheckB = false;
                            break;
                        }
                    }
                }
            }
        }
        
        winCheck = horiWinCheck || vertWinCheck || diagWinCheckA || diagWinCheckB;
        
        return winCheck;

    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */
        
        // INSERT YOUR CODE HERE
        boolean tieCheck = true;
        
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < width; j++)
            {
                if (!isSquareMarked(i, j))
                {
                    tieCheck = false;
                }
            }
        }
        
        return tieCheck;
        
    }

    public boolean isGameover() {
        
        /* Return TRUE if the game is over */
        
        return (Result.NONE != getResult());
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
    @Override
    public String toString() {
        
        StringBuilder output = new StringBuilder("  ");
        
        /* Output the board contents as a string (see examples) */
        
        // INSERT YOUR CODE HERE
        for (int i = 0; i < width; ++i)
        {
            output.append(i);
        }
        
        for (int i = 0; i < width; ++i)
        {
            output.append("\n").append(i).append(" ");
            
            for (int j = 0; j < width; ++j)
            {
                output.append(board[i][j].toString());
            }
            
        }
        
        output.append("\n");
        return output.toString();
        
    }
    
}

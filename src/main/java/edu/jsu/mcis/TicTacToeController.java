package edu.jsu.mcis;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;

public class TicTacToeController implements ActionListener {

    private final TicTacToeModel model;
    private final TicTacToeView view;
    
    /* CONSTRUCTOR */

    public TicTacToeController(int width) {
        
        /* Initialize model, view, and width */

        model = new TicTacToeModel(width);
        view = new TicTacToeView(this, width);
        
    }
    
    public String getMarkAsString(int row, int col) {       
        return (model.getMark(row, col).toString());       
    }
   
    public TicTacToeView getView() {       
        return view;       
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        // INSERT YOUR CODE HERE
        String name = ((JButton) event.getSource()).getName();
        
        ArrayList<String> nameArray = new ArrayList(Arrays.asList(name.split("")));
        
        int nameRow = Integer.parseInt(nameArray.get(6));
        int nameCol = Integer.parseInt(nameArray.get(7));
        
        model.makeMark(nameRow, nameCol);
        
        view.updateSquares();
        
        TicTacToeModel.Result result = model.getResult();
        
        if (result != TicTacToeModel.Result.NONE)
        {
            view.disableSquares();
            view.showResult(result.toString());
        }
        
        else
        { 
            view.clearResult();  
        }
    }
}

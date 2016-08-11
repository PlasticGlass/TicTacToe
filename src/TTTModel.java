/**TicTacToeModel Class
 * Class used to process data for TicTacToe game
 * @author Zubair Waheed
 * @since 08/06/2016
 * @version 0.1
 */
public class TTTModel {
    public int[][] board; //2d array representing tictactoe board
    int winner;
    private TTTGUI gui;  //GUI using this model
    private boolean turn;//Current turn (true = player 1 -- false = player 2)

    /**Constructor*/
    public TTTModel()
    {
        board = new int[3][3]; //Board is 3 rows by 3 coloumns
        turn = true; //Model starts on turn 1 by default
    }

    /**Checks if game has been won
     * @return boolean - if game has been won
     */
    public boolean checkWin()
    {
        //Check rows
        for(int row = 0; row < board.length; row++)
        {
            if(board[row][0] == board[row][1] && board[row][0] == board[row][2]) { //Check if row values all the same
                if(board[row][0] != 0)
                    return true;
            }
        }

        //Check Diagonals
        if(board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            if(board[0][0] != 0)
                return true;
        }

        if(board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            if(board[0][2] != 0)
                return true;
        }

        //Check coloumns
        for(int c = 0;c < board[0].length;c++) {
            if (board[0][c] == board[1][c] && board[0][c] == board[2][c]) { //Check if row values all the same
                if (board[0][c] != 0)
                    return true;
            }
        }

        return false;
    }

    /**Converts int state to string equivalent
     * @param state the player who had played/caused this method to be called
     * @return string equivalent of int value (X or O)
     */
    public String convertState(int state)
    {
        switch(state)
        {
            case 1:
                return "X";
            case 2:
                return "O";
            default:
                return "--";
        }
    }

    /**Returns player whose turn it currently is
     * @return which players turn it is
     */
    public int getTurn()
    {
        if(turn)
            return 1;
        else
            return 2;
    }

    /**Processes a player's button press
     * @param button int representing which button was pressed
     */
    public void buttonPressed(int button)
    {
        button -= 1;//Array index holding button has an int value 1 less than the int value of the button, ie button 9 has index 8 in array

        int row = button/3;
        int coloumn = button%3;
        int turnn; //int representing player whose turn it was when button was pressed

        //Check if button press was legal, if it was, process it and display results
        if(legalMove(row, coloumn))
        {
            turnn = getTurn();
            switch(turnn)
            {
                case 1:
                    this.board[row][coloumn] = 1;
                    break;
                case 2:
                    this.board[row][coloumn] = 2;
                    break;
            }

            //Player successfully made move, next players turn now
            this.nextTurn();
        }
        gui.update();
    }

    /**Checks if button clicked can have a move made on it (is free/not occupied by X or O already)
     * @param row row the pressed button was in
     * @param coloumn coloumn the pressed button was in
     * @return whether the made move was legal
     */
    private boolean legalMove(int row, int coloumn)
    {
        return(this.board[row][coloumn] == 0);
    }

    /**Cycle to next players turn*/
    private void nextTurn()
    {
        turn = !turn;
    }

    /**Connects this model to gui using it
     * @param gui the GUI using this model to process data
     */
    public void setGUI(TTTGUI gui)
    {
        this.gui = gui;
    }
}

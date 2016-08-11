import javax.swing.*;
import java.awt.*;

/**
 * Created by Zubair Waheed on 8/6/2016.
 */
public class TTTGUI extends JPanel {

    private JPanel top;
    private JPanel mid;
    private JPanel bottom;
    private JPanel contentPane;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JButton b6;
    private JButton b7;
    private JButton b8;
    private JButton b9;
    private JButton[] buttons;
    private TTTModel model;
    private JLabel turn;
    private JLabel msg;


    public TTTGUI(TTTModel model)
    {
        this.model = model;
        this.initialize();
        this.registerControllers();
        this.model.setGUI(this);
        this.update();
    }


    private void initialize()
    {
        contentPane = new JPanel(new GridLayout(5, 1)); //4 Rows 1 coloumn
        top = new JPanel(new GridLayout(1,3));
        mid = new JPanel(new GridLayout(1,3));
        bottom = new JPanel(new GridLayout(1,3));

        turn = new JLabel();
        msg = new JLabel();

        b1 = new JButton();
        b1.setPreferredSize(new Dimension(100,100)); //Set size of 1, grid layout adjusts to make all others the same size
        b1.setActionCommand("b1");
        b2 = new JButton();
        b2.setActionCommand("b2");
        b3 = new JButton();
        b3.setActionCommand("b3");
        b4 = new JButton();
        b4.setActionCommand("b4");
        b5 = new JButton();
        b5.setActionCommand("b5");
        b6 = new JButton();
        b6.setActionCommand("b6");
        b7 = new JButton();
        b7.setActionCommand("b7");
        b8 = new JButton();
        b8.setActionCommand("b8");
        b9 = new JButton();
        b9.setActionCommand("b9");

        buttons = new JButton[]{b1,b2,b3,b4,b5,b6,b7,b8,b9};

        top.add(buttons[0]);
        top.add(buttons[1]);
        top.add(buttons[2]);

        mid.add(buttons[3]);
        mid.add(buttons[4]);
        mid.add(buttons[5]);

        bottom.add(buttons[6]);
        bottom.add(buttons[7]);
        bottom.add(buttons[8]);

        contentPane.add(top);
        contentPane.add(mid);
        contentPane.add(bottom);
        contentPane.add(turn);
        contentPane.add(msg);

        this.add(contentPane);
    }

    private void registerControllers()
    {
        ButtonController b01 = new ButtonController(this.model);
        b1.addActionListener(b01);
        ButtonController b02 = new ButtonController(this.model);
        b2.addActionListener(b02);
        ButtonController b03 = new ButtonController(this.model);
        b3.addActionListener(b03);
        ButtonController b04 = new ButtonController(this.model);
        b4.addActionListener(b04);
        ButtonController b05 = new ButtonController(this.model);
        b5.addActionListener(b05);
        ButtonController b06 = new ButtonController(this.model);
        b6.addActionListener(b06);
        ButtonController b07 = new ButtonController(this.model);
        b7.addActionListener(b07);
        ButtonController b08 = new ButtonController(this.model);
        b8.addActionListener(b08);
        ButtonController b09 = new ButtonController(this.model);
        b9.addActionListener(b09);
    }

    public void update()
    {
        int state;
        for(int row = 0;row < model.board.length;row++)
        {
            for(int c = 0;c < model.board[row].length;c++)
            {
                state = model.board[row][c];
                buttons[(row*3)+c].setText(model.convertState(state)); //Update Text on button to acknowledge press by a player
            }
        }

        turn.setText("Player " + this.model.getTurn() + "'s turn.");

        if(model.checkWin() == true) {
            int winningTurn = model.getTurn();

            if(winningTurn == 1)
                winningTurn = 2;
            else
                winningTurn =1;

            msg.setText("Player " + winningTurn+ " wins!");//-1 because button press automatically cycles to next player
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
        }
        else
            msg.setText("Game in progress");

    }
}



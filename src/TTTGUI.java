import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.GridLayout;
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
    private JButton reset;
    private JButton[] buttons;
    private TTTModel model;
    private JLabel turn;
    private JLabel msg;
    private JPanel info;


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
        contentPane = new JPanel(new GridLayout(4, 1)); //4 Rows 1 coloumn
        top = new JPanel(new GridLayout(1,3));
        mid = new JPanel(new GridLayout(1,3));
        bottom = new JPanel(new GridLayout(1,3));
        info = new JPanel(new GridLayout(2,2));
        turn = new JLabel();
        msg = new JLabel();
        reset = new JButton("Reset Board");
        buttons = new JButton[9];

        turn.setBorder(BorderFactory.createLoweredBevelBorder());
        msg.setBorder(BorderFactory.createLoweredBevelBorder());

        //Initialize buttons
        for(int i = 0;i<buttons.length;i++)
        {
            buttons[i] = new JButton();
            buttons[i].setActionCommand("b" + (i+1));
            buttons[i].setBackground(Color.white);
            buttons[i].setBorder(BorderFactory.createLoweredBevelBorder());
        }

        top.add(buttons[0]);
        top.add(buttons[1]);
        top.add(buttons[2]);

        mid.add(buttons[3]);
        mid.add(buttons[4]);
        mid.add(buttons[5]);

        bottom.add(buttons[6]);
        bottom.add(buttons[7]);
        bottom.add(buttons[8]);

        info.add(turn);
        info.add(reset);
        info.add(msg);

        contentPane.add(top);
        contentPane.add(mid);
        contentPane.add(bottom);
        contentPane.add(info);

        this.add(contentPane);
    }

    private void registerControllers()
    {
        ButtonController b01 = new ButtonController(this.model);
        buttons[0].addActionListener(b01);
        ButtonController b02 = new ButtonController(this.model);
        buttons[1].addActionListener(b02);
        ButtonController b03 = new ButtonController(this.model);
        buttons[2].addActionListener(b03);
        ButtonController b04 = new ButtonController(this.model);
        buttons[3].addActionListener(b04);
        ButtonController b05 = new ButtonController(this.model);
        buttons[4].addActionListener(b05);
        ButtonController b06 = new ButtonController(this.model);
        buttons[5].addActionListener(b06);
        ButtonController b07 = new ButtonController(this.model);
        buttons[6].addActionListener(b07);
        ButtonController b08 = new ButtonController(this.model);
        buttons[7].addActionListener(b08);
        ButtonController b09 = new ButtonController(this.model);
        buttons[8].addActionListener(b09);

        ResetController rc = new ResetController(this.model);
        reset.addActionListener(rc);
    }

    public void update()
    {
        int state;
        for(int row = 0;row < model.board.length;row++)
        {
            for(int c = 0;c < model.board[row].length;c++)
            {
                state = model.board[row][c];
                buttons[(row*3)+c].setIcon(model.convertState(state)); //Update Text on button to acknowledge press by a player
            }
        }

        turn.setText("Player " + this.model.getTurn() + "'s turn.");

        if(model.checkWin() == true) {
            int winningTurn = model.getTurn();

            if(winningTurn == 1)
                winningTurn = 2;
            else
                winningTurn =1;
            turn.setText("");
            msg.setText("Player " + winningTurn+ " wins!");
        }

        else if(model.checkDraw())
        {
            turn.setText("");
            msg.setText("Its a draw!");
        }

        else
            msg.setText("Game in progress");

        //If win or draw, disable all buttons
        if(model.checkWin() || model.checkDraw())
        {
            for(int i = 0;i<buttons.length;i++)
            {
                buttons[i].setEnabled(false);
            }
        }

        if(this.model.reset == true)
        {
            this.model.resetOccured();

            for(int i = 0;i<buttons.length;i++)
            {
                buttons[i].setEnabled(true);
            }
        }
    }
}



import javax.swing.*;
import java.awt.*;

/**
 * Created by Zubair Waheed on 8/6/2016.
 *
 */
public class TTT {
    public static void main(String[] args) {
        try
        {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

        } catch (Exception e) {}
        TTTModel model = new TTTModel();
        TTTGUI gui = new TTTGUI(model);

        JFrame frame = new JFrame("TicTacToe");
        frame.setContentPane(gui);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);


    }
}

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Zubair Waheed on 8/11/2016.
 */
public class ResetController implements ActionListener {
    private TTTModel model; //Model to give data to

    /**Constructor
     * @param model Exact model connected to this controller
     */
    public ResetController(TTTModel model)
    {
        this.model = model;
    }

    /**Called on button press. Takes input from button press and gives to model.
     * @param e ActionEvent caused by button press
     */
    public void actionPerformed(ActionEvent e)
    {
        this.model.resetConfirm(); //Give model int value of button which was pressed
    }
}

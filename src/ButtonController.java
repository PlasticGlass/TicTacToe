import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**ButtonController Class
 * Handles input from buttons in GUI.
 * @author Zubair Waheed
 * @since 08/07/2016
 * @version 1.0
 */
public class ButtonController implements ActionListener {
    private TTTModel model; //Model to give data to
    private int button;     //Int represention/value of pressed button
    private JButton pressed;//Actual button which was pressed


    /**Constructor
     * @param model Exact model connected to this controller
     */
    public ButtonController(TTTModel model)
    {
        this.model = model;
    }


    /**Called on button press. Takes input from button press and gives to model.
     * @param e ActionEvent caused by button press
     */
    public void actionPerformed(ActionEvent e)
    {
        pressed = (JButton) e.getSource(); //Get object which made ActionEvent, convert it to JButton
        button = Integer.parseInt(pressed.getActionCommand().substring(1)); //only want last letter(number representing button pressed)
        this.model.buttonPressed(button); //Give model int value of button which was pressed
    }
}

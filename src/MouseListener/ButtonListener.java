package MouseListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.interfaces.*;
public class ButtonListener implements ActionListener {

	IEventCallback Command;
    public ButtonListener(IEventCallback Command) {
        this.Command = Command;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Command.run();
    }
}


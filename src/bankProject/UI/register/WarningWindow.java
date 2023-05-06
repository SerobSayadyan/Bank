package bankProject.UI.register;

import javax.swing.*;
import java.awt.*;

public class WarningWindow {

    JFrame frame;

    final int frameWidth = 390;

    final int frameHeight = 200;

    public WarningWindow(String message) {
        createFrame();
        addMessage(message);
        addOKButton();

    }

    private void createFrame() {
        frame = new JFrame();
        frame.setSize(frameWidth, frameHeight);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //place the frame in center of screen
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int screenHeight = toolkit.getScreenSize().height;
        int screenWidth = toolkit.getScreenSize().width;
        frame.setLocation((screenWidth / 2) - (frameWidth / 2), (screenHeight / 2) - (frameHeight / 2));

    }

    private void addMessage(String message) {
        int x = 20;
        int y = (frameHeight / 7);
        int width = 400;
        int height = 50;

        Icon icon = UIManager.getIcon("OptionPane.warningIcon");
        JLabel label = new JLabel(message,icon,SwingConstants.LEFT);
        label.setBounds(x,y,width,height);

        frame.add(label);

    }

    private void addOKButton() {
        int width = 60;
        int height = 30;
        int y = frameHeight - (int)(height * 3.5);
        int x = (frameWidth / 2) - (width / 2);

        JButton button = new JButton("OK");
        button.setBounds(x,y,width,height);
        button.addActionListener(e -> frame.setVisible(false));

        frame.add(button);
    }

}

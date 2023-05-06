package bankProject.UI.login;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class LegalPersonLogin {

    private JFrame frame;

    /**
     * Frame dimensions
     */
    private final int frameWidth = 400;
    //Frame width
    private int frameHeight = 400;
    //Frame Height (is dynamic and will be enlarged according to count of labels and text fields)

    /**
     * 'labelNames' is an array of Label names, which will be inserted in frame
     *      - to add Label and TextField to the frame, just simply add name to this array
     */
    private static final String[] labelNames = {"Անուն","ՀՎՀՀ","Հաճախորդի կոդ"};

    private final HashMap<String, JTextField> hashMapOfFields;


    /**
     * Coordinates for Labels and Text Fields
     */
    private static final int X_FOR_LABEL = 30;
    //X coordinate for Labels

    private final int X_ForField = 150;
    //X coordinate for Text Fields

    private int y_Coordinate = 60;
    //Y coordinate for Labels and Text Fields

    private static final int Width = 160;
    //width of labels and text fields
    private static final int Height = 30;
    //height of labels and text fields

    public LegalPersonLogin() {
        //Creating frame
        createFrame();

        hashMapOfFields = new HashMap<>();

        //Creating and placing Labels and Text fields
        addLabelAndField();

        enterButton();
    }

    private void createFrame() {
        frame = new JFrame("Իրավաբանական անձ");
        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //place the frame in center of screen
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int screenHeight = toolkit.getScreenSize().height;
        int screenWidth = toolkit.getScreenSize().width;
        frame.setLocation((screenWidth / 2) - (frameWidth / 2), (screenHeight / 2) - (frameHeight / 2));

        frame.setVisible(true);
        frame.setLayout(null);
    }

    private void addLabelAndField() {
        //Creating and placing Labels and Text fields
        for (var str : labelNames) {
            if (y_Coordinate >= 260){
                frameHeight += 60;
                frame.setSize(frameWidth, frameHeight);
            }

            JLabel label = new JLabel(str);
            label.setBounds(X_FOR_LABEL, y_Coordinate, Width, Height);
            frame.add(label);

            JTextField textField = new JTextField();
            textField.setBounds(X_ForField, y_Coordinate, Width, Height);
            frame.add(textField);

            hashMapOfFields.put(str, textField);

            y_Coordinate += 40;
        }
    }

    private void enterButton() {
        JButton button = new JButton("Որոնել");
        button.setBounds(X_ForField, y_Coordinate, 100, 30);
        frame.add(button);

        button.addActionListener(e -> print());
    }

    public void print() {
        for (var str : labelNames) {
        System.out.println(hashMapOfFields.get(str).getText());
    }
    }
}

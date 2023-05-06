package bankProject.UI.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class IndividualLogin {

    private JFrame frame;

    /**
     * Frame dimensions
     */
    private static final int frameWidth = 400;
    //Frame width
    private static int frameHeight = 400;
    //Frame Height (is dynamic and will be enlarged according to count of labels and text fields)

    /**
     * 'labelNames' is an array of Label names, which will be inserted in frame
     *      - to add Label and TextField to the frame, just simply add name to this array
     */
    private final String[] labelNames = {"Անուն","Ազգանուն","Անձնագիր","Հաճախորդի կոդ"};

    private final HashMap<String, JTextField> hashMapOfFields;

    /**
     * Coordinates for Labels and Text Fields
     */
    private static final int X_FOR_LABEL = 30;
    //X coordinate for Labels

    private static final int X_FOR_FIELD = 150;
    //X coordinate for Text Fields

    private int y_Coordinate = 60;
    //Y coordinate for Labels and Text Fields

    private static final int Width = 160;
    //width of labels and text fields
    private static final int Height = 30;
    //height of labels and text fields

    public IndividualLogin() {
        //Creating frame
        createFrame();

        //Mapping of text fields by labelNames
        hashMapOfFields = new HashMap<>();

        //Add Labels and Text Fields
        addLabelAndField();


        //Add gender radio button
//        addGenderRadioButtons();

        //Add "Enter" button to frame
        enterButton();
    }

    private void createFrame() {

        frame = new JFrame("Ֆիզիկական անձ");
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
            textField.setBounds(X_FOR_FIELD, y_Coordinate, Width, Height);
            frame.add(textField);

            y_Coordinate += 40;

            hashMapOfFields.put(str, textField);

        }
    }

    private void enterButton() {
        JButton button = new JButton("Որոնել");
        button.setBounds(X_FOR_FIELD, y_Coordinate, 100, 30);
        frame.add(button);
        y_Coordinate += 40;

        //"Enter" press
        button.addActionListener(e -> print());
    }

    public void print() {
        for (var str : labelNames) {
            System.out.println(hashMapOfFields.get(str).getText());
        }
    }


    private void addGenderRadioButtons() {
        int x = 0; // for x offset correction
        int y = 0; // for y offset correction

        JLabel gender = new JLabel("Սեռ");
        gender.setBounds(X_FOR_LABEL, (y_Coordinate + y + 10), Width, Height);
        frame.add(gender);

        JRadioButton maleButton = new JRadioButton("Արական");
        maleButton.setMnemonic(KeyEvent.VK_A);
        maleButton.setBounds((X_FOR_FIELD + x), (y_Coordinate + y), (Width - 60), (Height - 10));
        frame.add(maleButton);

        JRadioButton femaleButton = new JRadioButton("Իգական");
        femaleButton.setMnemonic(KeyEvent.VK_B);
        femaleButton.setBounds((X_FOR_FIELD + x), (y_Coordinate + y + 20), (Width - 60), (Height - 10));
        frame.add(femaleButton);

        JRadioButton otherButton = new JRadioButton("Այլ");
        otherButton.setMnemonic(KeyEvent.VK_C);
        otherButton.setBounds((X_FOR_FIELD + x), (y_Coordinate + y + 40), (Width - 60), (Height - 10));
        frame.add(otherButton);

        ButtonGroup group = new ButtonGroup();
        group.add(maleButton);
        group.add(femaleButton);
        group.add(otherButton);

        y_Coordinate += 80;
    }

}

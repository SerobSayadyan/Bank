package bankProject.UI.register;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;

/**
 * @author Serob Sayadyan
 */
public class LegalPersonRegistration {
    private JFrame frame;

    /**
     * Frame dimensions
     */
    private static final int frameWidth = 1080;
    //Frame width
    private static int frameHeight = 450;
    //Frame Height (is dynamic and will be enlarged according to count of labels and text fields)

    /**
     *  are array of Label names, which will be inserted in frame
     *      <p>- to add Label and TextField to the frame, just simply add name to this array</p>
     */
    private final String[] labelName = {"Անուն*"};

    private final String[] labelDirector = {"Տնօրեն*","ID*","Անուն*","Ազգանուն*"};

    private final String[] labelPassportAndDate = {"Անձնագիր*","Սկիզբ*","Վերջ*"};

    private final String[] labelAddress = {"Հասցե*"};

    private final String[] labelEmailNumber = {"Էլ․ հասցե*", "Հեռախոս*", "ՀՎՀՀ"};

    private final HashMap<String, JTextField> hashMapOfFields;

    /**
     * Coordinates for Labels and Text Fields
     */
    private static final int X_FOR_LABEL = 30;
    //X coordinate for Labels

    private static final int X_FOR_FIELD = 120;
    //X coordinate for Text Fields

    private int y_Coordinate = 60;
    //Y coordinate for Labels and Text Fields

    private static final int Width = 160;
    //width of labels and text fields
    private static final int Height = 30;
    //height of labels and text fields

    public LegalPersonRegistration() {
        createFrame();

        hashMapOfFields = new HashMap<>();

        addLabelAndField(labelName);
        addLabelAndField(labelDirector);
        addLabelAndField(labelPassportAndDate);
        addLabelAndField(labelAddress);
        addLabelAndField(labelEmailNumber);
        addNotePad();
        addRegisterButton();

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

    /**
     * @param labelNames
     */
    private void addLabelAndField(String[] labelNames) {
        //Creating and placing Labels and Text fields
        int addLabel_x = -5;

        int addField_x = 0;

        int labelWidth = -50;

        int frameWidthChange = 0;

        for (var str : labelNames) {

            if (y_Coordinate >= 260) {
                frameHeight += 30;
                frame.setSize(frameWidth, frameHeight);
            }
            int len = labelNames.length;

            if (len > 4) {
                for (int i = 0; i < (len - 3); i++) {
                    frameWidthChange += 40;
                }
                frame.setSize(frameWidth + frameWidthChange, frameHeight);
            }
            JLabel label = new JLabel(str);
            label.setBounds(X_FOR_LABEL + addLabel_x, y_Coordinate, Width + labelWidth, Height);
            frame.add(label);


            JTextField textField = new JTextField(str);
            textField.setBounds(X_FOR_FIELD + addField_x, y_Coordinate, Width, Height);
            textField.setForeground(Color.GRAY);
            frame.add(textField);


            //Ghost text
            textField.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (textField.getForeground().equals(Color.GRAY) || textField.getText().equals("")) {
                        textField.setText("");
                        textField.setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (textField.getForeground().equals(Color.GRAY) || textField.getText().equals("")) {
                        textField.setText(str);
                        textField.setForeground(Color.GRAY);
                    }
                }
            });

            textField.addActionListener(e -> {

            });

            addLabel_x += (X_FOR_LABEL * 2) + (X_FOR_FIELD * 2) + labelWidth + 10;
            addField_x += (X_FOR_FIELD * 2) + 10;
            hashMapOfFields.put(str, textField);

        }
        y_Coordinate += 40;

    }

    private void addNotePad() {
        int y = (int) (frameHeight / 2.5);
        String str = "Գրառումների համար";

        TextArea textArea = new TextArea(str);
        textArea.setBounds(frameWidth - (frameWidth / 4), y, ((int)(Width * 1.5)), (Height * 6));
        textArea.setFont(new Font("Arial", Font.ITALIC, 15));
        textArea.setForeground(Color.GRAY);
        frame.add(textArea);

        //Ghost text
        textArea.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textArea.getForeground().equals(Color.GRAY) || textArea.getText().equals("")) {
                    textArea.setText("");
                    textArea.setFont(null);
                    textArea.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textArea.getForeground().equals(Color.GRAY) || textArea.getText().equals("")) {
                    textArea.setText(str);
                    textArea.setFont(new Font("Arial", Font.ITALIC, 15));
                    textArea.setForeground(Color.GRAY);
                }
            }
        });
    }

    private void addRegisterButton() {
        JButton button = new JButton("Գրանցել");
        y_Coordinate += 40;
        int buttonWidth = 100;
        button.setBounds((frameWidth - (frameWidth / 2) - Width), y_Coordinate, buttonWidth, Height);
        frame.add(button);

        button.addActionListener(e -> {
            if (!(areAllFieldsFilled())) {
                new WarningWindow("Բոլոր պարտադիր դաշտերը պետք է լրացվեն");
            } else {
                new WarningWindow("Ամեն ինչ ճիշտ է");
            }
        });

        y_Coordinate += 40;
    }

    private boolean areAllFieldsFilled() {
        for (String a : labelName) {
            if (a.contains("*")){
                if (hashMapOfFields.get(a).getText().equals("") || hashMapOfFields.get(a).getText().equals(a)){
                    return false;
                }
            }

        }
        for (String a : labelDirector) {
            if (a.contains("*")){
                if (hashMapOfFields.get(a).getText().equals("") || hashMapOfFields.get(a).getText().equals(a)){
                    return false;
                }
            }

        }
        for (String a : labelPassportAndDate) {
            if (a.contains("*")){
                if (hashMapOfFields.get(a).getText().equals("") || hashMapOfFields.get(a).getText().equals(a)){
                    return false;
                }
            }

        }
        for (String a : labelAddress) {
            if (a.contains("*")){
                if (hashMapOfFields.get(a).getText().equals("") || hashMapOfFields.get(a).getText().equals(a)){
                    return false;
                }
            }

        }
        for (String a : labelEmailNumber) {
            if (a.contains("*")){
                if (hashMapOfFields.get(a).getText().equals("") || hashMapOfFields.get(a).getText().equals(a)){
                    return false;
                }
            }

        }
        return true;
    }

}


package bankProject.UI.contracts;

import bankProject.UI.register.WarningWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class ExitOrder {
    private JFrame frame;

    /**
     * Frame dimensions
     */
    private static final int frameWidth = 1080;
    //Frame width
    private static int frameHeight = 600;
    //Frame Height (is dynamic and will be enlarged according to count of labels and text fields)

    /**
     *  are array of Label names, which will be inserted in frame
     *      <p>- to add Label and TextField to the frame, just simply add name to this array</p>
     */
    private final String[] labelPayerName = {"Անուն","Ազգանուն","ՀՎՀՀ"};

    private final String[] labelPayerPassport = {"Անձնագիր","Սկիզբ","Վերջ"};

    private final String[] labelBankIDBalance = {"Բանկի ID","Հաշվեհամար","Մնացորդ"};

    private final String[] labelBeneficiary = {"Անուն","Ազգանուն", "ՀՎՀՀ"};

    private final String[] labelPassportAndDate = {"Անձնագիր","Սկիզբ","Վերջ"};

    private final String[] labelBeneficiaryBankID = {"Բանկի ID","Հաշվեհամար"};

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

    public ExitOrder() {
        createFrame();

        hashMapOfFields = new HashMap<>();

        addExitOrderAndSerialNum();
        dateTimeSet();
        addTitleLabel("Վճարող");
        addLabelAndField(labelPayerName);
        addLabelAndField(labelPayerPassport);
        addLabelAndField(labelBankIDBalance);
        addSeparator();
        addTitleLabel("Ստացող");
        addLabelAndField(labelBeneficiary);
        addLabelAndField(labelPassportAndDate);
        addLabelAndField(labelBeneficiaryBankID);
        addPurpose();
        addSendButton();
    }

    private void createFrame() {

        frame = new JFrame("Ելքի օրդեր");
        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //place the frame in center of screen
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int screenHeight = toolkit.getScreenSize().height;
        int screenWidth = toolkit.getScreenSize().width;
        frame.setLocation((screenWidth / 2) - (frameWidth / 2), (screenHeight / 2) - (frameHeight / 2));

        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLayout(null);

    }

    private void addLabelAndField(String[] labelNames) {
        //Creating and placing Labels and Text fields
        int addLabel_x = -5;

        int addField_x = 0;

        int labelWidth = -50;

        int frameWidthChange = 0;

        for (var str : labelNames) {

            if (y_Coordinate >= 450) {
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

    private void addSeparator() {
        y_Coordinate += 30;
        var sep = new JSeparator();
        sep.setBounds(0, y_Coordinate, frameWidth, Height);
        frame.add(sep);
        y_Coordinate += 40;
    }

    private void addExitOrderAndSerialNum() {
        int addOffset = 160;
        JTextField exitOrder = new JTextField("Ելքի օրդեր");
        exitOrder.setBounds(X_FOR_LABEL, (y_Coordinate - 40), Width, Height);
        exitOrder.setEditable(false);
        frame.add(exitOrder);

        JTextField serialNum = new JTextField("Հերթական համար");
        serialNum.setForeground(Color.GRAY);
        serialNum.setBounds((X_FOR_LABEL + addOffset), (y_Coordinate - 40), Width, Height);
        serialNum.setEditable(false);
        frame.add(serialNum);

        JLabel amountLabel =  new JLabel("Գումար");
        amountLabel.setBounds((frameWidth - (X_FOR_LABEL * 10)), (y_Coordinate - 40), (Width / 2), Height);
        frame.add(amountLabel);

        JTextField amountField = new JTextField();
        amountField.setBounds((frameWidth - (X_FOR_LABEL * 8)), (y_Coordinate - 40), (Width / 2), Height);
        frame.add(amountField);

        JTextField currencyField = new JTextField("AMD");
        currencyField.setBounds((frameWidth - (X_FOR_LABEL * 5) - 10), (y_Coordinate - 40), (Width / 3), Height);
        currencyField.setEditable(false);
        frame.add(currencyField);

    }

    private void addPurpose() {
        String str = "Ելքի նպատակ";

        JLabel label = new JLabel(str);
        label.setBounds(X_FOR_LABEL - 5, y_Coordinate, Width, Height);
        frame.add(label);


        JTextField textField = new JTextField(str);
        textField.setBounds(X_FOR_FIELD, y_Coordinate, (Width * 4), Height);
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
        y_Coordinate += 40;
    }


    private void addTitleLabel(String str) {
        JLabel label = new JLabel(str);
        label.setBounds(X_FOR_LABEL, y_Coordinate, Width, Height);
        label.setFont(new Font("Arial",Font.BOLD, 20));
        frame.add(label);

        y_Coordinate += 50;
    }

    private void addSendButton() {
        JButton button = new JButton("Փոխանցել");
        button.setBounds((frameWidth - (X_FOR_LABEL * 8)), (frameHeight - (frameHeight / 2)), Width, Height);
        button.addActionListener(e -> {
            if (!(areAllFieldsFilled())) {
                new WarningWindow("Չի Փոխանցվել");
            } else {
                new WarningWindow("Փոխանցումը հաջողվեց");
            }
        });
        frame.add(button);
    }

    private void dateTimeSet() {
        int offset = 350;
        JLabel time = new JLabel();
        Thread clock = new Thread(() -> {
            try {
                for (; ; ) {
                    Calendar calendar = new GregorianCalendar();
                    int day = calendar.get(Calendar.DAY_OF_MONTH);
                    int month = calendar.get(Calendar.MONTH);
                    int year = calendar.get(Calendar.YEAR);

                    int seconds = calendar.get(Calendar.SECOND);
                    int minutes = calendar.get(Calendar.MINUTE);
                    int hours = calendar.get(Calendar.HOUR_OF_DAY);

                    time.setText("Ամսաթիվ " + day + "/" + month + "/" + year + "  " + hours +
                            ":" + minutes + ":" + seconds);
                    Thread.sleep(1000);
                    time.setBounds((X_FOR_LABEL + offset), 20, Width, Height);
                    frame.add(time);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        clock.start();
    }

    private boolean areAllFieldsFilled() {
        for (String a : labelPayerName) {
            if (hashMapOfFields.get(a).getText().equals("") || hashMapOfFields.get(a).getText().equals(a)) {
                return false;
            }
        }
        for (String a : labelPayerPassport) {
            if (hashMapOfFields.get(a).getText().equals("") || hashMapOfFields.get(a).getText().equals(a)) {
                return false;
            }
        }
        for (String a : labelBankIDBalance) {
            if (hashMapOfFields.get(a).getText().equals("") || hashMapOfFields.get(a).getText().equals(a)) {
                return false;
            }
        }
        for (String a : labelBeneficiary) {
            if (hashMapOfFields.get(a).getText().equals("") || hashMapOfFields.get(a).getText().equals(a)) {
                return false;
            }
        }
        for (String a : labelPassportAndDate) {
            if (hashMapOfFields.get(a).getText().equals("") || hashMapOfFields.get(a).getText().equals(a)) {
                return false;
            }
        }
        for (String a : labelBeneficiaryBankID) {
            if (hashMapOfFields.get(a).getText().equals("") || hashMapOfFields.get(a).getText().equals(a)) {
                return false;
            }
        }
        return true;
    }
}

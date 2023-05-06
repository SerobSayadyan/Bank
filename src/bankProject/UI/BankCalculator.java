package bankProject.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankCalculator{
    private double amount;
    private double percentage;
    private int months;

    private final JFormattedTextField amountField;
    private final JFormattedTextField percentageField;
    private final JFormattedTextField monthsField;
    private final JFormattedTextField paymentField;

    private JLabel amountLabel;
    private JLabel percentageLabel;
    private JLabel monthsLabel;
    private JLabel paymentLabel;

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public BankCalculator(){

        JFrame frame = new JFrame("Calculator");
        frame.setResizable(false);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\bankProject\\UI\\icons\\APR calculator.png"));

        frame.setLayout(new GridLayout(5, 0, 10,5));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((screenSize.width / 2) - 200,
                (screenSize.height / 2) - 100);

        amountField = new JFormattedTextField(amount);
        percentageField = new JFormattedTextField(percentage);
        monthsField = new JFormattedTextField(months);
        paymentField = new JFormattedTextField();
        paymentField.setEditable(false);

        //Button "Հաշվել"
        JButton button = new JButton("Հաշվել");

        button.addActionListener(e -> {
            amount = (double) amountField.getValue();
            percentage = (double) percentageField.getValue();
            months = (int) monthsField.getValue();

            amountField.setValue(amountField.getValue());
            paymentField.setValue(percentageField.getValue());
            monthsField.setValue(monthsField.getValue());
            paymentField.setValue(calculatePercentage(amount, percentage, months));
        });

        amountLabel = new JLabel("Վարկի չափը");
        amountLabel.setLabelFor(amountField);
        percentageLabel = new JLabel("Տարեկան տոկոսադրույք (%)");
        percentageLabel.setLabelFor(percentageField);
        monthsLabel = new JLabel("Քանի ամսով");
        monthsLabel.setLabelFor(monthsField);
        paymentLabel = new JLabel("Ամսական վճար");
        paymentLabel.setLabelFor(paymentField);


        frame.add(amountLabel, BorderLayout.LINE_START);
        frame.add(amountField, BorderLayout.CENTER);
        frame.add(percentageLabel, BorderLayout.LINE_START);
        frame.add(percentageField, BorderLayout.CENTER);
        frame.add(monthsLabel, BorderLayout.LINE_START);
        frame.add(monthsField, BorderLayout.CENTER);
        frame.add(paymentLabel, BorderLayout.LINE_START);
        frame.add(paymentField, BorderLayout.CENTER);
        frame.add(button, BorderLayout.CENTER);

        frame.setVisible(true);
        frame.pack();
    }


//    public void propertyChange(PropertyChangeEvent evt) {
//        Object source = evt.getSource();
//        if (source == amountField){
//            amount = (double) (amountField.getValue());
//        } else if (source == percentageField){
//            percentage = (double) (percentageField.getValue());
//        } else if (source == monthsField){
//            months = (int) (monthsField.getValue());
//        }
//        paymentField.setValue(calculatePercentage(amount,percentage,months));
//    }

    private double calculatePercentage(double loanAmount, double percent, double months){
        double realPercent = (percent / 100) + 1;
        double generalLoan = realPercent * loanAmount;

        return generalLoan / months;
    }


}

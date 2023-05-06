package bankProject.UI;

import bankProject.UI.contracts.AccessOrder;
import bankProject.UI.contracts.ExitOrder;
import bankProject.UI.login.AllLogin;
import bankProject.UI.login.IndividualLogin;
import bankProject.UI.login.LegalPersonLogin;
import bankProject.UI.login.PrivateEntrepreneurLogin;
import bankProject.UI.register.IndividualRegistration;
import bankProject.UI.register.LegalPersonRegistration;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Serob Sayadyan
 */

public class BankOfWave4 {
    private static JFrame frame;
    private static JMenuBar menuBar;
    private static JLabel time;

    public BankOfWave4() {
        createFrame();

        menuBar = new JMenuBar();
        menuBar.setVisible(true);
        frame.setJMenuBar(menuBar);

        createContractMenuItem();
        createClientMenuItem();
        createRegisterMenuItem();
        createAccountMenuItem();
        createCalculatorMenuItem();

        dateTimeSet();
        menuBar.add(time);

    }

    public static void main(String[] args) {
        new BankOfWave4();
    }

    private void createFrame() {
        frame = new JFrame("Bank Of Wave4 Java");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("BankIcon.png"));
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        frame.setLocation((screenSize.width / 2) - 325,
                (screenSize.height / 2) - 250);

        JLabel hello = new JLabel(new ImageIcon("BankOfPicsart.png"));
        frame.add(hello);

        frame.setSize(650, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLayout(new GridLayout());
    }

    private void createContractMenuItem() {
        //Menu Գործարքներ
        JMenu contractMenu = new JMenu("Գործարքներ");
        JMenuItem exitOrder = new JMenuItem("Ելքի օրդեր");
        JMenuItem accessOrder = new JMenuItem("Մուտքի օրդեր");
        contractMenu.add(exitOrder);
        contractMenu.add(accessOrder);
        menuBar.add(contractMenu);

        //press Ելքի օրդեր
        exitOrder.addActionListener(e -> new ExitOrder());
        //press Մուտքի օրդեր
        accessOrder.addActionListener(e -> new AccessOrder());
    }

    private void createClientMenuItem() {
        //Menu Հաճախորդ
        JMenu clientMenu = new JMenu("Հաճախորդ");
        JMenuItem individual1 = new JMenuItem("Ֆիզիկական անձ");
        JMenuItem legal1 = new JMenuItem("Իրավաբանական անձ");
        JMenuItem PE1 = new JMenuItem("Ա/Ձ"); // Private Entrepreneur
        JMenuItem all1 = new JMenuItem("Բոլորը");
        clientMenu.add(individual1);
        clientMenu.add(legal1);
        clientMenu.add(PE1);
        clientMenu.add(all1);
        menuBar.add(clientMenu);

        //press Ֆիզիկական անձ
        individual1.addActionListener(e -> new IndividualLogin());
        //press Իրավաբանական անձ
        legal1.addActionListener(e -> new LegalPersonLogin());
        //press Ա/Ձ
        PE1.addActionListener(e -> new PrivateEntrepreneurLogin());
        //press Բոլորը
        all1.addActionListener(e -> new AllLogin());
    }

    private void createRegisterMenuItem() {
        //Menu Գրանցվել
        JMenu registerMenu = new JMenu("Գրանցել");
        JMenuItem individual2 = new JMenuItem("Ֆիզիկական անձ");
        JMenuItem legal2 = new JMenuItem("Իրավաբանական անձ");
        JMenuItem PE2 = new JMenuItem("Ա/Ձ"); // Private Entrepreneur
        registerMenu.add(individual2);
        registerMenu.add(legal2);
        registerMenu.add(PE2);
        menuBar.add(registerMenu);

        //press Ֆիզիկական անձ
        individual2.addActionListener(e -> new IndividualRegistration());
        //press Իրավաբանական անձ
        legal2.addActionListener(e -> new LegalPersonRegistration());
        //press Ա/Ձ
        PE2.addActionListener(e -> new PrivateEntrepreneurLogin());
    }

    private void createAccountMenuItem() {
        JMenu accountMenu = new JMenu("Հաշվետվություն");
        JMenuItem individual3 = new JMenuItem("Ֆիզիկական անձ");
        JMenuItem legal3 = new JMenuItem("Իրավաբանական անձ");
        JMenuItem PE3 = new JMenuItem("Ա/Ձ"); // Private Entrepreneur
        JMenuItem all3 = new JMenuItem("Բոլորը");
        accountMenu.add(individual3);
        accountMenu.add(legal3);
        accountMenu.add(PE3);
        accountMenu.add(all3);
        menuBar.add(accountMenu);

        //press Ֆիզիկական անձ
        individual3.addActionListener(e -> new IndividualLogin());
        //press Իրավաբանական անձ
        legal3.addActionListener(e -> new LegalPersonLogin());
        //press Ա/Ձ
        PE3.addActionListener(e -> new PrivateEntrepreneurLogin());
        //press Բոլորը
        all3.addActionListener(e -> new AllLogin());
    }

    private void createCalculatorMenuItem() {
        JButton calcButton = new JButton("Հաշվիչ");
        menuBar.add(calcButton);

        //press Հաշվիչ
        calcButton.addActionListener(e -> {
//                String[] arguments = {"",""};
//                FormattedTextFieldDemo.main(arguments);
            new BankCalculator();
        });
    }

    private void dateTimeSet() {
        time = new JLabel();
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
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        clock.start();
    }
}
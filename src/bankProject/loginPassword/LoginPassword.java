package bankProject.loginPassword;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginPassword {
    public static void main(String[] args) throws InterruptedException {
        LoginPassword lp = new LoginPassword();
        lp.LoginFrame();
//        lp.RegisterFrame();
    }

    /**
     * Login frame
     */

    public void LoginFrame() throws InterruptedException {
        UserDateBase db = new UserDateBase();

        JLabel note = new JLabel();
        note.setBounds(90,10, 200,50);
        JFrame frame = new JFrame("Login");
        var login = new JTextField();
        login.setBounds(100, 60, 130, 30);           //Login field
        var label = new JLabel("Username");
        label.setBounds(20, 60, 80, 30);             //"Username" label
        var password = new JPasswordField();
        password.setBounds(100, 110, 130, 30);       //Password field
        var label2 = new JLabel("Password");
        label2.setBounds(20, 110, 80, 30);           //"Password" label
        var button = new JButton("Enter");
        button.setBounds(120, 165, 90, 30);          //"Enter" button
        var register = new JButton("Register");
        register.setBounds(120, 210, 90, 30);

        frame.add(note);
        frame.add(login);
        frame.add(label);
        frame.add(password);
        frame.add(label2);
        frame.add(button);
        frame.add(register);
        frame.setSize(310, 300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);

        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                note.setText(db.checkLogin(login.getText(), password.getText()));
            }
        });
        register.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterFrame();
                try {
                    Thread.sleep(1000);
                    frame.setVisible(false);
                } catch (InterruptedException exception){
                    System.out.println(exception);
                }
            }
        });

    }

    /**
     * Register Frame
     */

    public void RegisterFrame() {
        UserDateBase db = new UserDateBase();

        JLabel note = new JLabel();
        note.setBounds(80,190, 260,50);              //notification about the confirmation
        JFrame frame = new JFrame("Register");                     //"Register" frame
        var login = new JTextField();
        login.setBounds(100, 50, 130, 30);           //Login field
        var label = new JLabel("Username");
        label.setBounds(20, 50, 80, 30);             //"Username" label
        var password = new JPasswordField();
        password.setBounds(100, 100, 130, 30);       //Password field
        var label2 = new JLabel("Password");
        label2.setBounds(20, 100, 80, 30);           //"Password" label
        var passwordRep = new JPasswordField();
        JLabel passwordRequireNote = new JLabel();
        passwordRequireNote.setBounds(100, 115, 260, 50);
        passwordRequireNote.setText("The password should contain no more than 16 symbols");
        passwordRequireNote.setFont(new Font("Arial", Font.ITALIC, 10));
        passwordRep.setBounds(100, 150, 130, 30);    //Password Repeat field
        var label3 = new JLabel("Confirm");
        label3.setBounds(20, 150, 130, 30);          //"Confirm" label
        var button = new JButton("Register");
        button.setBounds(250, 100, 100, 30);          //"Register" button

        frame.add(note);
        frame.add(login);
        frame.add(label);
        frame.add(password);
        frame.add(passwordRequireNote);
        frame.add(label2);
        frame.add(passwordRep);
        frame.add(label3);
        frame.add(button);
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);

        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(password.getText().equals(passwordRep.getText())) {
                    note.setText(db.Register(login.getText(), password.getText()));
                } else {
                    note.setText("The passwords are not matching");
                }
            }
        });

    }
}

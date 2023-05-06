package bankProject.loginPassword;

import java.io.*;
import java.util.Scanner;

public class UserDateBase {
    private final String separator = " :: ";
    private final File file = new File("loginPassword.txt");
    public String checkLogin(String enterLog, String enterPass){
        boolean state = true;
        try {
            Scanner sc = new Scanner(file);
            String s;
             do {
                 if(sc.hasNextLine()) {
                     s = sc.nextLine();
                     if (s.contains(enterLog)) {
                         MyEncrypt encrypt = new MyEncrypt();
                         String[] tmp = s.split(separator);
                         if (tmp[1].contains(encrypt.ME1(enterPass))) {
                             return "The User exists!";
                         }
                     }
                 } else {
                     state = false;
                 }
             } while (state);
            sc.close();
        } catch (FileNotFoundException e){
            System.out.println(e);
        }
        return "Login or password are not correct";

    }
    public String Register(String enterLog, String enterPass){
        boolean state = true;
        try {
            Scanner sc = new Scanner(file);
            do {
                if(sc.hasNextLine()) {
                    String[] s = sc.nextLine().split(separator);
                    if (s[0].equals(enterLog)) {
                        return "The User already exists!";
                    }
                } else {
                    state = false;
                }
            } while (state);
            sc.close();
        } catch (FileNotFoundException e){
            System.out.println(e);
        }
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            MyEncrypt me1 = new MyEncrypt();
            enterLog = enterLog.trim();
            enterPass = enterPass.trim();
            bw.newLine();
            bw.write(enterLog + separator + me1.ME1(enterPass));
            bw.flush();
            bw.close();

        } catch (IOException e){
            System.out.println(e);
        }
        return "The registration was SUCCESSFUL";

    }
}

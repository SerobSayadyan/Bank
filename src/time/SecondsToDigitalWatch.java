package time;

import java.util.Scanner;

public class SecondsToDigitalWatch {

    public static void main(String[] args) {
        int seconds = new Scanner(System.in).nextInt();
        System.out.printf("%d:%d:%d", (seconds / 3600), ((seconds % 3600) / 60), (seconds % 60));
    }
}

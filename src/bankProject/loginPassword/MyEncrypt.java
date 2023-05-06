package bankProject.loginPassword;

public class MyEncrypt {
    final private static String salt = "XostanumEmLavSovorel";
    final private static byte L1 = 16;
    final private static byte L2 = 100;
    final private static byte L3 = 77;
    final private static byte L4 = 22;
    final private static byte L5 = 34;
    final private static byte L6 = 45;
    public String ME1(String str) {
        StringBuilder sb = new StringBuilder();
        if (str.length() <= 16) {
            sb.append(str).append(salt, 0, (salt.length() - str.length()));
        } else {
            throw new RuntimeException("the size of password should be 16");
        }
        int n = sb.length();
        for (int i = 0; i < n; i++) {
            if (i % 6 == 0) {
                sb.append(Integer.toHexString((char) (sb.charAt(i) + L1)));
            } else if (i % 5 == 0) {
                sb.append(Integer.toHexString((char) (sb.charAt(i) + L2)));
            } else if (i % 4 == 0) {
                sb.append(Integer.toHexString((char) (sb.charAt(i) + L3)));
            } else if (i % 3 == 0) {
                sb.append(Integer.toHexString((char) (sb.charAt(i) + L4)));
            } else if (i % 2 == 0) {
                sb.append(Integer.toHexString((char) (sb.charAt(i) + L5)));
            } else {
                sb.append(Integer.toHexString((char) (sb.charAt(i) + L6)));
            }
        }
        sb.delete(0, n);
        n = sb.length();
        sb.reverse();
        String tmp = sb.substring(0,(n / 2));
        sb.append(tmp);
        sb.delete(0, (n / 2));
        tmp = sb.substring(0,(n / 4));
        sb.append(tmp);
        sb.delete(0, (n / 4));
        tmp = sb.substring(0,(n / 6));
        sb.append(tmp);
        sb.delete(0, (n / 6));
        int n2 = sb.length();
        sb.delete(n, n2);
        return sb.toString();
    }
}

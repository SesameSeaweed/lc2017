package google;

public class LicenseKeyFormatting482 {
    public static String licenseKeyFormatting(String S, int K) {
        StringBuilder sb  = new StringBuilder();
        StringBuilder out = new StringBuilder();
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) != '-') {
                sb.append(S.charAt(i));
            }
        }
        if(sb.length() == 0) return "";
        int group = sb.length() / K;
        if(sb.length() % K != 0) {
            out.append(sb.substring(0, sb.length() % K).toUpperCase()).append("-");
        }

        for(int i = 0; i < group; i++) {
            out.append(sb.substring(i*K + sb.length() % K, (i+1)*K + sb.length()%K).toUpperCase() ).append("-");
        }
        return out.substring(0, out.length() - 1).toString();
    }

    public static void main(String[] args) {
        String S = "2-4A0r7-4k";
        System.out.println(licenseKeyFormatting(S, 3));
    }
}

package google2;


public class LicenseKeyFormatting482 {
    public static String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder("");
        for( char c : S.toCharArray()) {
            if(c != '-') sb.append(Character.toUpperCase(c));
        }
        int mod = sb.length() % K;
        int count = sb.length() / K;

        StringBuilder out = new StringBuilder();
        out.append(sb.substring(0, mod));

        for(int i = 0; i < count; i++) {
            out.append("-").append(sb.substring(mod+i*K, mod+i*K+K));
        }
        return mod == 0 ?(out.length() > 0 ? out.substring(1) : ""): out.toString();
    }

    public static void main(String[] args) {
//        String S = "2-4A0r7-4k";
        String S = "---";
        int K = 3;
        System.out.print(licenseKeyFormatting(S, K));
    }
}

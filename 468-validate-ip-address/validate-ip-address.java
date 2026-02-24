class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP == null || queryIP.length() == 0) 
            return "Neither";
        if (queryIP.indexOf('.') >= 0) {
            return isIPv4(queryIP) ? "IPv4" : "Neither";
        }
        if (queryIP.indexOf(':') >= 0) {
            return isIPv6(queryIP) ? "IPv6" : "Neither";
        }
        return "Neither";
    }

    private boolean isIPv4(String s) {
        // Must have exactly 3 dots (4 parts)
        if (countChar(s, '.') != 3) 
            return false;

        String[] parts = s.split("\\.", -1); // keep empty tokens
        if (parts.length != 4) 
            return false;

        for (String p : parts) {
            if (p.length() == 0 || p.length() > 3) 
                return false;

            // digits only
            for (int i = 0; i < p.length(); i++) {
                char c = p.charAt(i);
                if (c < '0' || c > '9') return false;
            }

            // no leading zeros unless single '0'
            if (p.length() > 1 && p.charAt(0) == '0') 
                return false;

            int val = 0;
            for (int i = 0; i < p.length(); i++) {
                val = val * 10 + (p.charAt(i) - '0');
            }
            if (val < 0 || val > 255) 
                return false;
        }
        return true;
    }

    private boolean isIPv6(String s) {
        // Must have exactly 7 colons (8 parts)
        if (countChar(s, ':') != 7) 
            return false;

        String[] parts = s.split(":", -1); // keep empty tokens
        if (parts.length != 8) 
            return false;

        for (String p : parts) {
            if (p.length() == 0 || p.length() > 4) 
                return false;
            for (int i = 0; i < p.length(); i++) {
                char c = p.charAt(i);
                if (!isHex(c)) 
                    return false;
            }
        }
        return true;
    }

    private boolean isHex(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') ||
               (c >= 'A' && c <= 'F');
    }

    private int countChar(String s, char ch) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) cnt++;
        }
        return cnt;
    }
}
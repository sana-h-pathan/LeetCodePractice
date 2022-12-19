package practice.easy;

public class LongestCommonPrefix {

    //check the logic
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String min = strs[0];
        String max = strs[0];
        for (String current : strs) {
            if (current.compareTo(max) > 0) {
                max = current;
            } else if (current.compareTo(min) < 0) {
                min = current;
            }
        }

        int num = 0;
        for (int i = 0; i < min.length() && i < max.length(); i++) {
            if (min.charAt(i) != max.charAt(i)) {
                break;
            }
            num++;
        }
        return min.substring(0, num);
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        longestCommonPrefix.longestCommonPrefix(new String[]{"flower,flow,florance"});
    }
}

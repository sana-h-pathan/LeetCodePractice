class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");
        int p1=v1.length;
        int p2=v2.length;
        int max_len = Math.max(v1.length, v2.length);

        for (int i = 0; i < max_len; i++) {
            int revision1 = i < p1 ? Integer.parseInt(v1[i]) : 0;
            int revision2 = i < p2 ? Integer.parseInt(v2[i]) : 0;
            if (revision1 < revision2) {
                return -1;
            } else if (revision1 > revision2) {
                return 1;
            }
        }
        return 0;
    }  
}
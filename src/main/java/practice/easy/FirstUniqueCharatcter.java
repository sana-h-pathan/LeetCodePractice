package practice.easy;

import java.util.HashMap;

public class FirstUniqueCharatcter {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> charMap=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            charMap.put(c,charMap.getOrDefault(c,0)+1);
        }
        for (int i=0;i<s.length();i++){
            if (charMap.get(s.charAt(i)) == 1)
            return i;
        }
        return -1;

    }

    public static void main(String[] args) {
        FirstUniqueCharatcter firstUniqueCharatcter=new FirstUniqueCharatcter();
        System.out.println(firstUniqueCharatcter.firstUniqChar("aabb"));
    }
}

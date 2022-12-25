package practice.medium;

import java.util.*;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String str = String.valueOf(charArray);
            if(!map.containsKey(str))
                map.put(str, new ArrayList<>());
            map.get(str).add(s);
        }
        return new ArrayList(map.values());
    }

    public static void main(String[] args) {
        GroupAnagram groupAnagram=new GroupAnagram();
        groupAnagram.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }
}

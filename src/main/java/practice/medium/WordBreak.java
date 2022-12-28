package practice.medium;

import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] f = new boolean[s.length()+1];
        f[0] = true;
        for(int index = 1; index <= s.length();index++){
            for(int j = 0; j < index; j++){
                if(f[j] && set.contains(s.substring(j,index))){
                    f[index]=true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
    public static void main(String[] args) {
        WordBreak wordBreak=new WordBreak();
        System.out.println(wordBreak.wordBreak("catsandog", new ArrayList<String>(Arrays.asList("cats","dog","sand","an","cat"))));
    }

}

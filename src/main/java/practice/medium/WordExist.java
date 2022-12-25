package practice.medium;

import java.util.ArrayList;
import java.util.List;

public class WordExist {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> result=new ArrayList<>();
        if(digits.length()>4||digits.contains("0")||digits.contains("1")||digits == null || digits.length() == 0)
            return result;
        result.add("");
        String[] mapping=new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        for (int i=0;i<digits.length();i++){
            ArrayList<String> newRes = new ArrayList<>();
            char[] charArray= mapping[digits.charAt(i) - '0'].toCharArray();
            for (String str : result){
                for (char c : charArray){
                    newRes.add(str + c);
                }
            }
            result=newRes;
        }
        return result;
    }

        public static void main(String[] args) {
        WordExist wordExist =new WordExist();
            System.out.println(wordExist.letterCombinations("43611"));
    }
}

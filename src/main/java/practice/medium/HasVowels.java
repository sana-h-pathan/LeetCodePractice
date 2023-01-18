package practice.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HasVowels {
    public  List<Integer> hasVowels(List<String> strArr, List<String> query) {

        List<Integer> result = new ArrayList<>();
        List<Integer> counterList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int count  = 0;
        for(int i =0; i < strArr.size(); i++){
            String word = strArr.get(i);
            if(isValidWord(word)){
                count =  i > 0 ?counterList.get(i-1) +1 : 1;
            }
            counterList.add(i,count);

        }

        for(int i =0; i < query.size(); i++){
            String q = query.get(i); //'1-3'
            String[] splitArray = q.split("-");
            int low =  Integer.valueOf(splitArray[0])-1;
            int high =  Integer.valueOf(splitArray[1])-1;

            int c = isValidWord(strArr.get(low)) ? 1 : 0;
            result.add(counterList.get(high) - counterList.get(low) + c);
        }

        return result;


    }
    public static void main(String[] args) {
        HasVowels hasVowels=new HasVowels();
        hasVowels.hasVowels(new ArrayList<String>(Arrays.asList("aba","bcb","ece","aa","e")),new ArrayList<String>(Arrays.asList("1-3","2-5","2-2")));
    }

    public static boolean isValidWord(String word) {
        return isVowel(word.charAt(0)) && isVowel(word.charAt(word.length()-1));
    }

    public static boolean isVowel(char ch) {
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        return (vowels.contains(ch));
    }
}

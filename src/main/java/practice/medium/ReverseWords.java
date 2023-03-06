package practice.medium;

import java.util.ArrayList;
import java.util.List;

public class ReverseWords {

    public String reverseWords(String s) {
        String[] splitString=s.split(" ");
        List<String> outputString = new ArrayList<>();
        for(String singleString: splitString){
            int startIndex=0;
            int lastIndex=singleString.length()-1;
            char ch[] = singleString.toCharArray();
            while(startIndex<lastIndex){
                char tmp=ch[startIndex];
                ch[startIndex]=ch[lastIndex];
                ch[lastIndex]=tmp;
                startIndex++;
                lastIndex--;
            }
            outputString.add(new String(ch));
        }
        return String.join(" ", outputString);
    }
    public static void main(String[] args) {
        ReverseWords reverseWords=new ReverseWords();
        System.out.println(reverseWords.reverseWords("God Ding"));
    }
}

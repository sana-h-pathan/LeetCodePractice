package practice.medium;

public class RearrangeBinaryString {
    public int secondsToRemoveOccurrences(String s) {
        int seconds = 0;
        while(s.indexOf("01") >= 0){
            s= s.replaceAll("01","10");
            seconds++;
        }
        return seconds;
    }

    public static void main(String[] args) {
        RearrangeBinaryString rearrangeBinaryString=new RearrangeBinaryString();
        System.out.println(rearrangeBinaryString.secondsToRemoveOccurrences("0110101"));

    }
}

package practice.easy;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String a1=s.replaceAll("[^a-zA-Z0-9]", " ").replace(" ", "").toLowerCase();
        String b="";
        for(int i=a1.length()-1;i>=0;i--)
        {
            b=b+""+a1.charAt(i);
        }
        if(a1.contentEquals(b) || s.length()==0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome=new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(validPalindrome.isPalindrome("race a car"));
    }
}

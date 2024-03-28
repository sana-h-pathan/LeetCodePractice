class Solution {
    public int minimumKeypresses(String s) {
        
        
        Integer count[]=new Integer[26];
        Arrays.fill(count,0);
        int ans=0;
        for(int i=0;i<s.length();i++)
            count[s.charAt(i)-'a']++; //freq of character in the given string
        
        Arrays.sort(count,(a,b)->b-a); //sorting freq in descending order
        
        for(int i=0;i<26;i++)
        {
            if(i<9) //character with max frequencies ar accomodated first character of each number
                ans+=count[i];
            else if(i<18) //charatcer with intermediate freq are accomodates second position (that is 2 presses are required)
                ans+=2*count[i];
            else
                ans+=3*count[i]; //similarly least frequent characters will need 3 presses
            
        }
        return ans;
    }
}
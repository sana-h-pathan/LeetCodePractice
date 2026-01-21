class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
      if(s.length()<10)
          return new ArrayList<>();
        
        
        HashSet<Integer> allSubHash=new HashSet<>();
        HashSet<String> result=new HashSet<>();
        HashMap<Character,Integer> charMap=new HashMap<>();
        charMap.put('A',1);
        charMap.put('C',2);
        charMap.put('G',3);
        charMap.put('T',4);
        int hashValue=0;
        int nl = 1;
        int k = 4;
        //here we are using 4 as we have 4 unique character and 9 because the length of string will be 9
        for(int i=0;i<9;i++){
            nl*=k;
        }
        int l=0;
        int r=0;
        while(r<s.length()){
            //process the out element first when our index reaches 10
            if(r>=10){
                char outChar=s.charAt(l);
                hashValue=hashValue-charMap.get(outChar)*nl;
                l++;
            }
            //process every in element
            char inChar=s.charAt(r);
            hashValue=hashValue*k+charMap.get(inChar);
            if(allSubHash.contains(hashValue)){
                result.add(s.substring(l,r+1));
            }
            else
                allSubHash.add(hashValue);

            r++;
            
        }
        return new ArrayList<>(result);
    }
}
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
        //here we are using 4 as we have 4 unique character and 9 because the length of string will be 9
        for(int i=0;i<9;i++){
            nl*=4;
        }
        for(int i=0;i<s.length();i++){
            //process the out element first when our index reaches 10
            if(i>=10){
                char outChar=s.charAt(i-10);
                hashValue=hashValue-charMap.get(outChar)*nl;
            }
            //process every in element
            char inChar=s.charAt(i);
            hashValue=hashValue*4+charMap.get(inChar);
            if(allSubHash.contains(hashValue)){
                result.add(s.substring(i-9,i+1));
            }
            else
                allSubHash.add(hashValue);
            
        }
        return new ArrayList<>(result);
    }
}
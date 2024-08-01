class Solution {
    public int countSeniors(String[] details) {
        int count=0;
        for(String person: details){
            String age=person.substring(11,13);
            if(Integer.parseInt(age)>60)
                count++;
        }
        return count;
    }
}
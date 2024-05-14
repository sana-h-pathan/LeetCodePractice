class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low=0;
        int high=letters.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            char c=letters[mid];
            if(c<=target){
                low=mid+1;
            }
            else 
                high=mid-1;
        }
        return low == letters.length ? letters[0] : letters[low];
        
    }
}
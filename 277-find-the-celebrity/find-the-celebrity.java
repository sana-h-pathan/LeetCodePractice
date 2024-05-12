/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int probableCeleb=0;
        for(int i=1;i<n;i++){
            if(knows(probableCeleb,i))
                probableCeleb=i;
        }
        for(int i=0;i<n;i++){
            if(probableCeleb!=i){
                if(i<probableCeleb && knows(probableCeleb,i))
                    return -1;
                if(!knows(i,probableCeleb))
                    return -1;
            }
        }
        return probableCeleb;
    }
}
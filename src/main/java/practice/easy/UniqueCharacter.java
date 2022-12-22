package practice.easy;

import javax.swing.tree.TreeNode;
import java.util.HashSet;
import java.util.Set;

public class UniqueCharacter {
    public boolean uniqueOccurrences(int[] arr) {
        //array to store number of occurrences
        int[] c = new int[2001];
        //count occurrences of each value
        for (int n : arr) {
            c[n+1000]++;
        }
        //check unique occurances (except for 0)
        Set<Integer> set = new HashSet();
        for (int count : c) {
            if (count == 0)
                continue;
            if (!set.add(count))
                return false;
        }
        return true;
    }

        public static void main(String[] args) {
        UniqueCharacter uniqueCharacter =new UniqueCharacter();

            System.out.println(uniqueCharacter.uniqueOccurrences(new int[]{1,2,2,1,1,3}));
            System.out.println(uniqueCharacter.uniqueOccurrences(new int[]{1,2}));
    }
}

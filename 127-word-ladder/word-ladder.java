class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // HashSet to store the words in the wordList for O(1) lookup
        HashSet<String> set = new HashSet<>();
        
        // Add all words from the wordList to the HashSet
        for (String word : wordList)
            set.add(word);

        // If the endWord is not present in the wordList, transformation is not possible
        if (!set.contains(endWord))
            return 0;
        
        // Queue for Breadth-First Search
        Queue<String> bfsQueue = new LinkedList<>();
        bfsQueue.add(beginWord);
        
        // Variable to track the steps (transformations)
        int step = 0;
        
        // While there are elements in the BFS queue
        while (!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            step++; // Increment the step count for each level
            
            // Process all nodes at this level
            for (int k = 0; k < size; k++) {  
                String curr = bfsQueue.poll(); // Get the current word
                
                // Try replacing each character of the current word with all possible letters
                for (int i = 0; i < curr.length(); i++) {
                    char[] chars = curr.toCharArray();
                    
                    // Replace the current character with all 26 alphabets
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String currWord = new String(chars); // Construct the new word
                        
                        // If the new word is in the wordList and not yet visited
                        if (set.contains(currWord)) {
                            // If it's the target word, return the step count + 1 (as we're counting transformations)
                            if (currWord.equals(endWord))
                                return step + 1;
                            
                            bfsQueue.add(currWord); // Add the new word to the BFS queue
                            set.remove(currWord); // Remove it from the set to avoid revisiting
                        }
                    }
                }
            }
        }
        return 0; // If transformation is not possible
    }
}

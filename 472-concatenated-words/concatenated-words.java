class Solution {
    HashSet<String> wordSet; // Set to store all words for quick lookup
    HashMap<String, Boolean> memo; // Memoization for DFS results
    
    // Method to find all concatenated words in the dictionary
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        this.wordSet = new HashSet<>(Arrays.asList(words)); // Initialize word set
        this.memo = new HashMap<>(); // Initialize memoization map
        
        List<String> result = new ArrayList<>(); // List to store concatenated words
        
        // Iterate through each word in the array
        for (String word : words) {
            // Check if the word can be formed by concatenating other words in the dictionary
            if (dfs(word))
                result.add(word); // Add the concatenated word to the result list
        }
        
        return result; // Return the list of concatenated words
    }
    
    // Depth-first search to check if a word can be formed by concatenating other words
    public boolean dfs(String word) {
        // If the memoization map contains the result for the current word, return it
        if (memo.containsKey(word) && !memo.get(word)) 
            return false;
        
        // Iterate through each possible prefix of the word
        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i); // Get the prefix
            
            // If the prefix is present in the dictionary
            if (wordSet.contains(prefix)) {
                String suffix = word.substring(i); // Get the suffix
                
                // If the suffix is also present in the dictionary or can be formed recursively
                if (wordSet.contains(suffix) || dfs(suffix)) {
                    memo.put(word, true); // Memoize the result as true
                    return true;
                }
            }
        }
        
        memo.put(word, false); // Memoize the result as false
        return false;
    }
}
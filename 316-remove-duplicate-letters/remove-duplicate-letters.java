class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        // this lets us keep track of what's in our solution in O(1) time
        HashSet<Character> visited = new HashSet<>();
        // this will let us know if there are any more instances of s[i] left in s
        HashMap<Character, Integer> lastIdx = new HashMap<>();
        for(int i = 0; i < s.length(); i++) 
            lastIdx.put(s.charAt(i), i);

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            // we can only try to add c if it's not already in our solution
            // this is to maintain only one of each character
            if (!visited.contains(c)){
                // if the last letter in our solution:
                //     1. exists
                //     2. is greater than c so removing it will make the string smaller
                //     3. it's not the last occurrence
                // we remove it from the solution to keep the solution optimal
                while(!stack.isEmpty() && c < stack.peek() && lastIdx.get(stack.peek()) > i){
                    visited.remove(stack.pop());
                }
                visited.add(c);
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
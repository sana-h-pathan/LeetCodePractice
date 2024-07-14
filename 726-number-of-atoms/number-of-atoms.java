class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());
        int idx = 0;

        while (idx < formula.length()) {
            if (formula.charAt(idx) == '(') {
                stack.push(new HashMap<>());
                idx++;
            }
            else if (formula.charAt(idx) == ')') {
                Map<String, Integer> currMap = stack.pop();
                idx++;
                StringBuilder multiplier = new StringBuilder();
                while (idx < formula.length() && Character.isDigit(formula.charAt(idx))) {
                    multiplier.append(formula.charAt(idx));
                    idx++;
                }
                if (multiplier.length() > 0) {
                    int mult = Integer.parseInt(multiplier.toString());
                    for (String atom : currMap.keySet()) {
                        currMap.put(atom, currMap.get(atom) * mult);
                    }
                }

                for (String atom : currMap.keySet()) {
                    stack.peek().put(atom,stack.peek().getOrDefault(atom, 0) + currMap.get(atom));
                }
            }else {
                StringBuilder currAtom = new StringBuilder();
                currAtom.append(formula.charAt(idx));
                idx++;
                while (idx < formula.length() &&Character.isLowerCase(formula.charAt(idx))) {
                    currAtom.append(formula.charAt(idx));
                    idx++;
                }
                StringBuilder currCount = new StringBuilder();
                while (idx < formula.length() &&Character.isDigit(formula.charAt(idx))) {
                    currCount.append(formula.charAt(idx));
                    idx++;
                }

                int count = currCount.length() > 0 ? Integer.parseInt(currCount.toString()):1;
                stack.peek().put(currAtom.toString(),
                    stack.peek().getOrDefault(currAtom.toString(), 0) + count);
            }
        }

        // Sort the final map
        TreeMap<String, Integer> finalMap = new TreeMap<>(stack.peek());

        // Generate the answer string
        StringBuilder ans = new StringBuilder();
        for (String atom : finalMap.keySet()) {
            ans.append(atom);
            if (finalMap.get(atom) > 1) {
                ans.append(finalMap.get(atom));
            }
        }

        return ans.toString();
    }
}
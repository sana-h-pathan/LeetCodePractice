
class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> adjMap = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            indegree.put(recipe, ingredients.get(i).size());

            for (String ing : ingredients.get(i)) {
                if(!adjMap.containsKey(ing)){
                    adjMap.put(ing, new ArrayList<>());
                }
                adjMap.get(ing).add(recipe);
            }
        }

        Queue<String> bfsQue = new ArrayDeque<>();
        for (String s : supplies){
            bfsQue.add(s);
        }

        List<String> result = new ArrayList<>();
        while (!bfsQue.isEmpty()) {
            String item = bfsQue.poll();
            if (adjMap.containsKey(item)){
                for (String recipe : adjMap.get(item)) {
                    indegree.put(recipe, indegree.get(recipe) - 1);
                    if (indegree.get(recipe) == 0) {
                        result.add(recipe);
                        bfsQue.add(recipe);
                    }
                }
            }
        }
        return result;
    }
}

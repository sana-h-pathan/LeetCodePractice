class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String, List<String>> adjMap = new HashMap<>();
        HashMap<String, Integer> indegreeMap = new HashMap<>();
        for(int i=0;i<recipes.length;i++){
            indegreeMap.put(recipes[i], ingredients.get(i).size());
            for(String ing: ingredients.get(i)){
                if(!adjMap.containsKey(ing)){
                    adjMap.put(ing, new ArrayList<>());
                }
                adjMap.get(ing).add(recipes[i]);
            }
        }
        List<String> result = new ArrayList<>();
        Queue<String> bfsQue = new LinkedList<>();
        for(String s: supplies){
            bfsQue.add(s);
        }
        while(!bfsQue.isEmpty()){
            String currIngredient = bfsQue.poll();
            if(adjMap.containsKey(currIngredient)){
                for(String recipe: adjMap.get(currIngredient)){
                    indegreeMap.put(recipe, indegreeMap.getOrDefault(recipe, 0)-1);
                    if(indegreeMap.get(recipe)==0){
                        bfsQue.add(recipe);
                        result.add(recipe);
                    }
                }
            }
        }
        return result;
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,String> nameMap = new HashMap<>();
        HashMap<String, List<String>> adjMap = new HashMap<>();
        for(List<String> accList : accounts){
            String name = accList.get(0);
            String email = accList.get(1);
            for(int i=1;i<accList.size();i++){
                if(!adjMap.containsKey(email)){
                    adjMap.put(email, new ArrayList<>());
                }
                String accMail = accList.get(i);
                nameMap.put(accMail, name);
                if(!adjMap.containsKey(accMail)){
                    adjMap.put(accMail, new ArrayList<>());
                }
                if(!email.equals(accMail)){
                    adjMap.get(email).add(accMail);
                    adjMap.get(accMail).add(email);
                }
               
            }
        }
        List<List<String>> result = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        
        for(String acc: adjMap.keySet()){
            if(visited.contains(acc)){
                continue;
            }
            List<String> subList = new ArrayList<>();
            Queue<String> bfsQue = new LinkedList<>();
            bfsQue.add(acc);
            
            visited.add(acc);
            while(!bfsQue.isEmpty()){
                String curr = bfsQue.poll();
                subList.add(curr);
                if(adjMap.containsKey(curr)){
                    for(String mail : adjMap.get(curr)){
                        if(visited.contains(mail)){
                            continue;
                        }
                        bfsQue.add(mail);
                        visited.add(mail);
                    }
                }
            }
            String name = nameMap.get(subList.get(0));
            Collections.sort(subList);
            subList.add(0, name);
            result.add(subList);
        }

        return result;
    }
}
class FileSystem {
    class Node{
        boolean isFile;
        StringBuilder data=new StringBuilder();
        HashMap<String, Node> dirPath=new HashMap<>();
    }
    Node root;
    public FileSystem() {
        this.root=new Node();
    }
    
    public List<String> ls(String path) {
        if(path.equals("/"))
            return listDir(root);
        String[] folders = splitPath(path);
        Node curr=root;
        for(String folder: folders){
            curr=curr.dirPath.get(folder);
            if (curr == null) {
                return new ArrayList<>();
            }
        }
        if(curr.isFile){
            return Arrays.asList(folders[folders.length-1]);
        }
        return listDir(curr);
    }
    
    public void mkdir(String path) {
        String[] folders = splitPath(path);
        Node curr=root;
        for(String folder: folders){
            if(!curr.dirPath.containsKey(folder))
                curr.dirPath.put(folder, new Node());
            curr=curr.dirPath.get(folder);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] folders = splitPath(filePath);
        Node curr=root;
        for(String folder: folders){
            if(!curr.dirPath.containsKey(folder))
                curr.dirPath.put(folder, new Node());
            curr=curr.dirPath.get(folder);
        }
        curr.isFile=true;
        curr.data.append(content);
        
    }
    
    public String readContentFromFile(String filePath) {
        String[] folders = splitPath(filePath);
        Node curr=root;
        for(String folder: folders){
            curr=curr.dirPath.get(folder);
        }
        return curr.data.toString();
    }
    private String[] splitPath(String path) {
        // Remove leading "/" and split, ignore empty pieces
        String p = path;
        if (p.startsWith("/")) {
            p = p.substring(1);
        }
        return p.isEmpty() ? new String[0] : p.split("/");
    }

    private List<String> listDir(Node dir) {
        List<String> result = new ArrayList<>();
        for(String key: dir.dirPath.keySet())
            result.add(key);
         Collections.sort(result); 
        return result;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
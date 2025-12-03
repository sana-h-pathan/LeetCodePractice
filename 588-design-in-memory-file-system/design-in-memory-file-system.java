class FileSystem {
    private static class Node {
        boolean isFile;
        Map<String, Node> children = new HashMap<>();
        StringBuilder content = new StringBuilder();
    }
    private final Node root;

    public FileSystem() {
        this.root = new Node();
    }
    
    public List<String> ls(String path) {
        if (path.equals("/")) {
            return listDir(root);
        }

        String[] parts = splitPath(path);
        Node curr = root;

        for (int i = 0; i < parts.length; i++) {
            String name = parts[i];
            curr = curr.children.get(name);
            if (curr == null) {
                // In many interview versions, you can assume path is valid.
                return Collections.emptyList();
            }
        }

        if (curr.isFile) {
            // For a file, return just its name (last part of path)
            return Collections.singletonList(parts[parts.length - 1]);
        } else {
            return listDir(curr);
        }
    }
    
    public void mkdir(String path) {
        
        String[] parts = splitPath(path);
        Node curr = root;

        for (String name : parts) {
            curr.children.putIfAbsent(name, new Node());
            curr = curr.children.get(name);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] parts = splitPath(filePath);
        Node curr = root;

        // walk / create intermediate dirs
        for (int i = 0; i < parts.length; i++) {
            String name = parts[i];
            curr.children.putIfAbsent(name, new Node());
            curr = curr.children.get(name);
        }

        // last node is file
        curr.isFile = true;
        curr.content.append(content);
    }
    
    public String readContentFromFile(String filePath) {
        String[] parts = splitPath(filePath);
        Node curr = root;

        for (String name : parts) {
            curr = curr.children.get(name);
        }
        return curr.content.toString();
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
        List<String> result = new ArrayList<>(dir.children.keySet());
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
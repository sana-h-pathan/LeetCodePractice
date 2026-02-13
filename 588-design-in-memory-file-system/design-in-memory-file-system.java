class FileSystem {

    class Node {
        boolean isFile = false;
        StringBuilder content = new StringBuilder();
        Map<String, Node> children = new HashMap<>();
    }

    Node root = new Node();

    public List<String> ls(String path) {
        Node node = getNode(path);

        if (node.isFile) {
            String[] parts = split(path);
            return Arrays.asList(parts[parts.length - 1]);
        }

        List<String> result = new ArrayList<>(node.children.keySet());
        Collections.sort(result);
        return result;
    }

    public void mkdir(String path) {
        createPath(path);
    }

    public void addContentToFile(String filePath, String content) {
        Node node = createPath(filePath);
        node.isFile = true;
        node.content.append(content);
    }

    public String readContentFromFile(String filePath) {
        return getNode(filePath).content.toString();
    }

    // Returns node, creates if missing
    private Node createPath(String path) {
        Node node = root;
        for (String part : split(path)) {
            node.children.putIfAbsent(part, new Node());
            node = node.children.get(part);
        }
        return node;
    }

    // Returns node, assumes it exists
    private Node getNode(String path) {
        Node node = root;
        for (String part : split(path)) {
            node = node.children.get(part);
        }
        return node;
    }

    private String[] split(String path) {
        if (path.equals("/")) return new String[0];
        return path.substring(1).split("/");
    }
}

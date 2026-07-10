class MaxStack {
    private Stack<int[]> stack;
    private Queue<int[]> heap;
    private Set<Integer> removed;
    private int cnt;

    public MaxStack() {
        stack = new Stack<>();
        heap = new PriorityQueue<>((a, b) -> b[0] - a[0] == 0 ? b[1] - a[1] : b[0] - a[0]);
        removed = new HashSet<>();
    }

    public void push(int x) {
        stack.add(new int[] { x, cnt });
        heap.add(new int[] { x, cnt });
        cnt++;
    }

    public int pop() {
        removeStaleFromStk();
        int[] top = stack.pop();
        removed.add(top[1]);
        return top[0];
    }

    public int top() {
        removeStaleFromStk();
        return stack.peek()[0];
    }

    public int peekMax() {
        removeStaleFromHeap();
        return heap.peek()[0];

    }

    public int popMax() {
        removeStaleFromHeap();
        int[] top = heap.poll();
        removed.add(top[1]);
        return top[0];
    }

    private void removeStaleFromHeap(){
        while (removed.contains(heap.peek()[1])) {
            heap.poll();
        }
    }
    private void removeStaleFromStk(){
        while (removed.contains(stack.peek()[1])) {
            stack.pop();
        }
    }
}
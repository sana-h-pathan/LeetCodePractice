package practice.medium;

import java.util.Stack;

public class QueImplementation {
    Stack<Integer> inputStack;
    Stack<Integer> reverseStack;

    public QueImplementation() {
        inputStack=new Stack<>();
        reverseStack=new Stack<>();
    }

    public void push(int x) {
        inputStack.push(x);
    }

    public int pop() {
        peek();
        return reverseStack.pop();
    }

    public int peek() {
        if (reverseStack.empty())
            while (!inputStack.empty())
                reverseStack.push(inputStack.pop());
        return reverseStack.peek();
    }

    public boolean empty() {
        return inputStack.empty() && reverseStack.empty();
    }

    public static void main(String[] args) {
        QueImplementation queImplementation=new QueImplementation();
        queImplementation.push(1);
        queImplementation.push(2);
        queImplementation.peek();
        queImplementation.pop();
        queImplementation.empty();
    }
}

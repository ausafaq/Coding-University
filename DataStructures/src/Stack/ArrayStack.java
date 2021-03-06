package Stack;

import java.util.EmptyStackException;

public class ArrayStack {

    private int[] stack;
    private int top;

    public ArrayStack(int capacity) {
        stack = new int[capacity];
        top = -1;
    }

    public void push(int value) {
        if(top == stack.length) {
            // need to resize the array
            int[] newStack = new int[2*stack.length];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        } else {
            stack[++top] = value;
        }
    }

    public int pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stack[top--];
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stack[top];
        }
    }

    public void printStack(){
        for(int i = top; i > -1; i--) {
            System.out.println(stack[i] + ",");
        }
    }

    public static void main(String[] args) {
        ArrayStack myStack = new ArrayStack(10);

        myStack.push(10);
        myStack.push(20);
        myStack.push(5);
        myStack.push(17);
        myStack.push(80);

        myStack.printStack();

        System.out.println("\nTop Element: " + myStack.peek());
        System.out.println("\nPopped element: " + myStack.pop());
    }
}

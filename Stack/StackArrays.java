package Stack;

public class StackArrays {
    int [] arr;
    int topOfStack;

    public StackArrays(int size){
        this.arr = new int[size];
        this.topOfStack = -1;
        System.out.println("The stack is created with a size of: " + size);
    }
    //Check if it is empty

    public boolean isEmpty(){
        if (topOfStack == -1){
            System.out.println("Stack is empty");
            return true;
        } else {
            System.out.println("Stack is not empty");
            return false;
        }
    }

    //check if stack is Full
    public boolean isFull(){
        if (topOfStack == arr.length -1){
            System.out.println("Stack is full");
            return true;
        } else {
            System.out.println("Stack is not full");
            return false;
        }
    }

    //implement a push method
    public void push(int value){
        if (isFull()){
            System.out.println("the stack is full");
        } else {
            arr[topOfStack + 1] = value;
            topOfStack++;
            System.out.println("The value is successfully inserted");
        }
    }

    // 1. implement pop method
    public void pop() {
        if (topOfStack == -1) {
            System.out.println("The stack is empty");
        } else {
            topOfStack--;
            System.out.println("Value '" + arr[topOfStack + 1] + "' has been removed from the top of the stack.");
        }
    }

    // 2. implement peek
    public void peek() {
       if (topOfStack == -1) {
           System.out.println("The stack is empty");
       } else {
           System.out.println("The value at the top of the stack is '" + arr[topOfStack] + "'");
       }
    }

    // 3. implement delete a stack
    public void delete() {
        // This does not remove the values from memory, but makes them inaccessible.
        topOfStack = -1;
    }
}
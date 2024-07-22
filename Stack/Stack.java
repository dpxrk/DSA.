
public class Stack {

	// LIFO : Last in First Out
	
	// push, pop, peek, isStackEmpty, isStackFull, etc..
	
	
	public int stackSize;
	public int[] stackArray; // Where to store elements.
	public int top; //peek uses this top pointer.
	
	
	public Stack( int size) {
		this.stackSize = size;
		this.stackArray = new int[stackSize];
		this.top = -1;
	}
	
	
	public boolean isStackFull () {
		return (top == stackSize -1);
	}
	
	public boolean isStackEmpty() {
		return (top == -1);
	}
	
	public void push(int entry) throws Exception{
		if (this.isStackFull()) {
			throw new Exception ("Stack is already full. Can't add element");
		}
		System.out.println("Adding element: " + entry);
		this.stackArray[++top] = entry;
	}
	
	public int pop() throws Exception{
		if (this.isStackEmpty()) {
			throw new Exception("Stack is empty");
		}
		System.out.println("Popping off the stack");
		int entry = this.stackArray[top--];
		System.out.println("Removed entry: " + entry);
		return entry;
	}
	
	public int peek() {
		return stackArray[top];
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack(5);
		try {
			stack.push(4);
			stack.push(8);
			stack.push(3);
			stack.push(21);
//			System.out.println(stack.peek());
			int top = stack.pop();
			System.out.println("this is the top:" + top);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

	}

}
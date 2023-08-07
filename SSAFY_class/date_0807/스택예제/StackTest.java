package date_0807;

public class StackTest {
	
	public static void main(String[] args) {
		
		IStack<String> stack = new Stack<>();
		
		System.out.println(stack.size() +"//" + stack.isEmpty());
		
		stack.push("서다찬");
		stack.push("전은희");
		stack.push("류현진");
		stack.push("성준혁");
		stack.push("상진팍");

		System.out.println(stack.peek());
		System.out.println(stack.size() +"//" + stack.isEmpty());

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println(stack.size() +"//" + stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
	}

}

package date_0807;

import java.util.EmptyStackException;

public class Stack<T> implements IStack<T> {

	private Node<T> top = null;

	@Override
	public void push(T t) {
		top = new Node<>(t, top);
	}

	@Override
	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}

		Node<T> popNode = top;
		top = popNode.getLink();
		popNode.setLink(null);
		return popNode.getData();
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}

		return top.getData();
	}

	@Override
	public int size() {
		int size = 0;

		for (Node<T> tmp = top; tmp != null; tmp = tmp.getLink()) {
			size++;
		}
		return size;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

}

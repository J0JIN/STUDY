package date_0807;

public interface IStack<T> {
	void push(T t);
	T pop();
	T peek();
	int size();
	boolean isEmpty();
}

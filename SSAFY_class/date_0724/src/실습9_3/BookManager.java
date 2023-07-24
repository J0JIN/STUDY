package �ǽ�9_3;

import java.awt.List;
import java.util.ArrayList;
import java.util.Stack;

public class BookManager implements IBookManager {
	/**
	 * ������ �ִ� ���� ��
	 */
	private static int MAX_SIZE = 100;

	private static int size = 0;
	/**
	 * ������ ���� ����Ʈ
	 */
	private ArrayList<Book> books = new ArrayList<Book>(MAX_SIZE);

	/**
	 * ������ ��������Ʈ�� �߰��Ѵ�.
	 *
	 * @param book : �߰��� ����
	 */
	public void add(Book book) {
		books.add(book);
		size++;
	}

	/**
	 * ������ȣ�� �ش� ������ ��������Ʈ���� �����Ѵ�.
	 *
	 * @param isbn : ������ ������ ������ȣ
	 */
	public void remove(String isbn) {
		for (int i = 0; i < MAX_SIZE; i++) {
			if (books.get(i).getIsbn().equals(isbn)) {
				books.remove(i);
				size--;
			}
		}
	}

	/**
	 * ��ϵ� ��������Ʈ�� ��ȯ�Ѵ�.
	 *
	 * @return ��ϵ� ��ü ��������Ʈ
	 */
	public ArrayList<Book> getList() {
		return books;
	}

	/**
	 * ��ϵ� �Ϲ� ���� ����Ʈ�� ��ȯ�Ѵ�.
	 *
	 * @return ��ϵ� �Ϲ� ��������Ʈ
	 */
	public ArrayList<Book> getBooks() {
		ArrayList<Book> listBook = new ArrayList<Book>();
		for (int i = 0; i < size; i++) {
			if (books.get(i) != null && !(books.get(i) instanceof Magazine)) {
				listBook.add(books.get(i));
			}
		}
		return listBook;
	}

	/**
	 * ��ϵ� �Ű�������Ʈ�� ��ȯ�Ѵ�.
	 *
	 * @return ��ϵ� �Ű��� ����Ʈ
	 */
	public ArrayList<Magazine> getMagazines() {
		ArrayList<Magazine> listMagazine = new ArrayList<Magazine>();
		int count = 0;
		for (int i = 0; i < size; i++) {
			if ((books.get(i) != null && books.get(i) instanceof Magazine)) {
				listMagazine.add((Magazine) books.get(i));
				count++;
			}
		}
		return listMagazine;
	}

	/**
	 * ������ȣ�� �ش� ������ ��ȸ�Ѵ�.
	 *
	 * @param isbn : ��ȸ�� ������ ������ȣ
	 * @return ������ȣ�� �ش��ϴ� ����
	 */
	public ArrayList<Book> searchByIsbn(String isbn) throws ISBNNotFoundException{
		ArrayList<Book> listBook = new ArrayList<Book>();
		
		for (int i = 0; i < size; i++) {
			if (books.get(i).getIsbn().equals(isbn)) {
				listBook.add(books.get(i));
				return listBook;
			}
		}
		throw new ISBNNotFoundException(isbn);
	}

	/**
	 * ������ȣ�� �ش� ������ ��ȸ�Ѵ�.
	 *
	 * @param isbn : ��ȸ�� ������ ������ȣ
	 * @return ������ȣ�� �ش��ϴ� ����
	 */
	public ArrayList<Book> searchByTitle(String title) {
		ArrayList<Book> listBook = new ArrayList<Book>();
		for (int i = 0; i < size; i++) {
			if (books.get(i).getTitle().contains(title)) {
				listBook.add(books.get(i));
			}
		}
		return listBook;
	}

	public int getTotalPrice() {
		int total = 0;
		for (int i = 0; i < size; i++) {
			total += books.get(i).getPrice();
		}
		return total;
	}

	/**
	 * ���������� ����� ��ȯ�Ѵ�.
	 *
	 * @return ��� ���� ������ ���
	 */
	public double getPriceAvg() {
		return (double) getTotalPrice() / size;
	}

	public void sell(String isbn, int quantity) throws QuantityException {
		for (int i = 0; i < size; i++) {
			if (books.get(i).getIsbn().equals(isbn)) {
				if((books.get(i).getQuantity() - quantity) <0) {
					throw new QuantityException();
				}
				books.get(i).setQuantity(books.get(i).getQuantity() - quantity);
				System.out.println(books.get(i));
			}
		}
	}

	public void buy(String isbn, int quantity) {
		for (int i = 0; i < size; i++) {
			if (books.get(i).getIsbn().equals(isbn)) {
				books.get(i).setQuantity(books.get(i).getQuantity() + quantity);
				System.out.println(books.get(i));
			}
		}
	}

}

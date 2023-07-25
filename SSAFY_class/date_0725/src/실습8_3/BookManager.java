package �ǽ�8_3;

import java.awt.List;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import �ǽ�8_3.ISBNNotFoundException;

public class BookManager implements IBookManager {
	/**
	 * ������ �ִ� ���� ��
	 */
	private static int MAX_SIZE = 100;

	private static int size = 0;
	/**
	 * ������ ���� ����Ʈ
	 */
	private HashMap<String, Book> books = new HashMap<String, Book>();

	/**
	 * ������ ��������Ʈ�� �߰��Ѵ�.
	 *
	 * @param book : �߰��� ����
	 */
	public void add(Book book) {
		books.put(book.getIsbn(), book);
	}

	/**
	 * ������ȣ�� �ش� ������ ��������Ʈ���� �����Ѵ�.
	 *
	 * @param isbn : ������ ������ ������ȣ
	 */
	public void remove(String isbn) {
		books.remove(isbn);
	}

	/**
	 * ��ϵ� ��������Ʈ�� ��ȯ�Ѵ�.
	 *
	 * @return ��ϵ� ��ü ��������Ʈ
	 */
	public HashMap<String, Book> getList() {
		return books;
	}

	/**
	 * ��ϵ� �Ϲ� ���� ����Ʈ�� ��ȯ�Ѵ�.
	 *
	 * @return ��ϵ� �Ϲ� ��������Ʈ
	 */
	public HashMap<String, Book> getBooks() {
		HashMap<String, Book> listBook = new HashMap<String, Book>();
		
		Set set = books.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			if(!(books.get(e.getKey()) instanceof Magazine)) {
				listBook.put((String)e.getKey(), books.get(e.getKey()));
			}
		}
		
		return listBook;
	}

	/**
	 * ��ϵ� �Ű�������Ʈ�� ��ȯ�Ѵ�.
	 *
	 * @return ��ϵ� �Ű��� ����Ʈ
	 */
	public HashMap<String, Book> getMagazines() {
		HashMap<String, Book> listMagazine = new HashMap<String, Book>();
		
		Set set = books.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			if((books.get(e.getKey()) instanceof Magazine)) {
				listMagazine.put((String)e.getKey(), books.get(e.getKey()));
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
	public HashMap<String, Book> searchByIsbn(String isbn) throws ISBNNotFoundException{
		HashMap<String, Book> listBook = new HashMap<String, Book>();
		
		Set set = books.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			if(e.getKey().equals(isbn)) {
				listBook.put((String)e.getKey(), books.get(e.getKey()));
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
	public HashMap<String, Book> searchByTitle(String title) {
		HashMap<String, Book> listBook = new HashMap<String, Book>();
		
		Set set = books.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			if((books.get(e.getKey()).getTitle().contains(title))) {
				listBook.put((String)e.getKey(), books.get(e.getKey()));
			}
		}
		return listBook;
	}

	public int getTotalPrice() {
		int total = 0;
		
		Set set = books.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			total += books.get(e.getKey()).getPrice();
		}
		
		return total;
	}

	/**
	 * ���������� ����� ��ȯ�Ѵ�.
	 *
	 * @return ��� ���� ������ ���
	 */
	public double getPriceAvg() {
		return (double) getTotalPrice() / books.size();
	}

	public void sell(String isbn, int quantity) throws QuantityException {
		Set set = books.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			if(books.get(e.getKey()).getIsbn().equals(isbn)) {
				if((books.get(e.getKey()).getQuantity() - quantity) <0) {
					throw new QuantityException();
				}
				books.get(e.getKey()).setQuantity(books.get(e.getKey()).getQuantity() - quantity);
				System.out.println(books.get(e.getKey()));
			}
		}
		
	}

	public void buy(String isbn, int quantity) {
		Set set = books.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			if(books.get(e.getKey()).getIsbn().equals(isbn)) {
				books.get(e.getKey()).setQuantity(books.get(e.getKey()).getQuantity() + quantity);
				System.out.println(books.get(e.getKey()));
			}
		}
		
	}

}

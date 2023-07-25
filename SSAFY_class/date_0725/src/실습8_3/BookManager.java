package 실습8_3;

import java.awt.List;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import 실습8_3.ISBNNotFoundException;

public class BookManager implements IBookManager {
	/**
	 * 관리할 최대 도서 수
	 */
	private static int MAX_SIZE = 100;

	private static int size = 0;
	/**
	 * 관리할 도서 리스트
	 */
	private HashMap<String, Book> books = new HashMap<String, Book>();

	/**
	 * 도서를 도서리스트에 추가한다.
	 *
	 * @param book : 추가할 도서
	 */
	public void add(Book book) {
		books.put(book.getIsbn(), book);
	}

	/**
	 * 고유번호로 해당 도서를 도서리스트에서 삭제한다.
	 *
	 * @param isbn : 삭제할 도서의 고유번호
	 */
	public void remove(String isbn) {
		books.remove(isbn);
	}

	/**
	 * 등록된 도서리스트를 반환한다.
	 *
	 * @return 등록된 전체 도서리스트
	 */
	public HashMap<String, Book> getList() {
		return books;
	}

	/**
	 * 등록된 일반 도서 리스트를 반환한다.
	 *
	 * @return 등록된 일반 도서리스트
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
	 * 등록된 매거진리스트를 반환한다.
	 *
	 * @return 등록된 매거진 리스트
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
	 * 고유번호로 해당 도서를 조회한다.
	 *
	 * @param isbn : 조회할 도서의 고유번호
	 * @return 고유번호에 해당하는 도서
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
	 * 고유번호로 해당 도서를 조회한다.
	 *
	 * @param isbn : 조회할 도서의 고유번호
	 * @return 고유번호에 해당하는 도서
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
	 * 도서가격의 평균을 반환한다.
	 *
	 * @return 모든 도서 가격의 평균
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

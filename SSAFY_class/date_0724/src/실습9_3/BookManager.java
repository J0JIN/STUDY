package 실습9_3;

import java.awt.List;
import java.util.ArrayList;
import java.util.Stack;

public class BookManager implements IBookManager {
	/**
	 * 관리할 최대 도서 수
	 */
	private static int MAX_SIZE = 100;

	private static int size = 0;
	/**
	 * 관리할 도서 리스트
	 */
	private ArrayList<Book> books = new ArrayList<Book>(MAX_SIZE);

	/**
	 * 도서를 도서리스트에 추가한다.
	 *
	 * @param book : 추가할 도서
	 */
	public void add(Book book) {
		books.add(book);
		size++;
	}

	/**
	 * 고유번호로 해당 도서를 도서리스트에서 삭제한다.
	 *
	 * @param isbn : 삭제할 도서의 고유번호
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
	 * 등록된 도서리스트를 반환한다.
	 *
	 * @return 등록된 전체 도서리스트
	 */
	public ArrayList<Book> getList() {
		return books;
	}

	/**
	 * 등록된 일반 도서 리스트를 반환한다.
	 *
	 * @return 등록된 일반 도서리스트
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
	 * 등록된 매거진리스트를 반환한다.
	 *
	 * @return 등록된 매거진 리스트
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
	 * 고유번호로 해당 도서를 조회한다.
	 *
	 * @param isbn : 조회할 도서의 고유번호
	 * @return 고유번호에 해당하는 도서
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
	 * 고유번호로 해당 도서를 조회한다.
	 *
	 * @param isbn : 조회할 도서의 고유번호
	 * @return 고유번호에 해당하는 도서
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
	 * 도서가격의 평균을 반환한다.
	 *
	 * @return 모든 도서 가격의 평균
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

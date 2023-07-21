package src.실습5_3;

import java.util.Stack;

public class BookManager {
	/**
	 * 관리할 최대 도서 수
	 */
	private static int MAX_SIZE = 100;
	/**
	 * 관리할 도서 리스트
	 */
	private Book[] books = new Book[MAX_SIZE];
	/**
	 * 현재 등록된 도서 수
	 */
	private int size = 0;

	/**
	 * 도서를 도서리스트에 추가한다.
	 * 
	 * @param book : 추가할 도서
	 */
	public void add(Book book) {
		books[size] = book;
		size++;
	}

	/**
	 * 고유번호로 해당 도서를 도서리스트에서 삭제한다.
	 * 
	 * @param isbn : 삭제할 도서의 고유번호
	 */
	public void remove(String isbn) {
		for (int i = 0; i < MAX_SIZE; i++) {
			if(books[i] != null) {
				if (books[i].getIsbn().equals(isbn)) {
					books[i] = null;//new Book();
					size--;
				}
			}
		}
	}

	/**
	 * 등록된 도서리스트를 반환한다.
	 * 
	 * @return 등록된 전체 도서리스트
	 */
	public Book[] getList() {
		Book[] listBook = new Book[size];
		int count = 0;
		for(int i = 0; i < MAX_SIZE; i++) {
			if(books[i] != null) {
				listBook[count] = books[i];
				count++;
			}
		}
		return listBook;
	}

	/**
	 * 고유번호로 해당 도서를 조회한다.
	 * 
	 * @param isbn : 조회할 도서의 고유번호
	 * @return 고유번호에 해당하는 도서
	 */
	public Book searchByIsbn(String isbn) {
		for (int i = 0; i < MAX_SIZE; i++) {
			if (books[i].getIsbn().equals(isbn)) {
				return books[i];
			}
		}
		return null;
	}

}
package 실습8_3;

import java.util.ArrayList;
import java.util.HashMap;

public interface IBookManager {
	void add(Book book);

	void remove(String isbn);

	HashMap<String, Book> getList();

	HashMap<String, Book> searchByIsbn(String isbn) throws ISBNNotFoundException;

	HashMap<String, Book> searchByTitle(String title);

	HashMap<String, Book> getMagazines();

	HashMap<String, Book> getBooks();

	int getTotalPrice();

	double getPriceAvg();
}

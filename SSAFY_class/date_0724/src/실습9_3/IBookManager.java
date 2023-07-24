package ½Ç½À9_3;

import java.util.ArrayList;

public interface IBookManager {
	void add(Book book);

	void remove(String isbn);

	ArrayList<Book> getList();

	ArrayList<Book> searchByIsbn(String isbn) throws ISBNNotFoundException;

	ArrayList<Book> searchByTitle(String title);

	ArrayList<Magazine> getMagazines();

	ArrayList<Book> getBooks();

	int getTotalPrice();

	double getPriceAvg();
}

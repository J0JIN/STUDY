package 실습7_3;

import java.util.Stack;

public class BookManager implements IBookManager {
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
    private int size_book = 0;
    private int size_magazine = 0;

    /**
     * 도서를 도서리스트에 추가한다.
     *
     * @param book : 추가할 도서
     */
    public void add(Book book) {
        books[size_book + size_magazine] = book;
        if (!(book instanceof Magazine)) {
            size_book++;
        }
        if (book instanceof Magazine) {
            size_magazine++;
        }
    }

    /**
     * 고유번호로 해당 도서를 도서리스트에서 삭제한다.
     *
     * @param isbn : 삭제할 도서의 고유번호
     */
    public void remove(String isbn) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (books[i] != null) {
                if (books[i].getIsbn().equals(isbn)) {
                    books[i] = null;//new Book();
                    if (books[i] instanceof Book) {
                        size_book--;
                    }
                    if (books[i] instanceof Magazine) {
                        size_magazine--;
                    }
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
        Book[] listBook = new Book[size_book + size_magazine];
        int count = 0;
        for (int i = 0; i < MAX_SIZE; i++) {
            if (books[i] != null) {
                listBook[count] = books[i];
                count++;
            }
        }
        return listBook;
    }

    /**
     * 등록된 일반 도서 리스트를 반환한다.
     *
     * @return 등록된 일반 도서리스트
     */
    public Book[] getBooks() {
        Book[] listBook = new Book[size_book];
        int count = 0;
        for (int i = 0; i < MAX_SIZE; i++) {
            if (books[i] != null && !(books[i] instanceof Magazine)) {
                listBook[count] = books[i];
                count++;
            }
        }
        return listBook;
    }

    /**
     * 등록된 도서리스트를 반환한다.
     *
     * @return 등록된 전체 도서리스트
     */
    public Magazine[] getMagazines() {
        Magazine[] listMagazine = new Magazine[size_magazine];
        int count = 0;
        for (int i = 0; i < MAX_SIZE; i++) {
            if (books[i] != null && books[i] instanceof Magazine) {
                listMagazine[count] = (Magazine) books[i];
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
    public Book searchByIsbn(String isbn) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                return books[i];
            }
        }
        return null;
    }

    /**
     * 고유번호로 해당 도서를 조회한다.
     *
     * @param isbn : 조회할 도서의 고유번호
     * @return 고유번호에 해당하는 도서
     */
    public Book[] searchByTitle(String title) {
        int count = 0;
        for (int i = 0; i < size_book + size_magazine; i++) {
            if (books[i].getTitle().contains(title)) {
                count++;
            }
        }
        Book[] result = new Book[count];

        count = 0;
        for (int i = 0; i < size_book + size_magazine; i++) {
            if (books[i].getTitle().contains(title)) {
                result[count] = books[i];
                count++;
            }
        }

        return result;
    }

    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < size_book + size_magazine; i++) {
            total += books[i].getPrice();
        }
        return total;
    }

    /**
     * 도서가격의 평균을 반환한다.
     *
     * @return 모든 도서 가격의 평균
     */
    public double getPriceAvg() {
        return (double) getTotalPrice() / (size_book + size_magazine);
    }

}

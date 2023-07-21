package src.실습5_3;

public class BookTest {

	public static void main(String[] args) {
		
		// 도서 리스트를 유지하고 관리하는 BookManager 객체를 생성한다.
		BookManager bookManager = new BookManager();
		// BookManager 객체를 이용해  도서정보를 추가한다.
		bookManager.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법"));
		bookManager.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용"));
		bookManager.add(new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링"));

		// BookManager 객체를 이용해  도서리스트를 조회한다.
		System.out.println("**********************도서목록**********************");
		for (Book book : bookManager.getList()) {
			System.out.println(book);
		}
		
		// BookManager 객체를 이용해  고유번호로 도서를 조회한다.
		System.out.println("**********************도서조회:21424**********************");
		System.out.println(bookManager.searchByIsbn("21424"));
		// BookManager 객체를 이용해  고유번호로 도서를 삭제한다.
		System.out.println("**********************도서삭제:21424**********************");
		bookManager.remove("21424");
		// BookManager 객체를 이용해  도서리스트를 조회한다.
		System.out.println("**********************도서목록**********************");
		for (Book book : bookManager.getList()) {
			System.out.println(book);
		}			
	}
}

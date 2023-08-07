package 실습8_3;

import java.util.Iterator;

public class BookTest {

	public static void main(String[] args) {

		// 도서 리스트를 유지하고 관리하는 BookManager 객체를 생성한다.
		BookManager bookManager = new BookManager();
		// BookManager 객체를 이용해 도서정보를 추가한다.
		bookManager.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법", 10));
		bookManager.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용", 20));
		bookManager.add(new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링", 30));
		bookManager.add(new Magazine("45678", "월간알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 40, 2021, 1));

		// BookManager 객체를 이용해 도서리스트를 조회한다.
		System.out.println("**********************전체도서목록**********************");
		System.out.println(bookManager.getList());
		System.out.println("**********************일반도서목록**********************");
		System.out.println(bookManager.getBooks());
		System.out.println("**********************매거진목록**********************");
		System.out.println(bookManager.getMagazines());
		System.out.println("**********************도서 제목 포함 검색 : Java**********************");
		System.out.println(bookManager.searchByTitle("Java"));
		
		System.out.println("**********************ISBN 검색 : 21000**********************");
		try {
			System.out.println(bookManager.searchByIsbn("21000"));
		} catch(ISBNNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("도서 가격 총합 : " + bookManager.getTotalPrice());
		System.out.println("도서 가격 평균: " + bookManager.getPriceAvg());
		System.out.println("**********************도서판매:21424,11개**********************");
		try {
		bookManager.sell("21424", 11);
		}catch(QuantityException e) {
			System.out.println(e.getMessage());
//			e.printStackTrace();
		}
		System.out.println("**********************도서구매:21424,10개**********************");
		bookManager.buy("21424", 10);
		System.out.println("**********************도서판매:21424,11개**********************");
		try {
		bookManager.sell("21424", 11);
		}catch(QuantityException e) {
//			e.printStackTrace();
		}
	}
}

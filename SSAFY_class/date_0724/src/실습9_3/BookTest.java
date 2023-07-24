package �ǽ�9_3;

import java.util.Iterator;

public class BookTest {

	public static void main(String[] args) {

		// ���� ����Ʈ�� �����ϰ� �����ϴ� BookManager ��ü�� �����Ѵ�.
		BookManager bookManager = new BookManager();
		// BookManager ��ü�� �̿��� ���������� �߰��Ѵ�.
		bookManager.add(new Book("21424", "Java Pro", "���ϳ�", "jaen.kr", 15000, "Java �⺻ ����", 10));
		bookManager.add(new Book("21425", "Java Pro2", "���ϳ�", "jaen.kr", 25000, "Java ����", 20));
		bookManager.add(new Book("35355", "�м�����", "�ҳ���", "jaen.kr", 30000, "SW �𵨸�", 30));
		bookManager.add(new Magazine("45678", "�����˰���", "ȫ�浿", "jaen.kr", 10000, "1�� �˰���", 40, 2021, 1));

		// BookManager ��ü�� �̿��� ��������Ʈ�� ��ȸ�Ѵ�.
		System.out.println("**********************��ü�������**********************");
		for (Book book : bookManager.getList()) {
			System.out.println(book);
		}
		System.out.println("**********************�Ϲݵ������**********************");
		Iterator<Book> iterator = bookManager.getBooks().iterator();
		while (iterator.hasNext()) {
			Book element = iterator.next();
			System.out.println(element);
		}
		System.out.println("**********************�Ű������**********************");
		for (Book book : bookManager.getMagazines()) {
			System.out.println(book);
		}

		System.out.println("**********************���� ���� ���� �˻� : Java**********************");
		for (Book book : bookManager.searchByTitle("Java")) {
			System.out.println(book);
		}
		
		System.out.println("**********************ISBN �˻� : 21000**********************");
		try {
		for (Book book : bookManager.searchByIsbn("21000")) {
			System.out.println(book);
		}
		} catch(ISBNNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("���� ���� ���� : " + bookManager.getTotalPrice());
		System.out.println("���� ���� ���: " + bookManager.getPriceAvg());
		System.out.println("**********************�����Ǹ�:21424,11��**********************");
		try {
		bookManager.sell("21424", 11);
		}catch(QuantityException e) {
			System.out.println(e.getMessage());
//			e.printStackTrace();
		}
		System.out.println("**********************��������:21424,10��**********************");
		bookManager.buy("21424", 10);
		System.out.println("**********************�����Ǹ�:21424,11��**********************");
		try {
		bookManager.sell("21424", 11);
		}catch(QuantityException e) {
//			e.printStackTrace();
		}
	}
}

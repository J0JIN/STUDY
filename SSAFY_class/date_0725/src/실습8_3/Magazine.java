package �ǽ�8_3;

public class Magazine extends Book{
	private int year;
	private int month;
	
	public Magazine() {
	}
	
	public Magazine(String isbn, String title, String author, String publisher, int price, String desc,int quantity, int year, int month) {
		// ���� ������ ��ü�� ���¸� �ʱ�ȭ�Ѵ�.
		super(isbn, title, author, publisher, price, desc, quantity);
		this.month = month;
		this.year = year;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public String toString() {
		return super.getIsbn() + '\t' + "| " + super.getTitle() + "  \t" + "| " + super.getAuthor() + '\t' + "| " + super.getPublisher() + '\t' + "| " + super.getPrice()
				+ '\t' + "| " + super.getDesc() + '\t' + "| " + super.getQuantity()+ '\t' + "| " + this.getYear()+'\t' + "| " + this.getMonth();
	}
	
}

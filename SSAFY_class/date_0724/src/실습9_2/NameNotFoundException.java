package �ǽ�9_2;

// ����� ���� ���� Ŭ����
public class NameNotFoundException extends Exception {
	
	private String name;
	
	public NameNotFoundException(String name) {
		// ���� �߻��� �ֿܼ� ��µ� �޽��� �ۼ�
		super(name + " �̸��� �����ϴ� ����ڰ� �������� �ʽ��ϴ�.");
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}

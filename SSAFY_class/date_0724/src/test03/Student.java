package test03;

public class Student {
	private String name;
	private int score;
	
	public void SetName(String name) {
		this.name=name;
	}
	public void SetScore(int score) {
		this.score = score;
	}
	
	public void printInfo() throws SoSadException, RuntimeException{
		if(this.score<60) {
			throw new SoSadException("���� �� �߰�");
			
		}else if(this.score<0) {
			throw new RuntimeException("No minus");
		}
		System.out.println("�̸� : " +name +"\t ���� : " + score);
	}
}

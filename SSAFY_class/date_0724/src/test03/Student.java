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
			throw new SoSadException("좀만 덜 잘걸");
			
		}else if(this.score<0) {
			throw new RuntimeException("No minus");
		}
		System.out.println("이름 : " +name +"\t 성적 : " + score);
	}
}

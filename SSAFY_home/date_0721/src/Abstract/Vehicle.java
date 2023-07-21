package Abstract;

public class Vehicle {
	private int curX,curY;
	
	public void get_pos() {
		System.out.printf("차종: %s: 현재 위치: (%d, %d)%n", this.getClass().getSimpleName(), curX, curY);
	}
	
	public void add_fuel() {
		System.out.println("연료넣기");
	}

}

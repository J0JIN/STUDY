package Abstract;

import java.awt.DisplayMode;

public class VehicleTest {

	public static void main(String[] args) {

		Vehicle[] car = { new Electric(), new Diesel(), new Horse() };

		for (Vehicle v : car) {
			if (v instanceof Electric) {
				Electric casted = (Electric) v;
				casted.add_fuel();
			}
			
			if (v instanceof Horse) {
				Horse casted = (Horse) v;
				casted.add_fuel();
			}
			
			if (v instanceof Diesel) {
				Diesel casted = (Diesel) v;
				casted.add_fuel();
			}

			v.get_pos();
			System.out.println();

		}
	}

}

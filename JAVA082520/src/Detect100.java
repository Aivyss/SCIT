
public class Detect100 {

	public static void main(String[] args) {
		int count = 0;
		int absV = 1;
		int sum = 0;
		
		while (sum < 100) {
			if ((count+1)%2 == 0) {
				sum += absV;
				absV++;
				count++;
			} else {
				sum += absV*(-1);
				absV++;
				count++;
			}
		}
		System.out.println("Count = " + count);
	}

}

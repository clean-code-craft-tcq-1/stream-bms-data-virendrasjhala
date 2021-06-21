package battery;

import java.util.Scanner;

public class BatteryParamReceiverMain {
	
	public static void main(String a[]){
		try {
			new BatteryParamReceiver().readAndCompute(new Scanner(System.in));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

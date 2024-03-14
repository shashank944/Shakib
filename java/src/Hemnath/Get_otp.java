package Hemnath;

import java.util.ArrayList;
import java.util.List;

public class Get_otp {

	public static void main(String[] args) {
		String msg = "<#> 56376 is your OTP for Mobile number verification in ThinkRight.me App.Don't share it with anyone. phe/bwt1e6u";

		String otp = msg.substring(msg.indexOf(">") + 2, msg.indexOf(">") + 7);

		System.out.println(otp);

		List lst = new ArrayList();

		for (int i = 0; i < otp.length(); i++) {

			String x = String.valueOf(otp.charAt(i));

			lst.add(x);
			System.out.println(lst.get(i));

		}

	}

}

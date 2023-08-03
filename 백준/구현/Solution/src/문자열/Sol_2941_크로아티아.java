package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Sol_2941_크로아티아 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		int count = 0;

		String[] cro = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		for(int i = 0; i < cro.length;i++) {
			str = str.replace(cro[i], "1");
		}
		
		int strSize = str.length();
		
		System.out.println(strSize);

	}
}

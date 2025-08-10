import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] alphabet = new int[26];
		
		for (int i = 0; i < alphabet.length; i++) {
			alphabet[i] = -1;
		}
		
		String str = br.readLine();
		
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < 26; j++) {
				if (str.charAt(i) == 'a' + j) {
					if (alphabet[j] == -1) {
						alphabet[j] = i;
					}
				}
			}
		}
		
		for (int i = 0; i < alphabet.length; i++) {
			System.out.print(alphabet[i] + " ");
		}
	}
}
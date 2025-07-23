import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Person {
	int age;
	String name;
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public void print() {
		System.out.println(age + " " + name);
	}
}

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		ArrayList<Person> arr = new ArrayList<>();
		
		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr.add(new Person(Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		
		arr.sort((p1, p2) -> p1.age - p2.age);
		
		for(int i = 0; i < arr.size(); i++) {
			arr.get(i).print();
		}
	}
}

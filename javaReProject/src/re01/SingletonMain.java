package re01;

public class SingletonMain {

	public static void main(String[] args) {
		// Singleton 객체 생성
		Singleton s = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s == s2);
	}

}

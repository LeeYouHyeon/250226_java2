package re01;

import java.util.Scanner;

public class New02 {
	public static void main(String[] args) {
		// 숫자를 입력받아 1부터 입력한 수까지의 5의 배수 출력
		Scanner scan = new Scanner(System.in);
		while (true) {
			try {
				System.out.print("숫자를 입력해주세요.> ");
				int input = Integer.parseInt(scan.nextLine());
				if (input < 5)
					System.out.println("출력할 값이 없습니다.");
				for (int i = 5; i <= input; i += 5)
					System.out.println(i);
				break;
			} catch (Exception e) {
				System.out.println("숫자가 아닙니다.");
			}
		}

		scan.close();
	}
}

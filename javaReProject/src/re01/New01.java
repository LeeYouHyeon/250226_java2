package re01;

public class New01 {
	public static void main(String[] args) {
//		홍길동 주민등록번호 : 881122-1234567
//		출력형태 =>
//		생년월일 : 881122
//		성별 : 남
		String pin = "881122-1234567";
		String[] splited = pin.split("-");
		System.out.println("생년월일 : " + splited[0]);
		System.out.println("성별 : " + (splited[1].charAt(0) % 2 == 0 ? "여" : "남"));
	}
}

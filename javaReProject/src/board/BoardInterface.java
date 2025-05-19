package board;

import java.util.Scanner;

public interface BoardInterface {
	/*	게시판 프로그램
	 * 	1. 게시글 추가 | 2. 게시글 리스트 | 3. 게시글 상세 | 4. 게시글 수정 | 5. 게시글 삭제 | 6. 게시글 파일로 전송
	 * 	
	 * */
	void addBoard(Scanner scan);
	void printBoard();
	void searchBoard(Scanner scan);
	void modifyBoard(Scanner scan);
	void removeBoard(Scanner scan);
	void fileBoard();
}

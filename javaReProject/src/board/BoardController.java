package board;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BoardController implements BoardInterface {
	private ArrayList<Board> boards;
	
	public BoardController() {
		boards = new ArrayList<Board>();
	}
	
	public void printMenu() {
		System.out.println("---menu---");
		System.out.println("1. 게시글 추가 | 2. 게시글 리스트 | 3. 게시글 상세 ");
		System.out.println("4. 게시글 수정 | 5. 게시글 삭제 | 6. 게시글 파일로 전송");
		System.out.println("7. 종료");
		System.out.print("> ");
	}

	@Override
	public void addBoard(Scanner scan) {
		// TODO Auto-generated method stub
		String title = "";
		while(title.length() == 0) {
			System.out.print("제목 : ");
			title = scan.nextLine();
		}
		
		String writer = "";
		while (writer.length() == 0) {
			System.out.print("작성자 : ");
			writer = scan.nextLine();
		}
		
		System.out.println("내용 입력을 시작합니다. 종료하시려면 q를 입력해주세요.");
		String content = "";
		while (true) {
			System.out.print("> ");
			String line = scan.nextLine();
			if (line.toLowerCase().equals("q")) {
				System.out.print("입력을 종료하시려면 Y를 입력해주세요.> ");
				if (scan.nextLine().toLowerCase().equals("y")) break;
			}
			content += line + "\n";
		}
		
		boards.add(new Board(title, content, writer));
		System.out.println("글이 등록되었습니다.");
	}

	@Override
	public void printBoard() {
		// TODO Auto-generated method stub
		if (boards.size() == 0) {
			System.out.println("게시글이 없습니다.");
		}
		for (Board b : boards) {
			System.out.println(b);
		}
	}
	
	int getBoard(Scanner scan, String start) throws Exception {
		if (boards.isEmpty()) throw new Exception("게시글이 없습니다.");
		
		System.out.print(start + " 게시글 번호를 입력해주세요.> ");
		int num = Integer.parseInt(scan.nextLine());
		
		for(int i = 0; i < boards.size(); i++) {
			if (boards.get(i).getNum() == num) return i;
		}
		throw new Exception("없는 번호입니다.");
	}

	@Override
	public void searchBoard(Scanner scan) {
		// TODO Auto-generated method stub
		try {
			Board b = boards.get(getBoard(scan, "열람할"));
			System.out.println(b);
			System.out.println(b.getContent());
		} catch (NumberFormatException e) {
			System.out.println("잘못된 입력");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void modifyBoard(Scanner scan) {
		int b;
		try {
			b = getBoard(scan, "수정할");
		} catch (NumberFormatException e) {
			System.out.println("잘못된 입력");
			return;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		
		// TODO Auto-generated method stub
		String title = "";
		while(title.length() == 0) {
			System.out.print("제목 : ");
			title = scan.nextLine();
		}
		
		System.out.println("내용 입력을 시작합니다. 종료하시려면 q를 입력해주세요.");
		String content = "";
		while (true) {
			System.out.print("> ");
			String line = scan.nextLine();
			if (line.toLowerCase().equals("q")) {
				System.out.print("입력을 종료하시려면 Y를 입력해주세요.> ");
				if (scan.nextLine().toLowerCase().equals("y")) break;
			}
			content += line + "\n";
		}
		
		boards.get(b).setTitle(title);
		boards.get(b).setContent(content);
		System.out.println("수정되었습니다.");
	}

	@Override
	public void removeBoard(Scanner scan) {
		// TODO Auto-generated method stub
		int b;
		try {
			b = getBoard(scan, "삭제할");
			
			System.out.print("정말로 지우시겠습니까? 지우시려면 y를 입력해주세요.> ");
			if (scan.nextLine().toLowerCase().equals("y")) {
				boards.remove(b);
				System.out.println("삭제되었습니다.");
			} else {
				System.out.println("취소되었습니다.");
			}
		} catch (NumberFormatException e) {
			System.out.println("잘못된 입력");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void fileBoard() {
		if (boards.isEmpty()) {
			System.out.println("내보낼 글이 없습니다.");
			return;
		}
		
		int success = 0;
		ArrayList<Integer> errors = new ArrayList<Integer>();
		for (Board b : boards) {
			try {
				BufferedWriter fw = new BufferedWriter(new FileWriter(b.getNum() + ". " + b.getTitle()));
				fw.write(b.getContent());
				fw.write("작성자 : " + b.getWriter() + "\n");
				fw.write("작성일 : " + b.getRegDate());
				fw.flush();
				fw.close();
				success++;
			} catch (Exception e) {
				errors.add(b.getNum());
			}
		}
		
		System.out.println("글 " + success + "개를 정상적으로 내보냈습니다.");
		if (!errors.isEmpty()) {
			System.out.println(errors + "개의 글을 내보내지 못했습니다.");
			System.out.print("내보내지 못한 글들의 번호 : ");
			for (int error : errors) {
				System.out.print(error + ", ");
			}
		}
	}

}

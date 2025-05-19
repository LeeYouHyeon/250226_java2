package board;

import java.util.Date;
import java.util.Objects;

public class Board {
	/*
	 * 번호, 제목, 내용, 작성자, 작성일 번호가 일치하면 같은 게시물로 인지 => equals 추가 - 각 개체는 독립적 / 번호는 하나의
	 * 번호를 참조 번호는 자동으로 증가 => static (전 객체가 공유) 작성일은 오늘 날짜를 자동으로 추가
	 */
	private static int count = 0;
	private int num;
	private String title, content, writer;
	private Date regDate;

	// 생성자
	public Board() {
		count++;
		num = count;
		regDate = new Date();
	}

	public Board(String title, String content, String writer) {
		this();
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public Board(int num) {
		this.num = num;
	}

	@Override
	public int hashCode() {
		return Objects.hash(num);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		return num == other.num;
	}

	@Override
	public String toString() {
		return "Board [num=" + num + ", title=" + title + ", writer=" + writer + ", regDate=" + regDate + "]";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegDate() {
		return regDate;
	}
}

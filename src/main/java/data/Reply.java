package data;

import java.util.Date;

public class Reply {

	int id;
	String moimId;
	String writer;
	String ment;
	Date writed;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMoimId() {
		return moimId;
	}

	public void setMoimId(String moimId) {
		this.moimId = moimId;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getMent() {
		return ment;
	}

	public void setMent(String ment) {
		this.ment = ment;
	}

	public Date getWrited() {
		return writed;
	}

	public void setWrited(Date writed) {
		this.writed = writed;
	}

}

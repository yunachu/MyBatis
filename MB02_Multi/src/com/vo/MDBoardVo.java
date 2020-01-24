package com.vo;

import java.util.Date;

public class MDBoardVo {
	private int seq;
	private String writer;
	private String title;
	private String content;
	private Date regdate;
	public MDBoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MDBoardVo(int seq, String writer, String title, String content, Date regdate) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
	}
	public MDBoardVo(String writer, String title, String content) {
		super();
		this.writer = writer;
		this.title = title;
		this.content = content;
	}
	public MDBoardVo(int seq, String title, String content) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "MDBoardVo [seq=" + seq + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ ", regdate=" + regdate + "]";
	}
	
	

}

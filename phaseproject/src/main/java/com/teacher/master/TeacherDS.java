package com.teacher.master;

public class TeacherDS {
	private String cname;
	private String sname;
	private String tname;

	public TeacherDS(String cname, String sname, String tname) {
		super();
		this.cname = cname;
		this.sname = sname;
		this.tname = tname;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}
	
	
}

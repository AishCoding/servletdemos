package com.classes.master;

public class ClassDS {
	private String cname;
	private String sname;
	
	public ClassDS(String cname, String sname) {
		super();
		this.cname = cname;
		this.sname = sname;
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
}

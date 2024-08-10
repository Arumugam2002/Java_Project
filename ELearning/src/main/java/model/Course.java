package model;

public class Course {

	private int cid, tid, cprice;
	private String cname, cimage, ccategory, cdesc;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getCprice() {
		return cprice;
	}
	public void setCprice(int cprice) {
		this.cprice = cprice;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCimage() {
		return cimage;
	}
	public void setCimage(String cimage) {
		this.cimage = cimage;
	}
	public String getCcategory() {
		return ccategory;
	}
	public void setCcategory(String ccategory) {
		this.ccategory = ccategory;
	}
	public String getCdesc() {
		return cdesc;
	}
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", tid=" + tid + ", cprice=" + cprice + ", cname=" + cname + ", cimage=" + cimage
				+ ", ccategory=" + ccategory + ", cdesc=" + cdesc + "]";
	}
	
	
	
}

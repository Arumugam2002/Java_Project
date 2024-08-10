package model;

public class WishList {

	private int wid, userid, cid;

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "WishList [wid=" + wid + ", userid=" + userid + ", cid=" + cid + "]";
	}

	
	
	
	
}

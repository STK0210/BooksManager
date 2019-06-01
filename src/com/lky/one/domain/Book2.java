package com.lky.one.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class Book2 implements Serializable {

	private static final long serialVersionUID = 500939580347493072L;

	private String bname;
	private String bnum;
	private String authers;
	private Date pubDate;
	private float price;
	private int kind;
	private int bid;

	private HashMap<String, Integer> subKind;

	public HashMap<String, Integer> getSubKind() {
		return subKind;
	}

	public void setSubKind(HashMap<String, Integer> subKind) {
		this.subKind = subKind;
	}

	// 计算机->软件工程、计算机网络、编程语言、其它；文学->小说、散文、诗词、其它；管理->行政管理、工商管理、金融管理、其它；其它->无
	public void setSubKind(int kind) {
		if (this.subKind != null) {
			this.subKind.clear();
		} else {
			this.subKind = new HashMap<String, Integer>();
		}
		if (kind == 1) {
			this.subKind.clear();
			this.subKind.put("软件工程", 11);
			this.subKind.put("计算机网络", 12);
			this.subKind.put("编程语言", 13);
			this.subKind.put("其他", 14);
		} else if (kind == 2) {
			this.subKind.clear();
			this.subKind.put("小说", 21);
			this.subKind.put("散文", 22);
			this.subKind.put("诗词", 23);
			this.subKind.put("其他", 24);
		} else if (kind == 3) {
			this.subKind.clear();
			this.subKind.put("行政管理", 31);
			this.subKind.put("工商管理", 32);
			this.subKind.put("金融管理", 33);
			this.subKind.put("其他", 34);
		} else if (kind == 4) {
			this.subKind.clear();
			this.subKind.put("无", 44);
		} else {
			this.subKind.clear();
			this.subKind.put("--请选择--", 0);
		}
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBnum() {
		return bnum;
	}

	public void setBnum(String bnum) {
		this.bnum = bnum;
	}

	public String getAuthers() {
		return authers;
	}

	public Book2(String bname, String bnum, String authers, Date pubDate, float price, int kind, int bid,
			HashMap<String, Integer> subKind) {
		super();
		this.bname = bname;
		this.bnum = bnum;
		this.authers = authers;
		this.pubDate = pubDate;
		this.price = price;
		this.kind = kind;
		this.bid = bid;
		this.subKind = subKind;
	}

	public Book2() {
		super();
	}

	public void setAuthers(String authers) {
		this.authers = authers;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getKindStr(int kind) {
		switch (kind) {
		case 1:
			return "计算机";
		case 2:
			return "文学";
		case 3:
			return "管理";
		case 4:
			return "其他";
		default:
			return "error";
		}
	}

	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

	public String getBidStr(int bid) {
//		Iterator<String> iterator = this.subKind.keySet().iterator();
//		while (iterator.hasNext()) {
//			String key = iterator.next();
//			if (this.subKind.get(key) == bid) {
//				return key;
//			}
//		}
//		return null;
		switch (bid) {
		case 11:
			return "软件工程";
		case 12:
			return "计算机网络";
		case 13:
			return "编程语言";
		case 14:
			return "其他";
		case 21:
			return "小说";
		case 22:
			return "散文";
		case 23:
			return "诗词";
		case 24:
			return "其他";
		case 31:
			return "行政管理";
		case 32:
			return "工商管理";
		case 33:
			return "金融管理";
		case 34:
			return "其他";
		case 44:
			return "无";
		default:
			return "default";
		}
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	@Override
	public String toString() {
		return "Book2 [bname=" + bname + ", bnum=" + bnum + ", authers=" + authers + ", pubDate=" + pubDate + ", price="
				+ price + ", kind=" + kind + ", bid=" + bid + ", subKind=" + subKind + "]";
	}

}

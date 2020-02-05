package com.pojo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Ticket implements Serializable {
	private int t_id;
	private String t_name;
	private Date t_time;
	private String t_address;
	private String t_num;
	private double t_price;
	private String t_fname="default.jpg";
	private int type_id;
	private String typess_name;
	//页面日期
	private String t_date;
	//Spring 文件上传
	private MultipartFile pic;
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ticket(int t_id, String t_name, Date t_time, String t_address, String t_num, double t_price, String t_fname,
			int type_id, String typess_name, String t_date, MultipartFile pic) {
		super();
		this.t_id = t_id;
		this.t_name = t_name;
		this.t_time = t_time;
		this.t_address = t_address;
		this.t_num = t_num;
		this.t_price = t_price;
		this.t_fname = t_fname;
		this.type_id = type_id;
		this.typess_name = typess_name;
		this.t_date = t_date;
		this.pic = pic;
	}
	public Ticket(String t_name, Date t_time, String t_address, String t_num, double t_price, String t_fname,
			int type_id, String t_date, MultipartFile pic) {
		super();
		this.t_name = t_name;
		this.t_time = t_time;
		this.t_address = t_address;
		this.t_num = t_num;
		this.t_price = t_price;
		this.t_fname = t_fname;
		this.type_id = type_id;
		this.t_date = t_date;
		this.pic = pic;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public Date getT_time() {
		return t_time;
	}
	public void setT_time(Date t_time) {
		this.t_time = t_time;
	}
	public String getT_address() {
		return t_address;
	}
	public void setT_address(String t_address) {
		this.t_address = t_address;
	}
	public String getT_num() {
		return t_num;
	}
	public void setT_num(String t_num) {
		this.t_num = t_num;
	}
	public double getT_price() {
		return t_price;
	}
	public void setT_price(double t_price) {
		this.t_price = t_price;
	}
	public String getT_fname() {
		return t_fname;
	}
	public void setT_fname(String t_fname) {
		this.t_fname = t_fname;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getTypess_name() {
		return typess_name;
	}
	public void setTypess_name(String typess_name) {
		this.typess_name = typess_name;
	}
	public String getT_date() {
		t_date=new SimpleDateFormat("yyyy-MM-dd").format(t_time);
		return t_date;
	}
	public void setT_date(String t_date) {
		try {
			t_time=new SimpleDateFormat("yyyy-MM-dd").parse(t_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.t_date = t_date;
	}
	public MultipartFile getPic() {
		return pic;
	}
	public void setPic(MultipartFile pic) {
		this.pic = pic;
	}
	@Override
	public String toString() {
		return "Ticket [t_id=" + t_id + ", t_name=" + t_name + ", t_time=" + t_time + ", t_address=" + t_address
				+ ", t_num=" + t_num + ", t_price=" + t_price + ", t_fname=" + t_fname + ", type_id=" + type_id
				+ ", typess_name=" + typess_name + ", t_date=" + t_date + ", pic=" + pic + "]";
	}
	
	
	
}

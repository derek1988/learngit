package model;

import java.util.Date;

public class Line {

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity_no() {
		return city_no;
	}
	public void setCity_no(String city_no) {
		this.city_no = city_no;
	}
	public String getMp_id() {
		return mp_id;
	}
	public void setMp_id(String mp_id) {
		this.mp_id = mp_id;
	}
	public Date getDate_dt() {
		return date_dt;
	}
	public void setDate_dt(Date date_dt) {
		this.date_dt = date_dt;
	}
	public double getDay_in_e() {
		return day_in_e;
	}
	public void setDay_in_e(double day_in_e) {
		this.day_in_e = day_in_e;
	}
	public double getDay_out_e() {
		return day_out_e;
	}
	public void setDay_out_e(double day_out_e) {
		this.day_out_e = day_out_e;
	}
	public double getLine_loss() {
		return line_loss;
	}
	public void setLine_loss(double line_loss) {
		this.line_loss = line_loss;
	}
	public int getCounty_no() {
		return county_no;
	}
	public void setCounty_no(int county_no) {
		this.county_no = county_no;
	}
	public int getLine_id() {
		return line_id;
	}
	public void setLine_id(int line_id) {
		this.line_id = line_id;
	}
	public String getLine_name() {
		return line_name;
	}
	public void setLine_name(String line_name) {
		this.line_name = line_name;
	}
	private int id;
	private String city_no;
	private String mp_id;
	private Date date_dt;
	private double day_in_e;
	private double day_out_e;
	private double line_loss;
	private int county_no;
	private int line_id;
	private String line_name;
	
	
	/**
	 * ¥Ú”°Line–≈œ¢
	 */
	public String toString(){
		
		return this.id+","+this.city_no+","+this.mp_id+","+this.date_dt.toGMTString()
		+","+this.day_in_e+","+this.day_out_e+","+this.line_loss
		+","+this.county_no+","+this.line_id+","+this.line_name;
	}
}

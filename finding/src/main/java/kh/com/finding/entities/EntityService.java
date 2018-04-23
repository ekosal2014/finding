package kh.com.finding.entities;

import java.util.List;

public class EntityService {

	private String service_cd ;	
	private String user_cd    ;
	private String phone_nm   ;
	private String address	  ;
	private String logo       ;
	private String title      ;
	private String sub_title  ;
	private String email      ;
	private String website    ;
	private String description;
	private String work_tm    ;
	private String work_day   ;
	private String des_address;
	private String sts        ;
	
	private List<EntityImage>  images ;
	private List<EntityNews>   news   ;
	
	
	
	public String getService_cd() {
		return service_cd;
	}
	public void setService_cd(String service_cd) {
		this.service_cd = service_cd;
	}
	public String getUser_cd() {
		return user_cd;
	}
	public void setUser_cd(String user_cd) {
		this.user_cd = user_cd;
	}
	public String getPhone_nm() {
		return phone_nm;
	}
	public void setPhone_nm(String phone_nm) {
		this.phone_nm = phone_nm;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSub_title() {
		return sub_title;
	}
	public void setSub_title(String sub_title) {
		this.sub_title = sub_title;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getWork_tm() {
		return work_tm;
	}
	public void setWork_tm(String work_tm) {
		this.work_tm = work_tm;
	}
	public String getWork_day() {
		return work_day;
	}
	public void setWork_day(String work_day) {
		this.work_day = work_day;
	}
	public String getDes_address() {
		return des_address;
	}
	public void setDes_address(String des_address) {
		this.des_address = des_address;
	}
	public String getSts() {
		return sts;
	}
	public void setSts(String sts) {
		this.sts = sts;
	}

	public List<EntityImage> getImages() {
		return images;
	}
	public void setImages(List<EntityImage> images) {
		this.images = images;
	}
	public List<EntityNews> getNews() {
		return news;
	}
	public void setNews(List<EntityNews> news) {
		this.news = news;
	}
	
	
	
	
}

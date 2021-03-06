package kh.com.finding.entities;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class EntityService {

	private int    service_cd ;	
	private int    user_cd    ;
	private String phone_nm   ;
	private String address	  ;
	private String service    ;
	private String logo       ;
	private String title      ;
	private String sub_title  ;
	private String email      ;
	private String website    ;
	private String description;
	private String work_tm    ;
	private String work_day   ;
	private String address_descriptions;
	private String reg_dt;
	private String sts        ;
	
	private List<EntityImage>  images ;
	private List<EntityNews>   news   ;
	
	
	
	public int getService_cd() {
		return service_cd;
	}
	public void setService_cd(int service_cd) {
		this.service_cd = service_cd;
	}
	public int getUser_cd() {
		return user_cd;
	}
	public void setUser_cd(int user_cd) {
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
	
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
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
	
	
	
	public String getAddress_descriptions() {
		return address_descriptions;
	}
	public void setAddress_descriptions(String address_descriptions) {
		this.address_descriptions = address_descriptions;
	}
	public String getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}
	@Override
	public String toString() {
		return "  phone_nm    = " + this.phone_nm    + "\n" + 
			   ", address     = " + this.address     + "\n" + 
			   ", logo        = " + this.logo        + "\n" +  
			   ", title       = " + this.title       + "\n" + 
			   ", sub_title   = " + this.sub_title   + "\n" +  
			   ", email       = " + this.email       + "\n" +  
			   ", website     = " + this.website     + "\n" +  
			   ", description = " + this.description + "\n" +  
			   ", work_tm     = " + this.work_tm     + "\n" + 
			   ", work_day    = " + this.work_day    + "\n" +  
			   ", des_address = " + this.address_descriptions + "\n" + 
			   ", sts         = " + this.sts         ;
	}
	
	
	
}

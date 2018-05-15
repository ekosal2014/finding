package kh.com.finding.entities;

import java.util.List;

public class EntityImage extends Images{

	private String img_cd          ;
	private String service_cd      ;
	private String title           ;
	private List<String>  listImage;
	private String reg_dt          ;
	private String sts             ;
	
	public String getImg_cd() {
		return img_cd;
	}
	public void setImg_cd(String img_cd) {
		this.img_cd = img_cd;
	}
	public String getService_cd() {
		return service_cd;
	}
	public void setService_cd(String service_cd) {
		this.service_cd = service_cd;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}
	public String getSts() {
		return sts;
	}
	public void setSts(String sts) {
		this.sts = sts;
	}
	@Override
	public List<String> getListImage() {
		// TODO Auto-generated method stub
		return this.listImage;
	}
	@Override
	public void setListImage(List<String> listImage) {
		// TODO Auto-generated method stub
		this.listImage = listImage;
	}
	
	
	
}

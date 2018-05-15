package kh.com.finding.utils;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import kh.com.finding.entities.Images;

public class UploadFileUtils {
	/**
	 * 
	 * @param image
	 * @param file
	 * @param path
	 * @return
	 */
	public static boolean UploadSingleFile(Images image, MultipartFile file,String path){
		
		if (!file.isEmpty()){
			
			
			try {
				//System.out.println(DateUtils.getDateTime(DateUtils.dttms_format));
			
				String destination = path + File.separator + file.getOriginalFilename();
				String file_name   = DateUtils.getDateTime(DateUtils.dttms_format)+".jpg";
				
				File f = new File(destination);
				File nf= new File(path + File.separator + file_name);

				FileCopyUtils.copy(file.getBytes(), f);				
				FileUtils.moveFile(f, nf);
				
				image.setImage(file_name);
				
				return true;
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
			
		}else{
			return true;
		}
		
	}
	
	public static void UploadMultiFile(Images image, MultipartFile[] file, String path){
		
	}
	
}

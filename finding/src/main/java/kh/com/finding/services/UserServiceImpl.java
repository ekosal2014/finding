package kh.com.finding.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kh.com.finding.entities.EntityUser;
import kh.com.finding.mappers.UserMapper;
import kh.com.finding.utils.ConstsUtils;
import kh.com.finding.utils.DateUtils;
import kh.com.finding.utils.JsonResponses;
@Service
public class UserServiceImpl{

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public JsonResponses registerUserInfo(EntityUser entityUser){
		
		JsonResponses json = new JsonResponses();
		
		try{
			
			entityUser.setReg_dt(DateUtils.getDate());
			entityUser.setSts("0");
			entityUser.setPassword(passwordEncoder.encode(entityUser.getPassword()));
			System.out.println(entityUser.toString());
			userMapper.registerUserInfo(entityUser);
			json.setStatus(ConstsUtils.DEFAULT_SUCCESS_STATUS);
			json.setResutl("success");
		}catch(Exception e){
			json.setStatus(ConstsUtils.DEFAULT_ERROR_STATUS);
			json.setStatus(e.getMessage());
			e.printStackTrace();
		}
		
		return json;
	}
    


}

package kh.com.finding.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kh.com.finding.entities.EntityRole;
import kh.com.finding.entities.EntityUser;

public interface UserMapper {

	
	public EntityUser loadingByUserName(@Param("username") String name);
	public EntityUser loadingByUserEmail(@Param("email") String email);
	public List<EntityRole> loadingAuthoritiesByName(String name);
	public int registerUserInfo(EntityUser entityUser);
	
	
}

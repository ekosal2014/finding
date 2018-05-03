package kh.com.finding.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kh.com.finding.entities.EntityRole;
import kh.com.finding.entities.EntityUser;
import kh.com.finding.entities.EntityUserRole;

public interface UserMapper {

	
	public EntityUser loadingByUserName(@Param("username") String name);
	public EntityUser loadingByUserEmail(@Param("email") String email);
	public List<EntityRole> loadingAuthoritiesByName(@Param("username") String name);
	public int registerUserInfo(EntityUser entityUser);
	public int registerUserRole(EntityUserRole userRole);
	
	
}

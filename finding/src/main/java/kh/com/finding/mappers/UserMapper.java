package kh.com.finding.mappers;

import java.util.List;
import kh.com.finding.entities.EntityRole;
import kh.com.finding.entities.EntityUser;

public interface UserMapper {

	
	public EntityUser loadingByUserName(String name);
	public EntityUser loadingByUserEmail(String email);
	public List<EntityRole> loadingAuthoritiesByName(String name);
	
	
}

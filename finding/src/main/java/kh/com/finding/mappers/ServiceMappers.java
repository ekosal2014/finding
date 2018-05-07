package kh.com.finding.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kh.com.finding.entities.EntityService;

public interface ServiceMappers {
	
	public List<EntityService> loadingServiceByUserName(@Param("username") String username);

}

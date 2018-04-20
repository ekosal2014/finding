package kh.com.finding.mappers;

import java.util.List;

import kh.com.finding.entities.EntityService;

public interface ServiceMappers {
	
	public List<EntityService> loadingServiceByUserName(String name);

}

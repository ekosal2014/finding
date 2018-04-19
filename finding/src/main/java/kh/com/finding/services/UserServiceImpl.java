package kh.com.finding.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.com.finding.entities.EntityUser;
import kh.com.finding.mappers.UserMapper;

@Service("UserMapper")
public class UserServiceImpl implements UserMapper{

	@Transactional
	@Override
	public EntityUser logInByUserName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}

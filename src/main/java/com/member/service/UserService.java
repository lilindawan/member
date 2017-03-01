package com.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.member.entity.User;
import com.member.mapper.UserMapper;

@Service
public class UserService {
	@Autowired
	@Qualifier("userMapper")
	private UserMapper userMapper;

	public void save(User user) {
		userMapper.save(user);
	}

	public User selectById(int id) {
		return userMapper.selectById(id);
	}
	
	public List<User> queryAll(){
		return userMapper.queryAll();
	}
	
	public void deleteUser(Integer id){
		userMapper.deleteById(id);
	}
	
	public void updateById(User user){
		userMapper.updateById(user);
	}
}

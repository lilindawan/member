package com.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.member.entity.User;

@Mapper
public interface UserMapper {
	int save(User user);
	

	User selectById(Integer member_id);

	int updateById(User user);

	int deleteById(Integer member_id);

	List<User> queryAll();
}

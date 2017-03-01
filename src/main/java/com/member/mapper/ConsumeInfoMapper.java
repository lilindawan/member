package com.member.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.member.entity.ConsumeInfo;

@Mapper
public interface ConsumeInfoMapper {
	int save(ConsumeInfo consumeInfo);
}

package com.member.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.member.entity.PayCheckInfo;

@Mapper
public interface PayCheckInfoMapper {
	int save(PayCheckInfo payCheckInfo);
}

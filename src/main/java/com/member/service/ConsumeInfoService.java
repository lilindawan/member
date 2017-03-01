package com.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.member.entity.ConsumeInfo;
import com.member.mapper.ConsumeInfoMapper;

@Service
public class ConsumeInfoService {
	@Autowired
	@Qualifier("consumeInfoMapper")
	private ConsumeInfoMapper consumeInfoMapper;

	public void save(ConsumeInfo consumeInfo) {
		consumeInfoMapper.save(consumeInfo);
	}
}

package com.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.member.entity.PayCheckInfo;
import com.member.mapper.PayCheckInfoMapper;

@Service
public class PayCheckInfoService {
	@Autowired
	@Qualifier("payCheckInfoMapper")
	private PayCheckInfoMapper payCheckInfoMapper;

	public void save(PayCheckInfo payCheckInfo) {
		payCheckInfoMapper.save(payCheckInfo);
	}
}

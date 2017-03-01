package com.member.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.member.entity.ConsumeInfo;
import com.member.entity.PayCheckInfo;
import com.member.entity.User;
import com.member.service.ConsumeInfoService;
import com.member.service.PayCheckInfoService;
import com.member.service.UserService;

@Controller
@EnableAutoConfiguration
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private ConsumeInfoService consumeInfoService;
	@Autowired
	private PayCheckInfoService payCheckInfoService;

	@ResponseBody
	@RequestMapping({ "/home" })
	public User home() {
		User user = userService.selectById(1);
		System.out.println("用户信息" + user);
		return user;
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET, produces = "application/json")
	public String deleteUser(Map<String, Object> model,String id){
		userService.deleteUser(Integer.valueOf(id));
		return userManage(model);
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.GET, produces = "application/json")
	public String addUser(){
		return "add_user";
	}
	
	@RequestMapping(value = "/userManage", method = RequestMethod.GET, produces = "application/json")
	public String userManage(Map<String, Object> model){
		model.put("users", userService.queryAll());
		return "userManage";
	}
	
	@RequestMapping(value = "/addUser.do", method = RequestMethod.POST, produces = "application/json")
	public String addUser(Map<String, Object> model,String name, String member_birthday
			,String due_date,String phone_number,String total_money,String remarks ) {
		User user =  new User();
		user.setMember_name(name);
		user.setMember_birthday(member_birthday);
		user.setDue_date(due_date);
		user.setPhone_number( phone_number);
		user.setAvailable_amount(total_money);
		user.setTotal_consumption("0");
		user.setTotal_money(total_money);
		user.setCreation_date(new Date());
		user.setRemarks(remarks);
		userService.save(user);
		return userManage(model);
	}
	@RequestMapping(value = "/modifyUser", method = RequestMethod.GET, produces = "application/json")
	public String modifyUser(Map<String, Object> model,String id){
		User user =  userService.selectById(Integer.valueOf(id));
		model.put("user", user);
		return "modify_user";
	}
	
	@RequestMapping(value = "/modifyUser.do", method = RequestMethod.POST, produces = "application/json")
	public String modifyUser(Map<String, Object> model,String id,String name, String member_birthday
			,String due_date,String phone_number ) {
		User user =  userService.selectById(Integer.valueOf(id));
		user.setMember_name(name);
		user.setMember_birthday(member_birthday);
		user.setDue_date(due_date);
		user.setPhone_number( phone_number);
		user.setCreation_date(new Date());
		userService.updateById(user);
		return userManage(model);
	}
	@RequestMapping(value = "/userConsume", method = RequestMethod.GET, produces = "application/json")
	public String userConsume(Map<String, Object> model,String id){
		User user =  userService.selectById(Integer.valueOf(id));
		model.put("user", user);
		return "user_consume";
	}
	
	@RequestMapping(value = "/userConsume.do", method = RequestMethod.POST, produces = "application/json")
	public String userConsume(Map<String, Object> model,String id,String consume_money,String consume_remarks ) {
		User user =  userService.selectById(Integer.valueOf(id));
		int available_amount= Integer.parseInt(user.getAvailable_amount())-Integer.parseInt(consume_money);
		int total_consumption= Integer.parseInt(user.getTotal_consumption())+Integer.parseInt(consume_money);
		user.setAvailable_amount(String.valueOf(available_amount));
		user.setTotal_consumption(String.valueOf(total_consumption));
		userService.updateById(user);
		ConsumeInfo ConsumeInfo =new ConsumeInfo();
		BigDecimal bd=new BigDecimal(id);   
		ConsumeInfo.setMember_id(bd);
		ConsumeInfo.setConsume_money(consume_money);
		ConsumeInfo.setConsume_remarks(consume_remarks);
		ConsumeInfo.setConsume_date(new Date());
		consumeInfoService.save(ConsumeInfo);
		return userManage(model);
	}
	
	@RequestMapping(value = "/userPayCheck", method = RequestMethod.GET, produces = "application/json")
	public String userPayCheck(Map<String, Object> model,String id){
		User user =  userService.selectById(Integer.valueOf(id));
		model.put("user", user);
		return "user_paycheck";
	}
	
	@RequestMapping(value = "/userPayCheck.do", method = RequestMethod.POST, produces = "application/json")
	public String userPayCheck(Map<String, Object> model,String id,String paycheck_money,String paycheck_remarks ) {
		User user =  userService.selectById(Integer.valueOf(id));
		int available_amount= Integer.parseInt(user.getAvailable_amount())+Integer.parseInt(paycheck_money);
		int total_money= Integer.parseInt(user.getTotal_money())+Integer.parseInt(paycheck_money);
	
		user.setAvailable_amount(String.valueOf(available_amount));
		user.setTotal_money(String.valueOf(total_money));
		userService.updateById(user);
		
		PayCheckInfo payCheckInfo =new PayCheckInfo();
		BigDecimal bd=new BigDecimal(id);   
		payCheckInfo.setMember_id(bd);
		payCheckInfo.setPaycheck_money(paycheck_money);
		payCheckInfo.setPaycheck_remarks(paycheck_remarks);
		payCheckInfo.setPaycheck_date(new Date());
		payCheckInfoService.save(payCheckInfo);
		return userManage(model);
	}
	  
}

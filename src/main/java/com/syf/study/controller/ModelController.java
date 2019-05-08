package com.syf.study.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.syf.study.entity.Car;
import com.syf.study.entity.User;

@Controller
@SessionAttributes({"user","car"})
public class ModelController {

	@ModelAttribute("user")//SessionAttributes��@ModelAttribute��ʽ����,@SessionAttributes���ʹ��@ModelAttributeʱ�����ָ���������ʽ���췽��
	public User getUser() {
		return new User();
	}
	/**
	 * request���ü���ķ�ʽ
	 * ModelAndView
	 * ModelMap
	 * Model
	 * 
	 * session����
	 * @SessionAttributes();
	 * 
	 * Cookie����
	 * @CookieAttribute
	 */
	
	//ModelAndView�ײ�Ҳ��ʹ��ModelMap���д�ֵ��ֻ����ǰ�߶�һ����ͼ����
	//Ĭ�Ϸ��ص�ҳ��Ϊ�����ַ/handlerָ��/springMVC/WEB-INF/pages/handler.jsp,
	//��������ַΪ/a/handler���򷵻�ָ��/springMVC/WEB-INF/pages/a/handler.jsp,����ͨ��m.setViewName("handler");�޸ķ��ص�ַ
	@GetMapping("/a/handler")
	public ModelAndView handler() {
		ModelAndView m=new ModelAndView();
		User u=new User();
		u.setAccount("1");
		u.setId(1);
		m.addObject(u);//�ȼ���m.addObject("user",u);
		User u1=new User();
		u1.setAccount("11");
		u1.setId(11);
		m.addObject(u1);//�ȼ���m.addObject("user",u);�˴��Ὣ�Ϸ�����
		Car c=new Car();
		c.setName("car name");
		m.addObject(c);//�ȼ���m.addObject("car",u);
		User u2=new User();
		u2.setAccount("111");
		u2.setId(111);
		m.addObject("user2",u2);//ָ������ֵ����,���Ḳ��
		m.setViewName("handler");
		return m;
	}

	@GetMapping("/handler2")
	public String handler2(ModelMap m) {
		User u=new User();
		u.setAccount("2");
		u.setId(22);
		m.addAttribute(u);//�ȼ���m.addAttribute("user",u);
		return "handler";
	}

	@GetMapping("/handler3")
	public String handler3(Model m) {
		User u=new User();
		u.setAccount("3");
		u.setId(33);
		m.addAttribute(u);//�ȼ���m.addAttribute("user",u);
		return "handler";
	}

	
	@GetMapping("/handler4")
	public String handler4(@ModelAttribute("user")User u) {//ֻҪ����������@ModelAttribute�����Զ��Ѷ�Ӧ���ݷ��뵽ModelMap��
		
		return "handler";
	}
	
	
	@GetMapping("/handler5")
	public String handler5(HttpSession session) {//session����������㷽ʽ
		User u=new User();
		u.setAccount("5");
		u.setId(55);
		session.setAttribute("user", u);
		System.out.println(session.getAttribute("user"));
		return "handler";
	}


	@GetMapping("/handler6")
	public String handler6(@ModelAttribute("car")Car u) {//ֻҪ����������@ModelAttribute�����Զ��Ѷ�Ӧ���ݷ��뵽ModelMap��
		
		return "handler";
	}
}
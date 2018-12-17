package priv.dengjl.springmybatis.test;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import priv.dengjl.springmybatis.bean.Role;
import priv.dengjl.springmybatis.service.RoleListService;

public class TestRun {
	
	private static final Logger logger = LoggerFactory.getLogger(TestRun.class);
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-tx-config.xml");
		RoleListService bean = context.getBean(RoleListService.class);
		
		List<Role> roles = new ArrayList<>();
		Role role = new Role();
		role.setId(10087);
		role.setName("10087");
		role.setDesc("10087");
		roles.add(role);
		role = new Role();
		role.setId(10088);
		role.setName("10088");
		role.setDesc("10088");
		roles.add(role);
		
		bean.insertRole(roles);
		logger.debug(bean.toString());
	}

}

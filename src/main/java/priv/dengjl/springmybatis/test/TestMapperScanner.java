package priv.dengjl.springmybatis.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import priv.dengjl.springmybatis.bean.Role;
import priv.dengjl.springmybatis.dao.RoleMapper;

public class TestMapperScanner {
	
	private static final Logger logger = LoggerFactory.getLogger(TestMapperScanner.class);
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybaties3.xml");
		RoleMapper roleMapper = context.getBean(RoleMapper.class);
		Role role = roleMapper.selectRole(10086);
		
		logger.debug(role.toString());
	}

}

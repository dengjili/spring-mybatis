package priv.dengjl.springmybatis.tx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import priv.dengjl.springmybatis.bean.Role;
import priv.dengjl.springmybatis.service.RoleXmlService;
import priv.dengjl.springmybatis.test.TestMapperScanner;

public class RunTestXmlTx {

// xml事务
private static final Logger logger = LoggerFactory.getLogger(TestMapperScanner.class);
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-tx-xml.xml");
		RoleXmlService bean = context.getBean(RoleXmlService.class);
		
		Role role = new Role();
		role.setId(10089);
		role.setName("10089");
		role.setDesc("10089");
		bean.insertRole(role);
		
		logger.debug(bean.toString());
	}
}

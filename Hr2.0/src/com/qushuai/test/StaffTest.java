package com.qushuai.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qushuai.pojo.Staff;
import com.qushuai.service.StaffService;

public class StaffTest {
	private StaffService staffService;

	@SuppressWarnings("resource")
	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		staffService = ctx.getBean("staffService", StaffService.class);
	}

	@Test
	public void testfindAll() {
		for (Staff staff : staffService.find()) {
			System.out.println(staff.getName() + "   " + staff.getId() + "   " + staff.getJob() + "   "
					+ staff.getPhone() + "   " + staff.getEmail());
		}
	}

	@Test
	public void testadd() {
		Staff staff = new Staff();
		staff.setName("Ö£ÓýèÉ");
		staff.setJob("²âÊÔ");
		staff.setPhone("18711154565");
		staff.setEmail("zhengyuxiao@163.com");
		staffService.add(staff);
	}

	@Test
	public void testmodify() {
		Staff staff = new Staff();
		staff.setId(1004);
		staff.setName("ÇüË§");
		staff.setJob("ÑÐ·¢");
		staff.setPhone("18711154565");
		staff.setEmail("qushuai@163.com");
		staffService.modify(staff);
	}

	@Test
	public void testfindById() {
		Staff staff = staffService.find(1001);
		System.out.println(staff.getName() + "   " + staff.getId() + "   " + staff.getJob() + "   " + staff.getPhone()
				+ "   " + staff.getEmail());
	}
}

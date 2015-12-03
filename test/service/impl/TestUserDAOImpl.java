package service.impl;


import junit.framework.Assert;

import org.junit.Test;

import service.UsersDAO;
import entity.Users;

public class TestUserDAOImpl {
	
	@Test
	public void testUsersLogin(){
		Users u = new  Users(1,"zhangsan","123456");
		UsersDAO uDao =  new UsersDAOImpl();
		
		//JUint断言判断第一个和第二个bool值是否相等
		Assert.assertEquals(true, uDao.usersLogin(u));
		
	}
	
}

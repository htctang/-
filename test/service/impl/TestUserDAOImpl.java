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
		
		//JUint�����жϵ�һ���͵ڶ���boolֵ�Ƿ����
		Assert.assertEquals(true, uDao.usersLogin(u));
		
	}
	
}

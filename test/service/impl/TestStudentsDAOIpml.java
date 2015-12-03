package service.impl;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import service.StudentsDAO;
import entity.Students;

public class TestStudentsDAOIpml {
	@Test
	public void testQueryAllStudents(){
		StudentsDAO sdao = new StudentsDAOImpl();
		List<Students> list = sdao.queryAllStudents();
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
/*	@Test
	public void testGetNewSid(){
		StudentsDAOImpl sdao = new StudentsDAOImpl();
		System.out.println(sdao.getNewSid());
	}*/
	@Test
	public void testAddStudents(){
		Students s = new Students();
		s.setSname("ÍõÂé×Ó");
		s.setGender("ÄÐ");
		s.setBirthday(new Date());
		s.setAddress("³¤É³");
		StudentsDAO sdao = new StudentsDAOImpl();
		Assert.assertEquals(true, sdao.addStudents(s));
	}
	
	
}

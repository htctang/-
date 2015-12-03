package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.student.sessfactory.HibernateSessionFactory;

import entity.Students;
import service.StudentsDAO;

public class StudentsDAOImpl implements StudentsDAO{

	@Override
	public List<Students> queryAllStudents() {
		Transaction tx =null;
		List<Students> list=null;
		String hql="";
	try {
		Session session = HibernateSessionFactory.getSession();
		tx = session.beginTransaction();
		hql="from Students";
		Query query = session.createQuery(hql);
		
		list=query.list();
		tx.commit();
		return list;
	} catch (Exception e) {
		e.printStackTrace();
		tx.commit();
		return list;
	}finally{
		if(tx!=null){
			tx=null;
		}
	}
		
	}

	@Override
	public Students queryStudetsBySid(String sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addStudents(Students s) {
		s.setSid(getNewSid());
		Transaction tx=null;
		
		try {
			Session session = HibernateSessionFactory.getSession();
			tx=session.beginTransaction();
			session.save(s);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			
		}
		
	}

	@Override
	public boolean updataStudents(Students s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteStudents(String sid) {
		
		Transaction tx=null;
//		String hql="";
		try {
			Session session = HibernateSessionFactory.getSession();
			tx=session.beginTransaction();
			Students s = (Students)session.get(Students.class,sid);
			session.delete(s);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return false;
		}finally{
			if(tx!=null){
				tx=null;
			}
		}
		
	}
	/**
	 * 生成学生学号
	 * 这个算法值得考究
	 * 
	 * */
	public String getNewSid(){
		Transaction tx = null;
		String hql = "";
		String sid=null;
		try{
			Session session= HibernateSessionFactory.getSession();
			tx=session.beginTransaction();
			hql="select max(sid) from Students";
			Query query = session.createQuery(hql);
			sid=(String)query.uniqueResult();
			if(sid==null||"".equals(sid)){
				//默认的最大编号
				sid="S0000001";
			}else{
				String temp=sid.substring(1);//去掉第一个字母s
				int i=Integer.parseInt(temp);//
				i++;
				temp=String.valueOf(i);
				int len=temp.length();
				//凑够七位
				for(int j=0;j<7-len;j++){
					temp="0"+temp;
				}
				sid="S"+temp;
			}
			tx.commit();
			return sid;
		}catch(Exception e){
			e.printStackTrace();
			tx.commit();
			return null;
		}finally{
			if(tx!=null){
				tx=null;
			}
		}
	}

}

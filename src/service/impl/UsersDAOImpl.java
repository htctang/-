package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import service.UsersDAO;

import com.student.sessfactory.HibernateSessionFactory;

import entity.Users;

public class UsersDAOImpl implements UsersDAO{

	@Override
	public boolean usersLogin(Users u) {

		Transaction tx = null;
		String hql="";
		try {
			
			Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hql="from Users where username=? and password=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, u.getUsername());
			query.setParameter(1, u.getPassword());
			List list = query.list();
			tx.commit();
			if(list.size()>0){
				return true;
			}else{
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally{
			if(tx!=null){
//				tx.commit();
				tx=null;
			}
		}
	
	}
	
}

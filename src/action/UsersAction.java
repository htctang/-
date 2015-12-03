package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import service.UsersDAO;
import service.impl.UsersDAOImpl;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;

/**
 * struts2 ���ձ����ݵķ�ʽ����ͨ���� ������� ģ������
 * 
 * ��action�õ���ģ������
 * */
public class UsersAction extends SuperAction implements ModelDriven<Users>{

	
	
	private static final long serialVersionUID=1L;//seriaVersionUID�����ã� ������Ŀ�ݼ�����ʲô
	
	private Users user = new Users();	//ģ���������Բ���seter geter��װ
	
	public String login(){
		
		UsersDAO udo = new UsersDAOImpl();
		
		if(udo.usersLogin(user)){
			System.out.println("�������AAAAA");
			/**
			 * �����loginUserName��ʲô��ǰ̨�е��Ǹ�$���þ���ʲô
			 * */
			session.setAttribute("loginUserName", user.getUsername());
			return "login_success";
		}else{
			System.out.println("�������BBBBB");
			return "login_failure";
		}
		
	}
	
	@SkipValidation 
	public String logout(){
		
		if(session.getAttribute("loginUserName")!=null){
			session.removeAttribute("loginUserName");
		}
		
		return "logout_success";
	}
	/**
	 * struts�Դ�����֤������
	 * �����еı�action�ĺ��������ı���Ҫ��֤
	 * �Լ���SkipValidationע��ĺ��������б���֤
	 * 
	 * ����֤ʵ�����ǲ��ܳɹ���ԭ����ʱ�Ҳ���
	 * ����ԭ��No result defined for action action.UsersAction and result input
	 */
	@Override
	public void validate() {
		
		//�û�������Ϊ��
		if("".equals(user.getUsername().trim())){
			this.addFieldError("usernaneError","�û�������Ϊ��");
			
		}if(user.getPassword().length()<6){
			this.addFieldError("passwordError","���볤�Ȳ�����6λ");
		}
	}
	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

}

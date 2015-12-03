package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import service.UsersDAO;
import service.impl.UsersDAOImpl;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;

/**
 * struts2 接收表单数据的方式：普通属性 领域对象 模型驱动
 * 
 * 本action用的是模型驱动
 * */
public class UsersAction extends SuperAction implements ModelDriven<Users>{

	
	
	private static final long serialVersionUID=1L;//seriaVersionUID的作用？ 添加它的快捷键有是什么
	
	private Users user = new Users();	//模型驱动可以不用seter geter封装
	
	public String login(){
		
		UsersDAO udo = new UsersDAOImpl();
		
		if(udo.usersLogin(user)){
			System.out.println("错误测试AAAAA");
			/**
			 * 这里的loginUserName是什么在前台中的那个$调用就是什么
			 * */
			session.setAttribute("loginUserName", user.getUsername());
			return "login_success";
		}else{
			System.out.println("错误测试BBBBB");
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
	 * struts自带的验证表单函数
	 * 对所有的本action的函数传来的表单都要验证
	 * 对加入SkipValidation注解的函数不进行表单验证
	 * 
	 * 表单验证实际上是不能成功的原因还暂时找不到
	 * 错误原因No result defined for action action.UsersAction and result input
	 */
	@Override
	public void validate() {
		
		//用户名不能为空
		if("".equals(user.getUsername().trim())){
			this.addFieldError("usernaneError","用户名不能为空");
			
		}if(user.getPassword().length()<6){
			this.addFieldError("passwordError","密码长度不少于6位");
		}
	}
	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

}

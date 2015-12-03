package action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 所有action的父类
 * 继承三个接口获取全局的session 主要是为了方便实现struts的特有拦截器等
 * 
 * */
public class SuperAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,ServletContextAware{

	protected HttpServletRequest requset; //请求对象
	protected HttpServletResponse response;//相应对象
	protected HttpSession session; //回话对象
	protected ServletContext application;
	
	@Override
	public void setServletContext(ServletContext application) {
		this.application=application;
		
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		
		this.requset=request;
		this.session = request.getSession();
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
		
	}


}

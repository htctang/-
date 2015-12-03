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
 * ����action�ĸ���
 * �̳������ӿڻ�ȡȫ�ֵ�session ��Ҫ��Ϊ�˷���ʵ��struts��������������
 * 
 * */
public class SuperAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,ServletContextAware{

	protected HttpServletRequest requset; //�������
	protected HttpServletResponse response;//��Ӧ����
	protected HttpSession session; //�ػ�����
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

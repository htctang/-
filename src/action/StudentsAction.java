package action;

import java.util.List;

import service.StudentsDAO;
import service.impl.StudentsDAOImpl;

import com.opensymphony.xwork2.ModelDriven;

import entity.Students;

public class StudentsAction extends SuperAction implements ModelDriven<Students>{


	private static final long serialVersionUID = 1L;
	private Students students = new Students();
	public String query(){
		StudentsDAO sdao = new StudentsDAOImpl();
		List<Students> list = sdao.queryAllStudents();
		//����session��
		if(list!=null&&list.size()>0){
			session.setAttribute("students_list", list);
		}
		return "query_success";
	}
	//ɾ��ѧ������
	public String delete(){
		StudentsDAO sdao = new StudentsDAOImpl();
		String sid = requset.getParameter("sid");
		sdao.deleteStudents(sid);
		return "delete_success";
	}
	public String add(){
		StudentsDAOImpl sdao = new StudentsDAOImpl();
		System.out.println(students.toString());
		sdao.addStudents(students);
		return "add_success";
	}
	@Override
	public Students getModel() {
		// TODO Auto-generated method stub
		return this.students;
	}
}

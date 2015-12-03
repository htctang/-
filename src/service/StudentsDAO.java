package service;

import java.util.List;

import entity.Students;

public interface StudentsDAO {
	
	//��ѯ����ѧ������
	public List<Students> queryAllStudents();
	//����ѧ����Ų�ѯѧ������
	public Students queryStudetsBySid(String sid);
	//���ѧ������
	public boolean addStudents(Students s);
	//�޸�ѧ������
	public boolean updataStudents(Students s);
	//ɾ��ѧ������
	public boolean deleteStudents(String sid);
}

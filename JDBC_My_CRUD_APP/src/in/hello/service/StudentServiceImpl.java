package in.hello.service;

import in.hello.daoFactory.StudentDaoFactory;
import in.hello.dto.Student;
import in.hello.persistence.StudentDao;

public class StudentServiceImpl implements StudentService {

	StudentDao stdDao=null;
	@Override
	public String createStudent(String name, Integer age, String addr) {
		
		stdDao = StudentDaoFactory.getStdDao();
	
		return stdDao.createStudent(name, age, addr);
	}

	@Override
	public Student readStudent(Integer id) {
		
		stdDao = StudentDaoFactory.getStdDao();
		return stdDao.readStudent(id);
	}

	@Override
	public String updateStudent(Integer id,String name,Integer age,String addr) {
		
		stdDao = StudentDaoFactory.getStdDao();
		return stdDao.updateStudent(id,name,age,addr);
	}

	@Override
	public String deleteStudent(Integer id) {
		
		stdDao = StudentDaoFactory.getStdDao();
		
		return stdDao.deleteStudent(id);
	}

}

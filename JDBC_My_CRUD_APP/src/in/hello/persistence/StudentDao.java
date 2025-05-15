package in.hello.persistence;

import in.hello.dto.Student;

public interface StudentDao {

	public String createStudent(String name,Integer age,String addr);
	public Student readStudent(Integer id);
	public String updateStudent(Integer id,String name,Integer age,String addr);
	public String deleteStudent(Integer id);
	
	
}

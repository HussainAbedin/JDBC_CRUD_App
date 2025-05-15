package in.hello.daoFactory;

import in.hello.persistence.StudentDao;
import in.hello.persistence.StudentDaoImpl;

public class StudentDaoFactory {
	
	private StudentDaoFactory(){
		
	}
	private static StudentDao stddao=null;

	
	public static StudentDao getStdDao(){
		if(stddao==null) {
		stddao = new StudentDaoImpl();
		}
	
		return stddao;
	}

}

package in.hello.daoService;

import in.hello.service.StudentService;
import in.hello.service.StudentServiceImpl;

public class StudentServiceFactory {
	
	private StudentServiceFactory(){
		
	}
	private static StudentService stdService=null;

	
	public static StudentService getStdService(){
		if(stdService==null) {
		stdService = new StudentServiceImpl();
		}
	
		return stdService;
	}

}

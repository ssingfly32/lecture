package ksh;

import java.util.ArrayList;

public class EmployeeTest {

	public static void main(String[] args) {
		Departments dept1 = new Departments(10, "개발부");
		
//		Permanent p1 = new Permanent("A001", "염세환", 10, 2000000);
//		위와 같이 말고 아래로... (다형성구현)
		dept1.addEmployees(new Permanent("A001", "염세환", 10, 2000000));
		dept1.addEmployees(new PartTimer("P001", "둘리", 10, 5, 10000));
	    dept1.addEmployees(new Permanent("A002", "김상희", 10, 2200000));
	    dept1.addEmployees(new PartTimer("P002", "도우너", 10, 14, 12000));
	    
	    dept1.getEmpList();
	}

}

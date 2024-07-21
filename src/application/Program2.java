package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		System.out.println("=== Teste 1: Department findById ===");
		Department dep = null;
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		
		
		dep = departmentDao.findById(8);
		if(dep != null) {
			System.out.println("Done! " + dep);
		} else {
			System.out.println("Error: Department wasn`t found!");
		}
		
		
		
		System.out.println("\n=== Teste 2: Department findAll ===");
		List<Department> list = departmentDao.findAll();
		if(list != null) {
			System.out.println("Done! " + list);			
		} else {
			System.out.println("Error: No Departments was found!");
		}
		
		
		
		System.out.println("\n=== Teste 3: Department deleteById ===");
		departmentDao.deleteById(5);
		System.out.println("Done! ");
		
		
		
		System.out.println("\n=== Teste 4: Department insert ===");
		Department department = new Department(null, "Sports");
		departmentDao.insert(department);
		System.out.println("Done! ");
		
		
		System.out.println("\n=== Teste 5: Department update ===");
		Department dpToChange = departmentDao.findById(9);
		dpToChange.setName("Clothes");
		departmentDao.update(dpToChange);
		System.out.println("Done! Department Changed");
	}

}

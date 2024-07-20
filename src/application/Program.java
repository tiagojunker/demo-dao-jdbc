package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
			
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("=== Test 1: Seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== Test 2: Seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> sellerList = sellerDao.findByDepartment(department);
		
		for (Seller obj: sellerList) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test 3: Seller findAll ===");
		List<Seller> sellerList2 = sellerDao.findAll();
		
		for (Seller obj: sellerList2) {
			System.out.println(obj);
		}
		

	}

}

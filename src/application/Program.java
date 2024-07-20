package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
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
		
		System.out.println("\n=== Test 4: Seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "Greg@gmail.com", new Date(), 4000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n=== Test 5: Seller Update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		seller.setEmail("martha@gmail.com");
		sellerDao.update(seller);
		System.out.println("Update Completed");
		
		System.out.println("\n=== Test 5: Seller Delete ===");
		System.out.println("Digite o Id do Usuário para deletar: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		sc.close();
	}

}

package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        Department department = new Department(2, null);

        System.out.println();
        System.out.println("=== TEST 2: seller findByDepartment ===");
        List<Seller> list = sellerDao.findByDepartment(department);
        list.forEach(System.out::println);

        System.out.println();
        System.out.println("=== TEST 3: seller findAll ===");
        List<Seller> list2 = sellerDao.findAll();
        list2.forEach(System.out::println);


        System.out.println();
        System.out.println("=== TEST 4: seller insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! new id: " + newSeller.getId());

        System.out.println();
        System.out.println("=== TEST 5: seller update ===");
        seller = sellerDao.findById(1);
        seller.setName("Bruce Wayne");
        seller.setBaseSalary(20000.0);
        sellerDao.update(seller);
        System.out.println("Update compelted!");
    }
}

package com.controller;

import java.util.List;
import java.util.Scanner;

import com.model.dto.Product;
import com.model.service.ProductBiz;

public class ProductController {
	
	Scanner sc = new Scanner(System.in);
	ProductBiz pdb = new ProductBiz();
	
	public List<Product> selectAll(){
		System.out.println("전체조회");
		return pdb.selectAll();
		
	}
	
	public Product selectOne() {
		
		System.out.print("Find Name: ");
		String p_name = sc.next();
		sc.nextLine();
		return pdb.selectOne(p_name);
		
	}
	
	public int insert() {
		
		System.out.print("ID: ");
		String id = sc.next();
		System.out.print("Name: ");
		String name = sc.next();
		System.out.print("Price: ");
		int price = sc.nextInt();
		System.out.print("Desc: ");
		String desc = sc.next();
		System.out.print("Stock: ");
		int stock = sc.nextInt();
		
		Product pd = new Product(id,name,price,desc,stock);
		
		return pdb.insert(pd);
		
	}
	
	public int update() {
		System.out.print("ID: ");
		String id = sc.next();
		System.out.print("Name: ");
		String name = sc.next();
		Product pd = new Product();
		pd.setProduct_id(id);
		pd.setP_name(name);
		
		return pdb.update(pd);
		
	}
	
	public int delete() {
		System.out.print("ID: ");
		String  product_id = sc.next();
		return pdb.delete(product_id);
		
	}
}

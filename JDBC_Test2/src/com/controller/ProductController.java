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

}

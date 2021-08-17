package com.view;

import java.util.List;
import java.util.Scanner;

import com.controller.ProductController;
import com.model.dto.Product;

public class ProductMenu {

	public static void view() {

		ProductController pdc = new ProductController();

		System.out.println("*** 메뉴 ***");
		System.out.println("1.전체 조회하기");
		System.out.println("2.상품 추가하기");
		System.out.println("3.상품 수정하기");
		System.out.println("4.상품 삭제하기");
		System.out.println("5.상품 검색하기");
		System.out.println("0. 프로그램 종료하기");

		int ipnum = -1;
		int result = 0;

		while (ipnum != 0) {
			
			Scanner sc = new Scanner(System.in);
			System.out.print("입력:");
			ipnum = sc.nextInt();

			switch (ipnum) {
			case 1:
				List<Product> list = pdc.selectAll();
				for(Product p:list) {
					System.out.println("id: "+ p.getProduct_id()+"name: " +p.getP_name()+"price: "+ p.getPrice()+"+desc: "+p.getDescription()+"+stock: " +p.getStock());
				}
				break;
			case 2:
				result = pdc.insert();
				if (result > 0) {
					System.out.println("isnert 성공");
				} else {
					System.out.println("insert 실패");
				}

				break;
			case 3:
				result = pdc.update();
				if(result>0) {
					System.out.println("update 성공");
				}else {
					System.out.println("update 실패");
				}
				
				break;
			case 4:
				result = pdc.delete();
				if(result>0) {
					System.out.println("delete 성공");
					
				}else {
					System.out.println("delete 실패");
				}
				
				break;
			case 5:
				Product p = pdc.selectOne();
				if(p != null) {
				System.out.println(p.getProduct_id() + p.getP_name());
				} else {
					System.out.println("x");
				}
					
				break;
			default:
				System.out.println("종료");
				break;
			}
		}

	}

}

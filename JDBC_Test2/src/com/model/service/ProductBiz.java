package com.model.service;

import java.sql.Connection;
import java.util.List;

import com.model.dao.ProductDao;
import com.model.dto.Product;
import static com.common.JDBCTemplate.*;

public class ProductBiz {

	ProductDao pdd = new ProductDao();

	public List<Product> selectAll() {

		Connection con = getConnection();
		return pdd.selectAll(con);

	}
	
	public Product selectOne(String p_name) {
		Connection con = getConnection();
		Product dto = pdd.selectOne(con, p_name);
		close(con);
		return dto;
		
	}

	public int insert(Product dto) {

		Connection con = getConnection();
		int res = pdd.insert(con, dto);

		if (res > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return res;
	}
	
	public int update(Product dto) {
		
		Connection con = getConnection();
		int res = pdd.update(con,dto);
		
		if(res>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return res;
	}
	
	public int delete(String product_id) {
		Connection con = getConnection();
		int res = pdd.delete(con,product_id);
		
		if(res>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		return res;
		
	}
}

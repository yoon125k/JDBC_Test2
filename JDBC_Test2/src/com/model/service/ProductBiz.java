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
}

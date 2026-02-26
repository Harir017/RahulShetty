package com.RahulShetty.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDBHelper {
public static int getProductQuantity(int productID) {
	int quantity = 0;
	try {
		String sql = "SELECT quantity FROM oc_product WHERE product_id = ?";
		
		PreparedStatement ps = DBUtils.getConnection().prepareStatement(sql);
		ps.setInt(1, productID);
		
		ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            quantity = rs.getInt("quantity");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return quantity;
	}
}


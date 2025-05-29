package com.data.repository;

import com.data.connection.ConnectionDB;
import com.data.model.Categories_en;
import com.data.model.Categories_vi;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CategoryRepositoryImp implements CategoryRepository {

    @Override
    public boolean addCategoryVI(Categories_vi categoriesVi) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call add_category_vi(?,?)}");
            callSt.setString(1, categoriesVi.getCategoryName());
            callSt.setString(2, categoriesVi.getDescription());
            boolean result = callSt.execute();
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }
        return false;
    }

    @Override
    public boolean addCategoryEN(Categories_en categoriesEn) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call add_category_en(?,?)}");
            callSt.setString(1, categoriesEn.getCategoryName());
            callSt.setString(2, categoriesEn.getDescription());
            boolean result = callSt.execute();
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }
        return false;
    }

    @Override
    public List<Map<String, Object>> getAllCategories() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Map<String, Object>> listCategories = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_all()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", rs.getInt("id"));
                map.put("categoryName_vi", rs.getString("categoryName_vi"));
                map.put("description_vi", rs.getString("description_vi"));
                map.put("categoryName_en", rs.getString("categoryName_en"));
                map.put("description_en", rs.getString("description_en"));
                listCategories.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }
        return listCategories;
    }
}

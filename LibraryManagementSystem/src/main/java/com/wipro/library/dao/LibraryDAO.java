package com.wipro.library.dao;

import com.wipro.library.bean.LibraryBean;
import com.wipro.library.util.DBUtil;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class LibraryDAO {

    public String createRecord(LibraryBean bean) {
        String id = bean.getRecordId();
        try {
            Connection con = DBUtil.getDBConnection();
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO LIBRARY_TB VALUES(?,?,?,?,?,?,?)");

            ps.setString(1, bean.getRecordId());
            ps.setString(2, bean.getBookTitle());
            ps.setString(3, bean.getAuthor());
            ps.setString(4, bean.getCategory());
            ps.setInt(5, bean.getPublishedYear());
            ps.setDate(6, new java.sql.Date(bean.getAddedDate().getTime()));
            ps.setString(7, bean.getRemarks());

            int result = ps.executeUpdate();
            if (result > 0)
                return id;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "FAIL";
    }

    public LibraryBean fetchRecord(String title, java.util.Date addedDate) {
        LibraryBean bean = null;
        try {
            Connection con = DBUtil.getDBConnection();
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM LIBRARY_TB WHERE BOOKTITLE=? AND ADDED_DATE=?");

            ps.setString(1, title);
            ps.setDate(2, new java.sql.Date(addedDate.getTime()));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                bean = new LibraryBean();
                bean.setRecordId(rs.getString(1));
                bean.setBookTitle(rs.getString(2));
                bean.setAuthor(rs.getString(3));
                bean.setCategory(rs.getString(4));
                bean.setPublishedYear(rs.getInt(5));
                bean.setAddedDate(rs.getDate(6));
                bean.setRemarks(rs.getString(7));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public String generateRecordID(String title, java.util.Date date) {
        String id = "";
        try {
            Connection con = DBUtil.getDBConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT LIBRARY_SEQ.NEXTVAL FROM DUAL");

            int seq = 0;
            if (rs.next())
                seq = rs.getInt(1);

            DateFormat df = new SimpleDateFormat("yyyyMMdd");
            String temp = df.format(date);

            String prefix = title.substring(0, 2).toUpperCase();

            id = temp + prefix + String.format("%02d", seq);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public boolean recordExists(String title, java.util.Date date) {
        return fetchRecord(title, date) != null;
    }

    public List<LibraryBean> fetchAllRecords() {
        List<LibraryBean> list = new ArrayList<>();
        try {
            Connection con = DBUtil.getDBConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM LIBRARY_TB");

            while (rs.next()) {
                LibraryBean bean = new LibraryBean();
                bean.setRecordId(rs.getString(1));
                bean.setBookTitle(rs.getString(2));
                bean.setAuthor(rs.getString(3));
                bean.setCategory(rs.getString(4));
                bean.setPublishedYear(rs.getInt(5));
                bean.setAddedDate(rs.getDate(6));
                bean.setRemarks(rs.getString(7));
                list.add(bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

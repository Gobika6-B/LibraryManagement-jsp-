package com.wipro.library.service;

import com.wipro.library.bean.LibraryBean;
import com.wipro.library.dao.LibraryDAO;
import com.wipro.library.util.InvalidInputException;

import java.util.Date;
import java.util.List;

public class Administrator {

    LibraryDAO dao = new LibraryDAO();

    public String addRecord(LibraryBean bean) {

        try {
            if (bean == null || bean.getBookTitle() == null || bean.getAddedDate() == null)
                throw new InvalidInputException();

            if (bean.getBookTitle().length() < 2)
                return "INVALID BOOK TITLE";

            Date date = bean.getAddedDate();
            if (date == null)
                return "INVALID DATE";

            if (dao.recordExists(bean.getBookTitle(), date))
                return "ALREADY EXISTS";

            String id = dao.generateRecordID(bean.getBookTitle(), date);
            bean.setRecordId(id);

            return dao.createRecord(bean);

        } catch (InvalidInputException e) {
            return "INVALID INPUT";
        }
    }

    public LibraryBean viewRecord(String title, Date date) {
        return dao.fetchRecord(title, date);
    }

    public List<LibraryBean> viewAllRecords() {
        return dao.fetchAllRecords();
    }
}

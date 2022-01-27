package com.example.lab_5.DataPackage;

import android.app.Application;

import java.util.List;

public class MyRepository {
    private static List<ItemData> dataList;
    private static MyDao myDao;
    private static MyDB db;

    public MyRepository(Application context) {
        db = MyDB.getDatabase(context);
        myDao = db.myDao();

    }
    public List<ItemData> getDataList() {
        return myDao.getAllData();
//        dataList = myDao.getAllData();
//        return dataList;
    }
    public void insertItem(ItemData item) { myDao.insert(item); }
    public void deleteItem(ItemData item) {
        myDao.delete(item);
    }
}

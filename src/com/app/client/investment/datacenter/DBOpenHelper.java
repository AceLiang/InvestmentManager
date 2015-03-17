package com.app.client.investment.datacenter;


import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.app.client.investment.entity.Member;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DBOpenHelper extends OrmLiteSqliteOpenHelper {

	public static final String DATABASE_NAME = "investmentManager.db";  
	public static final int DATABASE_VERSION = 1; 
    
	private Dao<Member, Integer> menberDao = null;
	
	public DBOpenHelper(Context context){  
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
    } 
	    
	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {		
		try {  
            TableUtils.createTableIfNotExists(connectionSource, Member.class);  

        } catch (Exception e) {  
            e.printStackTrace();  
        }
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int oldVer,
			int newVer) {
		try {  
            TableUtils.dropTable(connectionSource, Member.class, true);  
            
            onCreate(sqLiteDatabase, connectionSource);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
	}

	public Dao<Member, Integer> getMemberDao() throws SQLException {
		if(menberDao == null) {
			menberDao = getDao(Member.class);
		}
		return menberDao;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		super.close();
	}

}

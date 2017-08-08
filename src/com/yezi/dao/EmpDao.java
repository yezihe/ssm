package com.yezi.dao;



import java.util.Date;

import com.yezi.pojo.Emp;
import com.yezi.util.Pager;

public interface EmpDao {
	void add(Emp emp);
	void modify(Emp emp);
	void remove(Emp emp);
	
	Emp find(Integer empno);
	
	Pager<Emp> pager(Integer page,Integer rows,String sort,String order,String ename,Date beginDate,Date endDate);

}

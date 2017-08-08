package com.yezi.service;

import java.util.Date;

import com.yezi.pojo.Emp;
import com.yezi.util.Condition;
import com.yezi.util.Pager;

public interface EmpService {
	
	void add(Emp emp);
	void modify(Emp emp);
	void remove(Emp emp);
	
	Emp find(Integer empno);
	
	Pager<Emp> pager(Integer page,Integer rows,String sort,String order,String ename,Date beginDate,Date endDate);
}

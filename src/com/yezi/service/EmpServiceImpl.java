package com.yezi.service;

import java.util.Date;

import com.yezi.dao.EmpDao;
import com.yezi.pojo.Emp;
import com.yezi.util.Condition;
import com.yezi.util.Pager;

public class EmpServiceImpl implements EmpService {
	private EmpDao empDao;

	@Override
	public void add(Emp emp) {
		empDao.add(emp);

	}

	@Override
	public void modify(Emp emp) {
		empDao.modify(emp);

	}

	@Override
	public void remove(Emp emp) {
		empDao.remove(emp);

	}

	@Override
	public Emp find(Integer empno) {
		
		return empDao.find(empno);
	}

	

	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}

	@Override
	public Pager<Emp> pager(Integer page, Integer rows, String sort, String order, String ename, Date beginDate,
			Date endDate) {
		
		return empDao.pager(page, rows, sort, order, ename, beginDate, endDate);
	}
	
	

}

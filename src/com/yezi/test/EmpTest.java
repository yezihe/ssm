package com.yezi.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yezi.pojo.Emp;
import com.yezi.service.EmpService;
import com.yezi.util.Pager;

public class EmpTest {

	
	public static void main(String[] args) {
		Integer page=2;
		Integer rows=3;
		String sort="empno";
		String order="asc";
		String ename="";
		Date beginDate=null;
		Date endDate=null;
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		EmpService empService=ctx.getBean("empService", EmpService.class);
		
		Pager<Emp> pager=empService.pager(page, rows, sort, order, ename,beginDate,endDate);
		System.out.println("记录总数:" + pager.getTotal());
	    for (Emp emp : pager.getRows()) {
	      System.out.println(emp.getEmpno()+"  "+emp.getEname()+"  "+emp.getDept().getDname());
	    }
	}

}

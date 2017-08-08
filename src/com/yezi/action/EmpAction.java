package com.yezi.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.util.NumberUtils;

import com.yezi.pojo.Dept;
import com.yezi.pojo.Emp;
import com.yezi.service.EmpService;
import com.yezi.util.JsonDateValueProcessor;
import com.yezi.util.JsonDeptValueProcessor;
import com.yezi.util.Pager;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class EmpAction {
	private EmpService empService;
	
	
	
	public String list(){
		 // 1.从上下文中获取 request 对象和 response 对象(请求/响应)
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpServletResponse res=ServletActionContext.getResponse();
		//2.接收表单数据
		 // 2.1 以下四个参数是 easyui提供的参数 (必需)
	    // 当前第几页
		Integer page=NumberUtils.parseNumber(req.getParameter("page"), Integer.class);
		 // 一页显示几行数据
		Integer rows=NumberUtils.parseNumber(req.getParameter("rows"), Integer.class);
		 // 排序字段
		String sort=req.getParameter("sort");
		 // 排序方式 (升序 / 降序 )
		String order=req.getParameter("order");
		 // 2.2 多条件查询的参数 (可选)
		String ename=req.getParameter("ename");
		
		String begin=req.getParameter("beginDate");
		String end=req.getParameter("endDate");
		
		Date beginDate=null;
		Date endDate=null;
		
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		if(!StringUtils.isEmpty(begin) &&!StringUtils.isEmpty(end)){
			try {
				beginDate=sdf.parse(begin+"00:00:00");
				endDate=sdf.parse(end+"23:59:59");
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
		Pager<Emp> pager=empService.pager(page, rows, sort, order, ename,beginDate,endDate);
		
		//把分页数据转换成json
		
		JsonConfig jc=new JsonConfig();
		
		// 排除某些字段,不显示到 json 数据中
		//jc.setExcludes(new String[] {"dept"});
		
		// 日期属性和对象属性必需处理;否则抛异常: net.sf.json.JSONException: There is a cycle in the
	    // hierarchy!
		
		jc.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor("yyyy-MM-dd HH:mm:ss"));
		jc.registerJsonValueProcessor(Dept.class, new JsonDeptValueProcessor());
		
		JSON json=JSONSerializer.toJSON(pager,jc);
		
		// 5.json数据响应给 easyui
		try {
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out=res.getWriter();
			out.println(json.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	

	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}
	
	

}

package com.yezi.dao;



import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.util.StringUtils;

import com.yezi.pojo.Emp;
import com.yezi.util.Pager;

public class EmpDaoInpl extends HibernateDaoSupport implements EmpDao{

	@Override
	public void add(Emp emp) {
		this.getHibernateTemplate().save(emp);
		
	}

	@Override
	public void modify(Emp emp) {
		this.getHibernateTemplate().update(emp);
		
	}

	@Override
	public void remove(Emp emp) {
		this.getHibernateTemplate().delete(emp);
		
	}

	@Override
	public Emp find(Integer empno) {
		
		
		return (Emp) this.getHibernateTemplate().get(Emp.class, empno);
	}

	
	@Override
	public Pager<Emp> pager(final Integer page,final Integer rows,final String sort,final String order,final String ename, final Date beginDate,final Date endDate) {
		/*String temp="from Emp e inner join fetch e.dept d where 1=1";
		if(!StringUtils.isEmpty(ename)){
			temp+=" and ename like :ename";
		}
		if(beginDate!=null && endDate!=null){
			temp+=" and hiredate between :beginDate and :endDate";
		}
		final String hql=temp;
		return this.getHibernateTemplate().
				executeWithNativeSession(new HibernateCallback<Pager<Emp>>() {

					@SuppressWarnings("unchecked")
					@Override
					public Pager<Emp> doInHibernate(Session session) throws HibernateException {
						
						Pager<Emp> pager=new Pager<Emp>();
						
						Query query=session.createQuery(hql);
						if(!StringUtils.isEmpty(ename)){
							query.setString("ename","%"+ ename+"%");
							
						}
						if(beginDate!=null && endDate!=null){
							query.setDate("beginDate", beginDate);
							query.setDate("endDate", endDate);
						}
						pager.setTotal(query.list().size());
						
						query.setFirstResult((page-1)*rows);
						query.setMaxResults(rows);
						
						
						pager.setRows(query.list());
						return pager;
					}
		});*/
		
		return this.getHibernateTemplate().
				executeWithNativeSession(new HibernateCallback<Pager<Emp>>() {

					@Override
					public Pager<Emp> doInHibernate(Session session) throws HibernateException {
						Pager<Emp> pager=new Pager();
						Criteria c=session.createCriteria(Emp.class);
						
						if(!StringUtils.isEmpty(ename)){
							c.add(Restrictions.like("like", "%"+ename+"%"));							
						}
						if(!StringUtils.isEmpty(beginDate) && !StringUtils.isEmpty(endDate)){
							c.add(Restrictions.between("hiredate", beginDate, endDate));
						}
						c.setFetchMode("dept", FetchMode.EAGER);
						
						pager.setTotal(c.list().size());
						c.setFirstResult((page-1)*rows);
						c.setMaxResults(rows);
						pager.setRows(c.list());
						
						return pager;
					}
		});
	}

}

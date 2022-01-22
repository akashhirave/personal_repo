package com.jbk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.jbk.entity.Country;
import com.jbk.entity.Emplyoee;
import com.jbk.entity.Register;

@Repository
@Component
public class EmployeeDAO implements EmployeeDaoInterface
{

	@Autowired
	SessionFactory sessionFactory;

	public String AddCountry(Country c) {

		Session session=sessionFactory.openSession();

		Transaction transaction=session.beginTransaction();

		int i=(int)session.save(c);
		transaction.commit();

		if(i>0) {
			return "Country "+c.getCid()+" Addedd Successfully";
		}else {
			return "Something Went Wrong!!";
		}


	}

	public List<Country> GetAllCountry(){
		Session session=sessionFactory.openSession();

		List<Country> list= session.createCriteria(Country.class).list();

		return list;		

	}


	public String UpdateCountry(Country c) {
		Session session=sessionFactory.openSession();

		Transaction transaction=session.beginTransaction();

		session.saveOrUpdate(c);

		transaction.commit();

		return "Country "+c.getCid()+" update successfully...";

	}

	public String DeleteCountry(String cname) {
		Session session=sessionFactory.openSession();

		Transaction transaction=session.beginTransaction();

		Criteria criteria=session.createCriteria(Country.class);
		criteria.add(Restrictions.eq("cname", cname));
		Country country=(Country) criteria.uniqueResult();

		session.delete(country);
		transaction.commit();

		return "Country "+cname+" is Deleted";

	}




	public Country GetParticularCountry(Integer cid) {
		Session session=sessionFactory.openSession();

		Criteria criteria=session.createCriteria(Country.class);
		criteria.add(Restrictions.eq("cid", cid));
		Country c=(Country)criteria.uniqueResult();

		return c;		
	}

	public String AddEmployee( Emplyoee e) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(e);
		Register r= new Register();
		r.setMail(e.getName()+"@gmail.com");
		r.setPassword(e.getPhoneno());
		session.save(r);
		
		transaction.commit();

		return "Employee "+e.getId()+" Addedd Successfully";


	}

	public List<Emplyoee> getAllEmployee(){
		Session session=sessionFactory.openSession();

		List<Emplyoee> list= session.createCriteria(Emplyoee.class).list();

		return list;

	}

	public String updateEmployee(Emplyoee e) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();

		session.saveOrUpdate(e);
		tx.commit(); 

		return "Employee "+e.getId()+" Updated successfully...";

 
	}

	public String deleteEmployee(Integer id) {

		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();

		Criteria criteria=session.createCriteria(Emplyoee.class);
		criteria.add(Restrictions.eq("id", id));
		

		Emplyoee e=(Emplyoee) criteria.uniqueResult();
		session.delete(e);

		String mail=e.getName()+"@gmail.com";
		Criteria criteria2=session.createCriteria(Register.class);
		criteria2.add(Restrictions.eq("mail", mail));
		Register rs=(Register) criteria2.uniqueResult();
		session.delete(rs);
		
		tx.commit();
		return "Employee "+e.getName()+" is Deleted";

	}

	public Emplyoee getParticularEMP(Integer id) {
		Session session=sessionFactory.openSession();

		Criteria criteria=session.createCriteria(Emplyoee.class);

		criteria.add(Restrictions.eq("id", id));

		Emplyoee e=(Emplyoee)criteria.uniqueResult();

		return e;

	}

	public Emplyoee loginCheck(Register reg) {
		Session session=sessionFactory.openSession();
		Emplyoee e=null;
		Criteria criteria=session.createCriteria(Register.class);

		criteria.add(Restrictions.eq("mail", reg.getMail()));
//		criteria.add(Restrictions.eq("password", reg.getPassword()));
		Object obj=criteria.uniqueResult();
		if(obj!=null) {
			String name=reg.getMail().replaceAll("@gmail.com", "");
			Session session2=sessionFactory.openSession();
			Criteria criteria2=session2.createCriteria(Emplyoee.class);
			criteria2.add(Restrictions.eq("name", name));
			e=(Emplyoee)criteria2.uniqueResult();
		}
			
		return e;
	}








}

package com.te.DynamicAssignment;

import com.te.NewHibernate.bean.Products;
//import java.sql.Date;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;

import java.security.PublicKey;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.internal.StaticFilterAliasGenerator;
public class ProductManagementReadAll {
	
		Products products=new Products();
		 EntityManagerFactory factory=null;
		 EntityManager manager=null;
	public void readAll() {
		  try {
			factory=Persistence.createEntityManagerFactory("ProductData");
			  manager=factory.createEntityManager();
			   String readAll="from Products";
			   Query query=manager.createQuery(readAll);
			    
			   List <Products> list=query.getResultList();
			   for (Products products2 : list) {
				System.err.println(products2);
			}
			   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(factory!=null) {
				factory.close();
			}
			if(manager!=null) {
				manager.close();
			}
		}
		}
		}

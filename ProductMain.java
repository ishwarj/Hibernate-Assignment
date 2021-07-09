package com.te.DynamicAssignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.te.NewHibernate.bean.Products;

public class ProductMain {
	public static void main(String[] args) {
		ProductManagementReadAll management=new ProductManagementReadAll();
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter 1 for ReadallData"+"enter 2 for update"
		+"enter 3 for update by id"+"enter 4 for delete");
		int i=scanner.nextInt();
		if(i==1) {
			management.readAll();
		}

		else if(i==2) {
			
		Products products=new Products();
		 EntityManagerFactory factory=null;
		 EntityManager manager=null;
		int in=scanner.nextInt();
		if(in==1 || in==2 || in==3 || in==4 || in==5) {
					try {
						factory=Persistence.createEntityManagerFactory("ProductData");
						  manager=factory.createEntityManager();
						   String readData="from Products where id= :id";
						   Query query=manager.createQuery(readData);
						   
			              query.setParameter("id",Integer.parseInt(args[0]));
			              
						   Products products2=(Products)query.getSingleResult();
						   System.out.println(products.getId());
						   System.out.println(products.getPname());
						   System.out.println(products.getPprice());
//				   System.out.println(products.getDate());			
					} catch (NumberFormatException e) {
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
	
		
			else if(i==3) {
		
					 EntityManagerFactory factory=null;
					 EntityManager manager=null;

					  try {
						factory=Persistence.createEntityManagerFactory("ProductData");
						  manager=factory.createEntityManager();
						   String updateData="update Products set pname= :pname,pprice= :pprice,id= :id";
						   Query query=manager.createQuery(updateData);
						   
						query.setParameter("pname", args[0]);
						query.setParameter("pprice",Double.parseDouble(args[1]));
						query.setParameter("id",Integer.parseInt(args[2]));
						  
						   
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
				else if(i==4) {
			
			 EntityManagerFactory factory=null;
			 EntityManager manager=null;

			  try {
				factory=Persistence.createEntityManagerFactory("ProductData");
				  manager=factory.createEntityManager();
				   
			    String delete = "delete from Employee where empid = :empid";
			    Query query = manager.createQuery(delete);
			   query.setParameter("id", Integer.parseInt(args[0]));
			   int result = query.executeUpdate();
			   System.out.println("Data Delete SucessFully");

				}
			   catch (Exception e) {
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
}

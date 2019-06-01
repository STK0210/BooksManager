package com.lky.one.test;

import javax.persistence.*;

import com.lky.one.jpa.User;

import java.util.*;

public class Client {

	public static void main(String[] args) throws Exception {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BooksManager", null);
		EntityManager manager = factory.createEntityManager();
		try {
			User user = new User();
			user.setUname("JPAName");
			user.setPassword("JPAPassword");

			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(user);
			transaction.commit();
		} finally {
			manager.close();
			factory.close();
		}
	}

	public static void testsave1(EntityManager manager) {
		User user = new User();
		user.setUname("JPAName");
		user.setPassword("JPAPassword");

		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(user);
		transaction.commit();
	}

	public static void showAll(EntityManager manager) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Query q = manager.createQuery("SELECT u FROM User u");
		List results = q.getResultList();
		transaction.commit();
		Iterator it = results.iterator();
		while (it.hasNext()) {
			User user = (User) it.next();
			System.out.print(user.getPassword() + "\t");
			System.out.print(user.getUname() + "\t");
		}
	}
	
	public static void TestGit() {
		System.out.println("gitTest");
	}
}

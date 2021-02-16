package dev.fun.examples.hiber;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CrudDataAccess<E, T extends Serializable> {
	
	static final class SessionFactoryConfig {
		public static final SessionFactory sessionFactory;
		
		static {
			sessionFactory = new Configuration()
					.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
					.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
					.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres")
					.setProperty("hibernate.default_schema", "hibernate")
					.setProperty("hibernate.connection.username", "postgres")
					.setProperty("hibernate.connection.password", "password")
					.setProperty("hibernate.show_sql", "true")
					.addAnnotatedClass(User.class)
					.buildSessionFactory();
		}
		
		private SessionFactoryConfig() {
			
		}
	}
	
	private final Class<E> entityClass;
	
	public Class<E> getEntityClass() {
		return entityClass;
	}
	
	public CrudDataAccess(Class<E> entityClass) {
		this.entityClass = entityClass;
	}
	
	public void create(E entity) {
		Session session = SessionFactoryConfig.sessionFactory.openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		session.close();
	}
	
	public E read(T id) {
		Session session = SessionFactoryConfig.sessionFactory.openSession();
		E entity = session.get(entityClass, id);
		session.close();
		return entity;
	}
	
	public void update(E entity) {
		Session session = SessionFactoryConfig.sessionFactory.openSession();
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();
		session.close();
	}
	
	public void delete(E entity) {
		Session session = SessionFactoryConfig.sessionFactory.openSession();
		session.beginTransaction();
		session.delete(entity);
		session.getTransaction().commit();
		session.close();
	}
	
}

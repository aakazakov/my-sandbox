package dev.fun.examples.hiber;

public class Crud {
	
	public static void main(String[] args) {
		CrudDataAccess<User, Long> dao = new CrudDataAccess<>(User.class);
		
//		dao.create(new User("user1", "pass1"));
//		dao.create(new User("user2", "pass2"));
//		dao.create(new User("user3", "pass3"));
		
//		User up = dao.read(1L);		
//		System.out.println(up);
//		
//		up.setName("updated");
//		dao.update(up);
//		System.out.println(dao.read(1L));
		
		User del = dao.read(2L);
		dao.delete(del);
		
	}
	
}

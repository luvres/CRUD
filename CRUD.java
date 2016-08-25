package persistence;

import java.util.ArrayList;

public class CRUD extends DaoMariaDB{
	
	public void create(User u)throws Exception{
		open();
		stmt = con.prepareStatement("insert into usuario values(null,?,?)");
		stmt.setString(1, u.getNome());
		stmt.setString(2, u.getEmail());
		stmt.execute();
		close();
	}
	
	public List<User> read()throws Exception{
		open();
		stmt = con.prepareStatement("select * from usuario");
		rs = stmt.executeQuery();
		List<User> list = new ArrayList<User>();
		while(rs.next()){
			User u = new User();
			u.setId(rs.getInt(1));
			u.setNome(rs.getString(2));
			u.setEmail(rs.getString(3));
			list.add(u);
		}
		close();
		return list;
	}
	
	public void update(User u)throws Exception{
		open();
		stmt = con.prepareStatement("update usuario set nome=?,email=? where id=?");
		stmt.setString(1, u.getNome());
		stmt.setString(2, u.getEmail());
		stmt.setInt(3, u.getId());
		stmt.execute();
		close();
	}
	
	public void delete(int id)throws Exception{
		open();
		stmt = con.prepareStatement("delete from usuario where id=?");
		stmt.setInt(1, id);
		stmt.execute();
		close();
	}
	
	
	public static void main(String[] args) {
		//createUser();
		readUser();
		//updateUser();
		//deleteUser();
	}
	
	private static void createUser(){
		User u = new User(null, "Leonardo Loures", "luvres@izone.com");
		try {
			
			new CRUD().create(u);
			System.out.println("Usuario Gravado!");
			
			List<User> list = new CRUD().read();
			System.out.println(list);
			
		} catch (Exception e) {
			System.out.println("Error ... " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static void readUser(){
		try {
			
			List<User> list = new CRUD().read();
			System.out.println(list);
			
		} catch (Exception e) {
			System.out.println("Error ... " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static void updateUser(){
		User u = new User(1, "1uvr3z", "1uvr3z@gmail.com");
		try {
			
			new CRUD().update(u);
			System.out.println("Usuario Alterado!");
			
		} catch (Exception e) {
			System.out.println("Error ... " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static void deleteUser(){
		try {
			
			new CRUD().delete(1);
			System.out.println("Usuario Excluido!");
			
		} catch (Exception e) {
			System.out.println("Error ... " + e.getMessage());
			e.printStackTrace();
		}
	}

}


package entity;

public class User {
	
	private Integer id;
	private String nome;
	private String email;
	
	public User() {
	}
	public User(Integer id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", nome=" + nome + ", email=" + email + "]";
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}


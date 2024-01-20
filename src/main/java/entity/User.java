package entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private int id;
	private String username;
	private String password;
	private String gender;
	private String hobby;
	
	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public User(String username, String password, String gender, String hobby) {
		super();
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.hobby = hobby;
	}
	
}

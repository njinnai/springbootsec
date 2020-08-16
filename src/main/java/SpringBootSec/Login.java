 
import java.io.Serializable;
 
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
import javax.persistence.Entity;
 
 
@Entity
@Table(name="login", schema="public")
public class Login implements Serializable {
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
	private Integer id;


    @Column(name="password")
    private String password;
     
    @Column(name="name")
    private String name;


	public Integer getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}

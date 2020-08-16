 
import java.util.Collection;
 
import org.springframework.security.core.GrantedAuthority;
 
 
 
public class LoginUser extends org.springframework.security.core.userdetails.User {
 
    private static final long serialVersionUID = 1L;
 
    private Integer id;
    private String name;     
    private String password;
     
    public LoginUser(Integer id, String name, String password, Collection<? extends GrantedAuthority> authorities) {
        super(name, password, authorities);
        this.id = id;
        this.name = name;
        this.password = password;
    }
}

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private LoginRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public LoginUser loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || "".equals(username)) {
            throw new UsernameNotFoundException("Username is empty");
        }

        Optional<Login> user = repository.findByName(username);
        if (user.isEmpty() || user.get() == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

	Login u = user.get();
	LoginUser lu = new LoginUser(u.getId(), u.getName(), u.getPassword(), null);
        //return user;
	return lu;
    }

    //adminを登録するメソッド
    //@Transactional
    //public void registerAdmin(String username, String password, String mailAddress) {
    //    Account user = new Account(username, passwordEncoder.encode(password), mailAddress);
    //    user.setAdmin(true);
    //    repository.save(user);
    //}

    //管理者を登録するメソッド
    //@Transactional
    //public void registerManager(String username, String password, String mailAddress) {
    //    Account user = new Account(username, passwordEncoder.encode(password), mailAddress);
    //    user.setManager(true);
    //    repository.save(user);
    //}

    //一般ユーザを登録するメソッド
    //@Transactional
    //public void registerUser(String username, String password, String mailAddress) {
    //    Account user = new Account(username, passwordEncoder.encode(password), mailAddress);
    //    repository.save(user);
    //}

}

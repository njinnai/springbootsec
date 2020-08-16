import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginService loginService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //TODO: 最低限の実装。cssなどのstaticファイルなどの許可を追加する必要あります。
        http
                .authorizeRequests()
                .antMatchers("/login", "/login-error").permitAll()
                .antMatchers("/**").hasRole("USER")
                .and()
                .formLogin()
                .loginPage("/login").failureUrl("/login-error");
    }


    //変更点 PasswordEncoder(BCryptPasswordEncoder)メソッド
    @Bean
    public PasswordEncoder passwordEncoder() {
        //
        return new BCryptPasswordEncoder();
    }

}



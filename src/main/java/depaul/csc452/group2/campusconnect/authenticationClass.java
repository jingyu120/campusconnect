package depaul.csc452.group2.campusconnect;


        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.beans.factory.annotation.Qualifier;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
        import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
        import org.springframework.security.config.annotation.web.builders.HttpSecurity;
        import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
        import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
        import org.springframework.security.core.userdetails.UserDetailsService;
        import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
        import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity

public class authenticationClass extends WebSecurityConfigurerAdapter {

    @Autowired
    private accessFailedHandler loginFailedHandler;

    @Autowired
    private userInfo newUserInfo;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**.css").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/access-denied").permitAll()
                .antMatchers("/**").hasRole("USER")

                .and()
                .formLogin().loginPage("/login").permitAll().and()
                .exceptionHandling().accessDeniedHandler(accessFailedHandler);
        http.csrf().disable(); 
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.authenticationProvider(dbAuthProvider());
    }

    public DaoAuthenticationProvider dbAuthProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userInfo);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

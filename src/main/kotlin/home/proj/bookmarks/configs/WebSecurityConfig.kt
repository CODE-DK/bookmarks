package home.proj.bookmarks.configs

import home.proj.bookmarks.services.UserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService

@Configuration
@EnableWebSecurity
open class WebSecurityConfig(private val userService: UserService) : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http
            .authorizeRequests()
                .antMatchers("/", "/home", "/register").permitAll()
                .anyRequest()
                .authenticated()
            .and()
                .formLogin()
                .loginPage("/login").permitAll()
            .and()
                .logout()
                .permitAll()
    }

    @Bean
    override fun userDetailsService(): UserDetailsService {
        return userService
    }
}
package com.shopion.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/notice/**").hasRole("USER")
                .antMatchers("/wordDict/**").hasRole("USER")
                .antMatchers("/manager/**").hasRole("MANAGER")
        ;

        http.formLogin();
        http.csrf().disable();
        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");

        /*
        http
            .formLogin()
            .usernameParameter("userId")
            .passwordParameter("passwd")
            .successHandler((request, response, authentication) -> {
                response.sendRedirect("/");
            })
            .failureHandler((request, response, exception) -> {
                response.sendRedirect("/login");
                // 참고로 스프링 시큐리티가 제공하는 로그인 페이지 주소는
                // "/login"이다.
            })
            .permitAll();


    	// 여기서부터 로그아웃 API 내용~!
        http.logout()
            .logoutUrl("/logout")   // 로그아웃 처리 URL (= form action url)
            //.logoutSuccessUrl("/login") // 로그아웃 성공 후 targetUrl,
            // logoutSuccessHandler 가 있다면 효과 없으므로 주석처리.
            .addLogoutHandler((request, response, authentication) -> {
                // 사실 굳이 내가 세션 무효화하지 않아도 됨.
                // LogoutFilter가 내부적으로 해줌.
                HttpSession session = request.getSession();
                if (session != null) {
                    session.invalidate();
                }
            })  // 로그아웃 핸들러 추가
            .logoutSuccessHandler((request, response, authentication) -> {
                response.sendRedirect("/login");
            }) // 로그아웃 성공 핸들러
            .deleteCookies("remember-me"); // 로그아웃 후 삭제할 쿠키 지정
         */
    }
}

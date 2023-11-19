package by.pvt.musicproject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable).httpBasic(Customizer.withDefaults()).authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/user/addUser").permitAll()
                .requestMatchers("/user/login").permitAll()
                .requestMatchers(HttpMethod.GET,"/user/create").authenticated()
                .requestMatchers(HttpMethod.POST,"/user/**").authenticated()
                .requestMatchers(HttpMethod.DELETE,"/user/**").hasAuthority("ADMIN")
                .requestMatchers("/user/file").authenticated()
                .requestMatchers("/user/addTrack").authenticated()
                .requestMatchers(HttpMethod.GET,"/user/**").hasAuthority("ADMIN")
                .requestMatchers("/user/**").authenticated()
                .requestMatchers("/producer/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.GET,"/album/**").authenticated()
                .requestMatchers("/album/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE,"/track/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST,"/track/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.GET,"/track/**").authenticated()
                .requestMatchers(HttpMethod.GET,"/rating/**").permitAll()
                .requestMatchers("/rating/**").authenticated()
                .requestMatchers(HttpMethod.DELETE,"/performer/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST,"/performer/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.GET,"/performer/**").authenticated());
        return http.build();
    }
}

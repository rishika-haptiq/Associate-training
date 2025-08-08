//package com.example.blogapi;
//
//import com.example.blogapi.entity.Role;
//import com.example.blogapi.entity.User;
//import com.example.blogapi.entity.Post;
//import com.example.blogapi.repository.UserRepository;
//import com.example.blogapi.repository.PostRepository;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.CommandLineRunner;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@SpringBootApplication
//public class BlogapiApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(BlogapiApplication.class, args);
//	}
//
//	@Bean
//	CommandLineRunner runner(UserRepository userRepo, PostRepository postRepo, PasswordEncoder encoder) {
//		return args -> {
//
//			if (userRepo.findByUsername("admin").isEmpty()) {
//				User admin = new User();
//				admin.setUsername("admin");
//				admin.setPassword(encoder.encode("adminpass"));
//				admin.setRole(Role.ADMIN);
//				userRepo.save(admin);
//			}
//
//			if (postRepo.count() == 0) {
//				Post p1 = new Post();
//				p1.setTitle("Welcome to Blog");
//				p1.setContent("This is the first blog post.");
//				postRepo.save(p1);
//			}
//		};
//	}
//}


package com.example.blogapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogapiApplication.class, args);
	}
}


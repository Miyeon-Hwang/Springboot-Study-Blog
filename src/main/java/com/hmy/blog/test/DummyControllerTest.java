package com.hmy.blog.test;

import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.aspectj.apache.bcel.classfile.Module.Require;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hmy.blog.model.RoleType;
import com.hmy.blog.model.User;
import com.hmy.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {
	
	@Autowired // DI (스프링이 component scan할 때  UserRepository 객체를 생성해서 가지고있으므로 걔를 가져와서 사용하면 됨)
	private UserRepository userRepository;
	
	@PostMapping("/test/join")
	public String join(@RequestBody User user) {
		System.out.println("username : " + user.getUsername());
		System.out.println("password : " + user.getPassword());
		System.out.println("email : " + user.getEmail());
		System.out.println("id : " + user.getId());
		System.out.println("role : " + user.getRole());
		System.out.println("createDate : " + user.getCreateDate());
		
		user.setRole(RoleType.USER); // Enum 사용해서 data의 도메인을 정해주자. 실수방지
		userRepository.save(user);
		return "회원가입 완료!";
	}
	
	@GetMapping("/test/user/{id}")
	public User detail(@PathVariable int id) {
// 1. Raise Exception if null
//		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
//			@Override
//			public IllegalArgumentException get() {
//				return new IllegalArgumentException("Cannot find the user Id : " + id);
//			}
//		});
		
// 2. Make new User if null
//		User user = userRepository.findById(id).orElseGet(new Supplier<User>() {
//			@Override
//			public User get() {
//				return new User();
//			}
//		});

// 3. Just get (no value present exception)
//		User user = userRepository.findById(id).get();

		User user = userRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("Cannot find the user Id : " + id);
		});
		return user; // MessageConverter가 응답 시에 자동으로 Jackson 라이브러리를 호출해서 자바 object를 json으로 변환해줌.
	}
	
	@GetMapping("/test/users")
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	@GetMapping("/test/user")
	public Page<User> getPageUser(@PageableDefault(size = 2, sort = "id", direction = Direction.DESC ) Pageable pageable) {
		Page<User> users = userRepository.findAll(pageable); // page 정보는 응답할 필요 없으면 .getContent();
		return users;
	}
	
	@Transactional // 해당 함수 종료시에 자동 커밋. 더티 체킹
	@PutMapping("/test/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User requestedUser) {
		System.out.println("id : " + id);
		System.out.println("password : " + requestedUser.getPassword());
		System.out.println("email : " + requestedUser.getEmail());
	
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("fail to update");
		});
		user.setPassword(requestedUser.getPassword());
		user.setEmail(requestedUser.getEmail());
		
		// save 동작
		// id를 전달하지 않으면 insert를 하고
		// id를 전달하는데 해당 id의 data가 없으면 insert, 있으면 update를 함 
		//userRepository.save(user);
		return user;
	}
	
	@DeleteMapping("/test/user/{id}")
	public String deleteUser(@PathVariable int id) {
		try {
			userRepository.deleteById(id);	
		} catch (EmptyResultDataAccessException e) {
			return "Fail to delete. There is no user Id : " + id;
		}
		return "Delete Successfully!! user Id : " + id;
	}
}

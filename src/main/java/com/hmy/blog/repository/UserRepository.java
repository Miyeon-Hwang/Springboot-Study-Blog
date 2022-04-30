package com.hmy.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hmy.blog.model.User;

// extends -> DAO, 자동으로 bean 등록이 된다, @Repository 생략 가능
public interface UserRepository extends JpaRepository<User, Integer>{
	// JPA Naming 쿼리 전략
	
	// 1. 함수 이름에 따라 자동으로 SQL Query 생성
	// 아래 함수 => SELECT * FROM user WHERE username = ?1 AND password = ?2 (findBy 뒤에 대문자, and를 기준으로 WHERE에 들어갈 내용을 인식, ?뒤에 숫자는 몇번째 파라미터인지) 
	User findByUsernameAndPassword(String username, String password);
	
	// 2. Query annotation 사용
//	@Query(value = "SELECT * FROM user WHERE username = ?1 AND password =?2", nativeQuery = true)
//	User login(String username, String password);

}

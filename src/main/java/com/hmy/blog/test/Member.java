package com.hmy.blog.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
@Data // Getter, Setter 동시에
//@AllArgsConstructor // 모든 필드를 가지는 생성자
@NoArgsConstructor // 빈 생성자
public class Member {
	//private final int id; // final 붙이면 불변성을 가짐. DB를 수정할 수 없도록.
	private int id; 
	private String username;
	private String password;
	private String email;
	
	@Builder
	public Member(int id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	

}

package com.hmy.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.usertype.UserType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@DynamicInsert // null인 필드는 제외하고 insert 하겠다 (default로 넣고싶을때), 좋은 기능이지만 어노테이션을 많이 사용한다고 마냥 좋은게 아님
@Entity
public class User {
	
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 넘버링 전략. IDENTITY는 프로젝트에 연결된 DB의 넘버링 전략을 따르겠다
	private int id;
	
	@Column(nullable = false, length = 30)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false, length = 30, unique = true)
	private String email;
	
	//@ColumnDefault("'user'")
	@Enumerated(EnumType.STRING) // DB는 RoleType이란 형식이 없으니까 알려줘야함
	private RoleType role;
	
	@CreationTimestamp // 자바에서 시간자동입력
	private Timestamp createDate;
}

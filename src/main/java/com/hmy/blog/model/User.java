package com.hmy.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {
	
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 넘버링 전략. IDENTITY는 프로젝트에 연결된 DB의 넘버링 전략을 따르겠다
	private int id;
	
	@Column(nullable = false, length = 30)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false, length = 30)
	private String email;
	
	@ColumnDefault("'user'")
	private String role; // 제대로하려면 Enum 써야하지만 지금은 연습이니까
	
	@CreationTimestamp // 시간자동입력
	private Timestamp createDate;
}

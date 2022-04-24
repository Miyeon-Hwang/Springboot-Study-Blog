package com.hmy.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob // 대용량 데이터
	private String content; // 섬머노트 라이브러리 사용할 예정으로 대용량 데이터 설정

	@ColumnDefault("0")
	private	int count;
	
	@ManyToOne  // Many = Board, One = User로 연관관계를 설정
	@JoinColumn(name="userId") // userId라는 field값으로 DB에 생성됨.
	private User user; // 자바는 오브젝트로 저장하지만 DB는 오브젝트를 저장할 수 없으므로 자동으로 Foreign Key로 저장하고 User table을 참조하도록 생성됨
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER) // 하나의 board는 여러개의 reply를 가지므로 Board table에 FK로 reply column을 생성하지 x. mappedBy로 연관관계의 주인을 설정(Reply 엔티티 board와 연관)
	private List<Reply> reply;
	
	@CreationTimestamp
	private	Timestamp createDate;
}

package com.example.WebProject.domain.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "member") // @Entity가 붙은 클래스는 JPA가 관리하는 클래스
public class MemberVo {

	@Id // mbrNo 필드는 @Id를 사용하여 기본키(PK)로 지정
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 생성되도록 하기 위해 @GeneratedValue를 사용 GenerationType. IDENTITY는 기본키 생성을 데이터베이스에 위임하는 방식
	private Long mbrNo;

	private String id;

	private String name;

	@Builder
	public MemberVo(String id, String name) {
		this.id = id;
		this.name = name;
	}

}

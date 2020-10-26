
package com.example.WebProject.config;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.WebProject.domain.dto.MemberVo;

@Repository
public interface MemberRepository extends JpaRepository<MemberVo, Long> { // 비워있어도 잘 작동 // long이 아니라 Long으로 작성 ex int =>
																			// // Integer 같이	primtive형식사용 못함

	// findBy뒤에 컬럼명을 붙여주면 이를 이용한 검색 가능 public List<MemberVo> findById(String id);
	public List<MemberVo> findByName(String name);

	// like 검색도 가능 public List<MemberVo> findByNameLike(String keyword);

}

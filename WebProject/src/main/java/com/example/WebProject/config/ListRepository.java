/*
 * package com.example.WebProject.config;
 * 
 * import java.util.List;
 * 
 * import org.springframework.data.jpa.repository.JpaRepository; import
 * org.springframework.data.jpa.repository.JpaSpecificationExecutor; import
 * org.springframework.data.repository.CrudRepository; import
 * org.springframework.stereotype.Repository;
 * 
 * import com.example.WebProject.domain.dto.TestDTO;
 * 
 * // CRUD 구현을 위해 CrudRepository 상속 // 검색 및 페이징 위해 JpaSpecificationExecutor 상속
 * 
 * @Repository public interface ListRepository extends JpaRepository<TestDTO,
 * Integer> {
 * 
 * }
 * 
 * // like 검색도 가능 public List<MemberVo> findByNameLike(String keyword); }
 */
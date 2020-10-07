/*
 * package com.example.WebProject.config;
 * 
 * import org.springframework.stereotype.Repository;
 * 
 * @Repository public class BoardRepository {
 * 
 * 
 * private EntityManager em;
 * 
 * public int findAllCnt() { return ((Number)
 * em.createQuery("select count(*) from Board") .getSingleResult()).intValue();
 * }
 * 
 * public List<Board> findListPaging(int startIndex, int pageSize) { return
 * em.createQuery("select b from Board b", Board.class)
 * .setFirstResult(startIndex) .setMaxResults(pageSize) .getResultList(); } }
 */
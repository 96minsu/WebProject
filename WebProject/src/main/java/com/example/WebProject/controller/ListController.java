/*
 * package com.example.WebProject.controller;
 * 
 * import java.io.PrintWriter; import java.util.List;
 * 
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * import org.apache.ibatis.session.SqlSession; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import org.springframework.ui.ModelMap; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.ModelAttribute; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController; import
 * org.webjars.NotFoundException;
 * 
 * import com.example.WebProject.domain.ListDao; import
 * com.example.WebProject.domain.ListDto; import
 * com.example.WebProject.domain.dao.TestDAO; import
 * com.example.WebProject.domain.dto.BoardListDTO; import
 * com.example.WebProject.domain.dto.ListDTO; import
 * com.example.WebProject.domain.dto.TestDTO; import
 * com.example.WebProject.service.ListService; import
 * com.example.WebProject.service.UserService;
 * 
 * @RestController
 * 
 * @RequestMapping("/list") public class ListController {
 * 
 * @Autowired ListService listService;
 * 
 * @GetMapping public ResponseEntity<?> list(final BoardListDTO model) {
 * 
 * ResponseEntity<?> entity = null;
 * 
 * try { entity = new ResponseEntity<BoardListDTO>(listService.list(model),
 * HttpStatus.OK); } catch (Exception e) { entity = new
 * ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); }
 * 
 * return entity; }
 * 
 * @GetMapping("/{id}") public ResponseEntity<?> view(@PathVariable("id") final
 * long id) {
 * 
 * ResponseEntity<?> entity = null;
 * 
 * try { entity = new ResponseEntity<ListDTO>(listService.view(id),
 * HttpStatus.OK); } catch (NotFoundException e) { entity = new
 * ResponseEntity<>(HttpStatus.NOT_FOUND); } catch (Exception e) { entity = new
 * ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); }
 * 
 * return entity; }
 * 
 * @PostMapping public ResponseEntity<?> insert(@RequestBody final ListDTO
 * model) {
 * 
 * ResponseEntity<?> entity = null;
 * 
 * try { entity = new ResponseEntity<ListDTO>(listService.insert(model),
 * HttpStatus.CREATED); } catch (Exception e) { entity = new
 * ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); }
 * 
 * return entity; }
 * 
 * @PutMapping("/{id}") public ResponseEntity<?> update(@PathVariable("id")
 * final long id,
 * 
 * @RequestBody final ListDTO model) {
 * 
 * ResponseEntity<?> entity = null;
 * 
 * try { entity = new ResponseEntity<ListDTO>(listService.update(model, id),
 * HttpStatus.OK); } catch (Exception e) { entity = new
 * ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); }
 * 
 * return entity; }
 * 
 * @DeleteMapping("/{id}") public ResponseEntity<?> delete(@PathVariable("id")
 * final long id) {
 * 
 * ResponseEntity<?> entity = null;
 * 
 * try { listService.delete(id); entity = new ResponseEntity<>(HttpStatus.OK); }
 * catch (NotFoundException e) { entity = new
 * ResponseEntity<>(HttpStatus.NOT_FOUND); } catch (Exception e) { entity = new
 * ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); }
 * 
 * return entity; }
 * 
 * }
 */
/*
 * package com.example.WebProject.service;
 * 
 * import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.data.domain.Page; import
 * org.springframework.stereotype.Service; import org.springframework.ui.Model;
 * import org.webjars.NotFoundException;
 * 
 * import com.example.WebProject.config.ListRepository; import
 * com.example.WebProject.domain.dto.BoardListDTO; import
 * com.example.WebProject.domain.dto.ListDTO; import
 * com.example.WebProject.domain.dto.TestDTO; import
 * com.example.WebProject.domain.entity.List;
 * 
 * @Service public class ListService {
 * 
 * @Autowired private ListRepository listRepository;
 * 
 * public BoardListDTO list(BoardListDTO model) throws Exception { Page<List>
 * page = listRepository.findAll(model.toSpecification(), model.toPage());
 * model.setList(page.getContent());
 * model.setTotalCount(page.getTotalElements()); return model; }
 * 
 * public ListDTO view(Long id) throws Exception { Optional<List> opt =
 * listRepository.findById(id);
 * 
 * if (opt.isPresent()) { return new ListDTO(opt.get()); } else { throw new
 * NotFoundException("리소스를 찾을 수 없습니다."); } }
 * 
 * public ListDTO insert(ListDTO model) throws Exception { List list =
 * listRepository.save(model.toEntity()); return new ListDTO(list); }
 * 
 * public ListDTO update(ListDTO model, long id) throws Exception { ListDTO view
 * = this.view(id);
 * 
 * view.setListNum(model.getListNum()); view.setListName(model.getListName());
 * 
 * List list = listRepository.save(view.toEntity());
 * 
 * return new ListDTO(list); }
 * 
 * public void delete(long id) throws Exception { this.view(id);
 * listRepository.deleteById(id); }
 * 
 * }
 */
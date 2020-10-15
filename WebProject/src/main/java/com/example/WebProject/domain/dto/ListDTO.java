/*
 * package com.example.WebProject.domain.dto;
 * 
 * import java.time.LocalDateTime;
 * 
 * import com.example.WebProject.domain.entity.List;
 * 
 * import lombok.Data; import lombok.NoArgsConstructor;
 * 
 * @Data
 * 
 * @NoArgsConstructor public class ListDTO {
 * 
 * private long id; private int listNum; private String listName; private
 * LocalDateTime regDatetime; private LocalDateTime editDatetime;
 * 
 * public List toEntity() { return
 * List.builder().id(id).listNum(listNum).listName(listName).build(); }
 * 
 * public ListDTO(List list) { this.id = list.getId(); this.listNum =
 * list.getListNum(); this.listName = list.getListName(); this.regDatetime =
 * list.getRegDatetime(); this.editDatetime = list.getEditDatetime();
 * 
 * }
 * 
 * }
 */
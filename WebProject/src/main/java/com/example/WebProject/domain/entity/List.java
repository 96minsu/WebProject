/*
 * package com.example.WebProject.domain.entity;
 * 
 * import java.time.LocalDateTime;
 * 
 * import javax.persistence.Column; import javax.persistence.Entity; import
 * javax.persistence.GeneratedValue; import javax.persistence.Id;
 * 
 * import org.hibernate.annotations.CreationTimestamp; import
 * org.hibernate.annotations.UpdateTimestamp;
 * 
 * import javax.persistence.GenerationType;
 * 
 * import lombok.AccessLevel; import lombok.Builder; import lombok.Getter;
 * import lombok.NoArgsConstructor; import lombok.ToString;
 * 
 * @NoArgsConstructor(access=AccessLevel.PROTECTED)
 * 
 * @Getter
 * 
 * @Entity
 * 
 * @ToString public class List {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy=GenerationType.SEQUENCE) private long id;
 * 
 * @Column(nullable=false) private int listNum;
 * 
 * @Column private String listName;
 * 
 * @Column(updatable=false)
 * 
 * @CreationTimestamp private LocalDateTime regDatetime;
 * 
 * 
 * @UpdateTimestamp private LocalDateTime editDatetime;
 * 
 * @Builder private List(long id, int listNum, String listName) { this.id = id;
 * this.listNum = listNum; this.listName = listName; } }
 */
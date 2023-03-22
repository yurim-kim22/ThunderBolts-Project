/*
 * package com.greedy.thunderbolts.model.dto;
 * 
 * 
 * import javax.persistence.Column; import javax.persistence.Entity; import
 * javax.persistence.GeneratedValue; import javax.persistence.GenerationType;
 * import javax.persistence.Id;
 * 
 * import lombok.Data;
 * 
 * @Data
 * 
 * @Entity public class User {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY)
 * 
 * @Column(name = "user_id") private Long id;
 * 
 * @Column(nullable = false) private String name;
 * 
 * @Column(nullable = false) private String email; private String mobile;
 * private String role = "ROLE_MEMBER";
 * 
 * public User(String name, String email, String mobile) { this.name = name;
 * this.email = email; this.mobile = mobile; }
 * 
 * public User update(String name, String email) { this.name = name; this.email
 * = email;
 * 
 * return this; } }
 */
package org.penta.work.jpa.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "USER")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class UserEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "ID")
	private UUID id;
	
	@Column(unique=true)
	@Email
	private String email;
	@Size(min = 6)
	private String password;
	private String name;
	@Pattern(regexp = "/^(\\+\\d{1,3}[- ]?)?\\d{10}$/")
	private String mobile;
	private Boolean isPrimary;
	
	
}

package com.m2i.crm.model;

/**
 *
 * @author elouf
 */
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class DAOUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String username;
	@Column
	@JsonIgnore
	private String password;

	
}
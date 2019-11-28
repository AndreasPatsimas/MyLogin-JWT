package org.patsimas.loginjwt.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "username", unique=true)
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "active")
	private short active;
	
	@ManyToMany(fetch= FetchType.EAGER)
	@JoinTable(name = "users_authorities", joinColumns =
	@JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "authority_id")
	)
	private List<Authority> authorities;
}

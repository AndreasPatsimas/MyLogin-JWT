package org.patsimas.loginjwt.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

	@NotNull
	@Column(name = "username", unique=true)
	private String username;

	@NotNull
	@Column(name = "password")
	private String password;

	@NotNull
	@Column(name = "active")
	private short active;

	@NotNull
	@Column(name = "email")
	private String email;

	@NotNull
	@ManyToMany(fetch= FetchType.EAGER)
	@JoinTable(name = "users_authorities", joinColumns =
	@JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "authority_id")
	)
	private List<Authority> authorities;
}

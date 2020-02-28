package fr.dawan.locationsalles.model;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import fr.dawan.locationsalles.security.BCryptManagerUtil;
import fr.dawan.locationsalles.security.RoleEnum;
import lombok.Data;

//@Entity
//@Table(name = "administrateur")
//@Data
public class Administrateur implements UserDetails {
	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "password")
	private String password;

	// Authentification______________________________________________________________

	@ElementCollection(targetClass = RoleEnum.class, fetch = FetchType.EAGER)
	@Cascade(value = CascadeType.REMOVE)
	@JoinTable(indexes = {
			@Index(name = "INDEX_USER_ROLE", columnList = "id_user") }, name = "roles", joinColumns = @JoinColumn(name = "id_user"))
	@Column(name = "role", nullable = false)
	@Enumerated(EnumType.STRING)
	private Collection<RoleEnum> roles;

	@Column(name = "account_non_expired")
	private boolean accountNonExpired;

	@Column(name = "account_non_locked")
	private boolean accountNonLocked;

	@Column(name = "credentials_non_expired")
	private boolean credentialsNonExpired;

	@Column(name = "enabled")
	private boolean enabled;

	// ___________________________________________________________________________________

	public Administrateur(@NotNull String username, @NotNull String password, @NotNull String nom,
			@NotNull String prenom, @NotNull String adresse, @NotNull String tel, @NotNull String mail,
			Set<Reservation> listeReservation, Collection<RoleEnum> roles, boolean accountNonExpired,
			boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {
		super();
		this.username = username;
		this.password = password;

		//this.listeReservation = listeReservation;
		this.roles = roles;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
	}

	public Administrateur(Collection<RoleEnum> roles, boolean accountNonExpired, boolean accountNonLocked,
			boolean credentialsNonExpired, boolean enabled) {
		super();

		this.roles = roles;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
	}
	// _________________________________________________________________________________________________

	public Collection<? extends GrantedAuthority> getAuthorities() {
		String roles = StringUtils
				.collectionToCommaDelimitedString(getRoles().stream().map(Enum::name).collect(Collectors.toList()));
		return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
	}

	public void setPassword(String password) {
		if (!password.isEmpty()) {
			this.password = BCryptManagerUtil.passwordencoder().encode(password);
		}
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {

		return this.username;
	}

	public Collection<RoleEnum> getRoles() {
		return roles;
	}

	public void setRoles(Collection<RoleEnum> roles) {
		this.roles = roles;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}

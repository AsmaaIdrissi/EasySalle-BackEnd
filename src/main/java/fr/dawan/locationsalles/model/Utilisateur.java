/**
 * 
 */
package fr.dawan.locationsalles.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.util.StringUtils;
import fr.dawan.locationsalles.utils.BCryptManagerUtil;
import fr.dawan.locationsalles.utils.RoleEnum;
import lombok.Data;

/**
 * @author Admin-Stagiaire
 *
 */
@Entity
@Table(name="user")
@Data
public class Utilisateur implements UserDetails{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_user")
	private int id;
	
	@NotNull
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Column(name = "nom", nullable = false)
	private String nom;

    @NotNull
    @Column(name = "prenom", nullable = false)
	private String prenom;

    @NotNull
    @Column(name = "adresse", nullable = false)
	private String adresse;

    @NotNull
    @Column(name = "tel", nullable = false)
	private String tel;

    @NotNull
    @Column(name = "mail", nullable = false)
	private String mail;
	
	
	@OneToMany
	Set<Reservation> listeReservation =new HashSet<>();
	
	//Authentification______________________________________________________________
	
	@ElementCollection(targetClass = RoleEnum.class, fetch = FetchType.EAGER)
    @Cascade(value = CascadeType.REMOVE)
    @JoinTable(
            indexes = {@Index(name = "INDEX_USER_ROLE", columnList = "id_user")},
            name = "roles",
            joinColumns = @JoinColumn(name = "id_user")
    )
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
	
	//___________________________________________________________________________________
    
    
    
    // Constructeurs_______________________________________________________________________
    
    public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
    public Utilisateur( @NotNull String username, @NotNull String password, @NotNull String nom,
			@NotNull String prenom, @NotNull String adresse, @NotNull String tel, @NotNull String mail,
			Set<Reservation> listeReservation, Collection<RoleEnum> roles, boolean accountNonExpired,
			boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.mail = mail;
		this.listeReservation = listeReservation;
		this.roles = roles;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
	}

	

	public Utilisateur(Collection<RoleEnum> roles, boolean accountNonExpired, boolean accountNonLocked,
			boolean credentialsNonExpired, boolean enabled) {
		super();
	
		this.roles = roles;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
	}
	
	//_________________________________________________________________________________________________
	
	 
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        String roles = StringUtils.collectionToCommaDelimitedString(getRoles().stream()
	                .map(Enum::name).collect(Collectors.toList()));
	        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
	    }


		public void setPassword(String password) {
	        if (!password.isEmpty()) {
	            this.password = BCryptManagerUtil.passwordencoder().encode(password);
	        }
	    }
		
		
	public int getId() {
			return id;
		}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Reservation> getListeReservation() {
		return listeReservation;
	}

	public void setListeReservation(Set<Reservation> listeReservation) {
		this.listeReservation = listeReservation;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
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

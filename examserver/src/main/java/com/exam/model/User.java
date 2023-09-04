package com.exam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
//import javax.persistence.*;
import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
//Implements UserDetails Interface from Spring security for User by overriding user related methods
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastname;
    private String email;
    private String phone;
    private boolean enabled =true;
    private String profile;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy ="user" )
    private Set<UserRole> userRoles = new HashSet<UserRole>();


    public User() {

    }

    public User(Long id, String username, String password, String firstName, String lastname, String email,
                String phone, boolean enabled, String profile) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.enabled = enabled;
        this.profile = profile;
    }



    public String getProfile() {
        return profile;
    }



    public void setProfile(String profile) {
        this.profile = profile;
    }



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<Authority> authorities = new HashSet<>();

        //adding roles from userrole and adding the same to authority
        this.userRoles
                .forEach(userRole
                        -> authorities.add(new Authority(userRole.getRole().getRoleName())));
        return authorities;

    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }



    public Set<UserRole> getUserRoles() {
        return userRoles;
    }



    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
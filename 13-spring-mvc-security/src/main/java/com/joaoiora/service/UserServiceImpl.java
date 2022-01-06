package com.joaoiora.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoiora.dao.UserDao;
import com.joaoiora.model.CrmUser;
import com.joaoiora.model.Role;
import com.joaoiora.model.User;

/**
 * @author João Iora
 */
@Service
public class UserServiceImpl
  implements UserService {

  /**
   *
   */
  @Autowired
  private UserDao dao;

  /**
   *
   */
  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  /**
   *
   */
  @Transactional
  @Override
  public User findByUserName(String userName) {
    return dao.findByUserName(userName);
  }

  /**
   *
   */
  @Transactional
  @Override
  public void save(CrmUser crmUser) {
    final var user = new User();
    user.setUserName(crmUser.getUserName());
    user.setPassword(passwordEncoder.encode(crmUser.getPassword()));
    user.setFirstName(crmUser.getFirstName());
    user.setRoles(List.of(new Role("ROLE_EMPLOYEE")));
    dao.save(user);
  }

  /**
   *
   */
  @Transactional
  @Override
  public UserDetails loadUserByUsername(String userName)
    throws UsernameNotFoundException {
    final var user = dao.findByUserName(userName);
    if (user == null) {
      throw new UsernameNotFoundException("Invalid username orpassword.");
    }
    return new org.springframework.security.core.userdetails.User(
        user.getUserName(), user.getPassword(),
        mapRolesToAuthorities(user.getRoles()));
  }

  /**
   * @param roles
   *
   * @return
   */
  private static Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
    return roles.stream()
        .map(role -> new SimpleGrantedAuthority(role.getName()))
        .collect(Collectors.toList());
  }

}

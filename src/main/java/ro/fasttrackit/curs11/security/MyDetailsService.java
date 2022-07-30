package ro.fasttrackit.curs11.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.fasttrackit.curs11.model.security.MyUserDetails;
import ro.fasttrackit.curs11.repository.MyUserRepository;

@Service
@RequiredArgsConstructor
public class MyDetailsService implements UserDetailsService {
  private final MyUserRepository repo;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return repo.findByUserName (username)
      .map(myuser -> new MyUserDetails (myuser.username(), myuser.password(), myuser.roles()))
      .orElseThrow(() -> new UsernameNotFoundException("Invalid credentials"));
  }
}

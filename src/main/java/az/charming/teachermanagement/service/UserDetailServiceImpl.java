package az.charming.teachermanagement.service;

import az.charming.teachermanagement.repository.StudentRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserDetailServiceImpl implements UserDetailsService{

    private final StudentRepository userRepo;

    public UserDetailServiceImpl(StudentRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username).map(
                (student)->User.withUsername(username)
                        .disabled(false)
                        .password(student.getPassword())
                        .authorities(student.getRoles().split(","))
                        .build()
        ).orElseThrow(()->new UsernameNotFoundException("no such user"));
    }//functional programming
}
package starzone.demo.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import starzone.demo.dao.UserRepository;
import starzone.demo.entity.MyUserDetails;
import starzone.demo.entity.User;

import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    public void changeAccessModifier(int id) {
        if(userRepository.findById(id).isPresent()){
            User user = userRepository.findById(id).get();
            userRepository.findById(id).get().setActive(!user.isActive());
            userRepository.save(user);

        }
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findUserByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("not found" + userName));

        return user.map(MyUserDetails::new).get();
    }

    public boolean saveUser(User user) {
        Optional<User> UserInDB = userRepository.findUserByUserName(user.getUserName());
        if (UserInDB.isPresent()) {
            return false;
        } else {
            user.setRoles("ROLE_USER");
            user.setUserPassword(user.getUserPassword());
            userRepository.save(user);
            return true;
        }
    }
}

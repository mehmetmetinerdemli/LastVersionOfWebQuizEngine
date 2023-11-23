package engine.services;

import engine.dao.UserRepository;
import engine.entities.User;
import engine.exceptions.UserExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepo;


    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;

    }

    public void register(User user) {
        Optional<User> userToAdd = userRepo.findById(user.getEmail());
        if (userToAdd.isPresent())
            throw new UserExistsException();
        String password = "password";
        user.setPassword(password);
        userRepo.save(user);
    }

}
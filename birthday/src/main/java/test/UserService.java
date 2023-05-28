package test;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
public class UserService {
    public void createUser(@Valid User user){

    }
}

package com.OrgSolutionNet.Proyecto.Services;

import com.OrgSolutionNet.Proyecto.Entities.User;
import com.OrgSolutionNet.Proyecto.Repositories.EmpresaRepository;
import com.OrgSolutionNet.Proyecto.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository){

        this.repository = repository;
    }

    public User createUser(User newUser){
        return this.repository.save(newUser);
    }

    public User finUserdByEmail(String email){
        return this.repository.findByEmail(email);
    }

    public User getOrCreateUser(Map<String, Object> userData){
        String email = (String) userData.get("email");

        User user = finUserdByEmail(email);
        if (user == null){
            String name = (String) userData.get("nickname");
            String image = (String) userData.get("picture");
            String auth0Id = (String) userData.get("sub");

            User newUser = new User(email=email, image=image, auth0Id=auth0Id);
            return createUser(newUser);
        }
        return user;

    }
}

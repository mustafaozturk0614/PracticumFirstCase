package com.example.practicumfirstcase.service;

import com.example.practicumfirstcase.dto.request.UserRequest;
import com.example.practicumfirstcase.entity.User;
import com.example.practicumfirstcase.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements   IService<User,Long>{

    private  final UserRepository userRepository;

    public UserService( UserRepository userRepository) {

        this.userRepository = userRepository;
    }


    @Override
    public User save(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public Iterable<User> saveAll(Iterable<User> entities) {
        return userRepository.saveAll(entities);
    }

    @Override
    public User update(Long id,User enttiy) {
        Optional<User> userdb=userRepository.findById(id);
        if(userdb.isPresent()){
            userdb.get().setSurName(enttiy.getSurName());
            userdb.get().setTelephone(enttiy.getTelephone());
            userdb.get().setName(enttiy.getName());
            userdb.get().setEmail(enttiy.getEmail());
            return userRepository.save(userdb.get());
        }else{
            System.out.println("Kullanıcı bulunamadı");
            return null;

        }

    }

    @Override
    public void deleteById(Long id) {

        userRepository.deleteById(id);

    }

    @Override
    public Optional<User> findById(Long id) {

        return userRepository.findById(id);
    }




    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User userRequsetConvertToUser(UserRequest userRequest){
        User user=new User();
        user.setEmail(userRequest.getEmail());
        user.setName(userRequest.getName());
        user.setSurName(userRequest.getSurName());
        user.setTelephone(userRequest.getTelephone());
        return user;
    };
}

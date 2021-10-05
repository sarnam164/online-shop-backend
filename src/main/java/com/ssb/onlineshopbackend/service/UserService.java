package com.ssb.onlineshopbackend.service;

import com.ssb.onlineshopbackend.data.UserRepository;
import com.ssb.onlineshopbackend.exception.ResourceNotFoundException;
import com.ssb.onlineshopbackend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService implements IUserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        Optional<User> userDb = this.userRepository.findById(user.getId());
        if(userDb.isPresent()){
            User userUpdate = userDb.get();
            userUpdate.setId(user.getId());
            userUpdate.setUsername(user.getUsername());
            userUpdate.setPassword(user.getPassword());
            userUpdate.setEmail(user.getEmail());
            userUpdate.setRole(user.getRole());
            userUpdate.setEnabled(user.isEnabled());
            userRepository.save(userUpdate);
            return userUpdate;
        }else{
            throw new ResourceNotFoundException("Resource Not Found with Id : "+user.getId());
        }
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> userDb = this.userRepository.findById(id);
        if(userDb.isPresent()){
            return userDb.get();
        }else{
            throw new ResourceNotFoundException("Resource Not Found with Id : "+id);
        }
    }

    @Override
    public User getUserByEmail(String email) {
        Optional<User> userDb = Optional.ofNullable(this.userRepository.findByEmail(email));
        if(userDb.isPresent()){
            return userDb.get();
        }else{
            throw new ResourceNotFoundException("Resource Not Found with Email : "+email);
        }
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> userDb = this.userRepository.findById(id);
        if(userDb.isPresent()){
            this.userRepository.delete(userDb.get());
        }else{
            throw new ResourceNotFoundException("Resource Not Found with Id : "+id);
        }
    }

}

package com.domin.wms.services;

import com.domin.wms.dto.UserDTO;
import com.domin.wms.molels.User;
import com.domin.wms.repositories.UsersRepository;
import com.domin.wms.util.UserNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UsersService {

    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;



    @Autowired
    public UsersService(UsersRepository usersRepository, ModelMapper modelMapper) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
    }



    public List<User> findAll() {
        return usersRepository.findAll();
    }


    public User findOne(int id) {
        return usersRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }


    @Transactional
    public void save(User user) {
        usersRepository.save(user);
    }


    @Transactional
    public void update(User updatedUser, int id) {
        updatedUser.setId(id);
        usersRepository.save(updatedUser);
    }


    @Transactional
    public void delete(int id) {
        usersRepository.deleteById(id);
    }


    private User convertToUser(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
    // !!!!! remove!!!

    private UserDTO convertToUserDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }


    private void enrichUser(User user) {
        // TODO
    }
}

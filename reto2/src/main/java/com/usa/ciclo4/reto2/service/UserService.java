package com.usa.ciclo4.reto2.service;

import java.util.List;
import java.util.Optional;

import com.usa.ciclo4.reto2.model.User;
import com.usa.ciclo4.reto2.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }

    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }

    public boolean emailExist(String email) {
        return userRepository.emailExist(email);
    }

    public User authenticateUser(String email, String password) {
        Optional<User> user = userRepository.authenticateUser(email, password);
        if (user.isEmpty()) {
            return new User();
        } else {
            return user.get();
        }
    }

    public User create(User user) {

        Optional<User> userIdMax = userRepository.lastUserId();
        if (user.getId() == null) {
            if (userIdMax.isEmpty()) {
                user.setId(1);
            } else {
                user.setId(userIdMax.get().getId() + 1);
            }
        }
        Optional<User> userId = userRepository.getUser(user.getId());
        if (userId.isEmpty()) {
            if (emailExist(user.getEmail()) == false) {
                return userRepository.create(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public User update(User user) {
        if (user.getId() != null) {
            Optional<User> userExist = userRepository.getUser(user.getId());
            if (!userExist.isEmpty()) {
                if (user.getIdentification() != null) {
                    userExist.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userExist.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userExist.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userExist.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userExist.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userExist.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userExist.get().setZone(user.getZone());
                }
                userRepository.update(userExist.get());
                return userExist.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean delete(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<User> birthtDayList(String monthBirthtDay) {
        return userRepository.birthtDayList(monthBirthtDay);
    }
}

package com.ohmycode.test.services.impl;

import com.ohmycode.test.models.entities.Role;
import com.ohmycode.test.models.entities.ToDo;
import com.ohmycode.test.models.entities.User;
import com.ohmycode.test.repository.ToDoRepository;
import com.ohmycode.test.repository.UserRepository;
import com.ohmycode.test.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    ToDoRepository toDoRepository;
    @Autowired
    private UserRepository userRepository;

    public List<ToDo> getToDoList(String keyWord) {
        if (keyWord != null) {
            return toDoRepository.findAll(keyWord);
        }
        return toDoRepository.findAll();
    }

    public List<ToDo> getToDoListByUser(String username) {
        if (username != null) {
            return toDoRepository.findByUsername(username);
        }
        return toDoRepository.findAll();
    }

    public Page<ToDo> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.toDoRepository.findAll(pageable);
    }

    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    public Optional<ToDo> getToDoById(Long id) {
        Optional<ToDo> optionalToDo = toDoRepository.findById(id);
        if (optionalToDo.isEmpty()) {
            throw new RuntimeException("Task not found");
        } else {
            return optionalToDo;
        }
    }

    public ToDo addNewToDo(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    public void updateToDo(Authentication authentication, Long id) {
        Optional<ToDo> optionalToDo = toDoRepository.findById(id);
//        if (!authentication.getName().equals(optionalToDo.get().getUser().getUsername())) {
//            throw new RuntimeException("You cannot modificate another user tasks.");
//        } else {
        optionalToDo.ifPresent(toDo -> toDo.setComplete(optionalToDo.get().isComplete()));
        toDoRepository.save(optionalToDo.get());
    }

    public void deleteToDo(Authentication authentication, Long id) {
        Optional<ToDo> optionalToDo = toDoRepository.findById(id);
//        if (!authentication.getName().equals(optionalToDo.get().getUser().getUsername())) {
//            throw new RuntimeException("You cannot delete another user tasks.");
//        } else {
        if (optionalToDo.isPresent()) {
            toDoRepository.deleteById(id);
        }
    }
}


package com.ohmycode.test.services.impl;

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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Page<ToDo> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.toDoRepository.findAll(pageable);
    }

    public List<User> getByUsername(String username) {
        if (username != null) {
            return userRepository.findByUsernameEquals(username);
        }
        return userRepository.findAll();
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

    public void updateToDo(Long id) {
        Optional<ToDo> optionalToDo = toDoRepository.findById(id);
        optionalToDo.ifPresent(toDo -> toDo.setComplete(optionalToDo.get().isComplete()));
        toDoRepository.save(optionalToDo.get());
    }

    public void deleteToDo(Authentication authentication, Long id) {
        Optional<ToDo> optionalToDo = toDoRepository.findById(id);
//        if (!authentication.getName().equals(optionalToDo.get().getUser().getUsername())){
//            throw new RuntimeException("You cannot delete another user tasks.");
//        }else {
        if (optionalToDo.isPresent()) {
            toDoRepository.deleteById(id);
        }
    }
}


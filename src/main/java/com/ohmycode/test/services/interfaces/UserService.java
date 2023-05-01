package com.ohmycode.test.services.interfaces;

import com.ohmycode.test.models.entities.ToDo;
import com.ohmycode.test.models.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<ToDo> getToDoList(String keyWord);
    public List<User> getByUsername(String username);

    public Optional<ToDo> getToDoById(Long id);

    public ToDo addNewToDo(ToDo todo);

    public void updateToDo(Long id);

    public void deleteToDo(Authentication authentication, Long id);

    Page<ToDo> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}

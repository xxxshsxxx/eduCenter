package ru.savshop.educenter.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.savshop.educenter.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

    User findOneByEmail(String email);

}

package ru.savshop.educenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.savshop.educenter.model.StudentLessons;

public interface StudLessRepository extends JpaRepository<StudentLessons, Integer> {
}

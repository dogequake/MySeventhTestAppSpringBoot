package ru.chernyshev.MySeventhTestAppSpringBoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.chernyshev.MySeventhTestAppSpringBoot.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
package com.learnRESTAPIs.learnRESTAPIs.repository;

import com.learnRESTAPIs.learnRESTAPIs.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}

package com.pebusney.user.repository;

import com.pebusney.user.domain.Student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mark
 * @since 2016-04-21 17:08.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  Page<Student> findAll(Pageable pageable);

  Student findById(Long id);

  Student findByname(String name);

  Student findBySno(String sno);

  Student findByClassName(String className);

  Student findByMajor(String major);
}

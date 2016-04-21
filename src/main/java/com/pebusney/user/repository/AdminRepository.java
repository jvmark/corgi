package com.pebusney.user.repository;

import com.pebusney.user.domain.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mark
 * @since 2016-04-03 16:25.
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

  Admin findByName(String name);
}


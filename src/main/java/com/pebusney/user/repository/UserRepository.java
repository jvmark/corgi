package com.pebusney.user.repository;

import com.pebusney.user.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @auther mark
 * @since 2016-04-03 16:25.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}


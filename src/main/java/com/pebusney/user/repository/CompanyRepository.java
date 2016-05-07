package com.pebusney.user.repository;

import com.pebusney.user.domain.Company;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mark
 * @since 2016-04-21 18:38.
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

  Page<Company> findAll(Pageable pageable);

  Company findByName(String name);

  Company findById(Long id);
}

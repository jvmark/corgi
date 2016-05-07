package com.pebusney.user.repository;

import com.pebusney.user.domain.Recruitment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mark
 * @since 2016-04-21 18:39.
 */
@Repository
public interface RecruitmentRepository extends JpaRepository<Recruitment, Long> {

  Page<Recruitment> findAll(Pageable pageable);

  Recruitment findById(Long id);

  Recruitment findByCity(String city);

  List<Recruitment> findByCompanyId(Long companyId);
}

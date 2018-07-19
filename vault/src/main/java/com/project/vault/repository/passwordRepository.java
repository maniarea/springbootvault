package com.project.vault.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.vault.model.PasswordData;

@Repository
public interface passwordRepository extends JpaRepository<PasswordData, Integer> {

}

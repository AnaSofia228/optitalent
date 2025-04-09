package com.example.optitalent.repository;

import com.example.optitalent.models.StatusPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusPermissionRepository extends JpaRepository<StatusPermission, Long> {

}
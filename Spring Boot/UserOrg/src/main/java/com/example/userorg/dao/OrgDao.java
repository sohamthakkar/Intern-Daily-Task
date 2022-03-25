package com.example.userorg.dao;

import com.example.userorg.model.Orgenization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgDao extends JpaRepository<Orgenization,Long> {
}

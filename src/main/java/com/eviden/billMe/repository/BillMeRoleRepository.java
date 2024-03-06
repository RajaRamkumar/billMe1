package com.eviden.billMe.repository;

import com.eviden.billMe.entity.BillMeRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillMeRoleRepository extends JpaRepository<BillMeRole,Integer> {
}

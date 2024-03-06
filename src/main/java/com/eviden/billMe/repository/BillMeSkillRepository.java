package com.eviden.billMe.repository;

import com.eviden.billMe.entity.BillMeSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillMeSkillRepository extends JpaRepository<BillMeSkill,Integer> {
}

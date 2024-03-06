package com.eviden.billMe.repository;

import com.eviden.billMe.entity.BillMeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
public interface BillMeUserRepository extends JpaRepository<BillMeUser,Integer> {
    @Override
    List<BillMeUser> findAll();

    @Override
    Optional<BillMeUser> findById(Integer integer);

    BillMeUser findByUserName(String userName);


}

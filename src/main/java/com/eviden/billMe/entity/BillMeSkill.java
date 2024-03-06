package com.eviden.billMe.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bill_me_skill")
@Getter
@Setter
public class BillMeSkill{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String skillName;
}

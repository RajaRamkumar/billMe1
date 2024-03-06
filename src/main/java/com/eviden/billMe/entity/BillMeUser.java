package com.eviden.billMe.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bill_me_user")
@Setter
@Getter
public class BillMeUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userName;

    @ManyToOne
    @JoinColumn(name = "bill_me_role_id")
    private BillMeRole billMeRole;

    private Boolean billableFlag;


    private String contactNo;

    @Lob
    private byte[] resume;

    @ManyToOne
    @JoinColumn(name = "bill_me_skill_id")
    private BillMeSkill billMeSkill;

}

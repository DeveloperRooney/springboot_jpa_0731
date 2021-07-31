package com.springbootjpa.board.entity;


import lombok.Data;
import org.apache.tomcat.jni.Local;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String userId;

    private String userPass;

    private LocalDateTime nickName;

    private LocalDateTime regDate;

    private LocalDateTime loginDate;

    private String phoneNumber;

}

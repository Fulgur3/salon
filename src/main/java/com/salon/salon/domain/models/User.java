package com.salon.salon.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User {
    public enum Status{
        User("user"),ADMIN("admin"),BANNED("banned");
        private String statusName;

        Status(String StatusName) {
            this.statusName=statusName;
        }
        public String getStatusName(){
            return statusName;
        }
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private long id;

    @Column(name="login", nullable = false)
    private String login;

    @Column (name="password", nullable = false)
    private String password;

    @Column(name="user_name", nullable =false)
    private String userName;

    @Column (name="user_email", nullable = false)
    private String email;

    @Column (name="phone_number", nullable = false)
    private String phoneNumber;

    @Column(name="user_status", nullable = false)
    private String status;

}


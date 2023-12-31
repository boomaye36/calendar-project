package com.example.calendarcore.domain.entity;

import com.example.calendarcore.util.Encryptor;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Entity
@Table(name="users")
@NoArgsConstructor
public class User extends BaseEntity{
    private String name;
    private String email;
    private String password;
    private LocalDate birthDay;

    public User(String name, String email, String password, LocalDate birthDay) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthDay = birthDay;
    }

    public boolean isMatch(Encryptor encryptor, String password) {
        return encryptor.isMatch(password, this.password);
    }
}

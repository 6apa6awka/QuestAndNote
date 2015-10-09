package org.first.questnote.dao.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;
import java.util.Date;

/**
 * Created by eorlov on 17.07.2015.
 */
@Document(collection = "users")
public class UserEntity {

    @Id
    private String id;
    private String ip;
    private String password;
    private String name;
    private String secondName;
    private String birthDate;
    private Date registrationDate;

    private UserEntity(){};

    private UserEntity(UserBuilder userBuilder){
        this.id = userBuilder.id;
        this.ip = userBuilder.ip;
        this.password = userBuilder.password;
        this.name = userBuilder.name;
        this.secondName = userBuilder.secondName;
        this.birthDate = userBuilder.birthDate;
        this.registrationDate = userBuilder.registrationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", birthDate=" + birthDate +
                ", registrationDate=" + registrationDate +
                '}';
    }

    public static class UserBuilder{
        private String id;
        private String ip;
        private String password;
        private String name;
        private String secondName;
        private String birthDate;
        private Date registrationDate;

        public UserBuilder(){}

        public UserBuilder setId(String id) {
            this.id = id;
            return this;
        }
        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setIp(String ip) {
            this.ip = ip;
            return this;
        }

        public UserBuilder setBirthDate(String birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public UserBuilder setRegistrationDate(Date registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public UserBuilder setSecondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserEntity build(){
            UserEntity newUserEntity = new UserEntity(this);
            return newUserEntity;
        }
    }


}

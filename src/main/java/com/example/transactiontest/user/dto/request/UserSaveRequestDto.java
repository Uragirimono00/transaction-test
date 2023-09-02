package com.example.transactiontest.user.dto.request;

import com.example.transactiontest.user.domain.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSaveRequestDto {
    private String name;

    public User toEntity(UserSaveRequestDto entity){
        return User.builder()
                .name(entity.getName())
                .build();
    }
}

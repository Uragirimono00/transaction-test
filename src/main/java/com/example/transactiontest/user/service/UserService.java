package com.example.transactiontest.user.service;

import com.example.transactiontest.user.domain.model.User;
import com.example.transactiontest.user.dto.request.UserSaveRequestDto;

public interface UserService {
    User userSave(UserSaveRequestDto userSaveRequestDto);
}

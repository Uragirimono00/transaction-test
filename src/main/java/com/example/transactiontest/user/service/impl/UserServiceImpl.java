package com.example.transactiontest.user.service.impl;

import com.example.transactiontest.team.domain.model.Team;
import com.example.transactiontest.user.domain.model.User;
import com.example.transactiontest.user.domain.repository.UserRepository;
import com.example.transactiontest.user.dto.request.UserSaveRequestDto;
import com.example.transactiontest.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User userSave(UserSaveRequestDto userSaveRequestDto) {

        User userEntity = userSaveRequestDto.toEntity(userSaveRequestDto);
        Team teamEntity = Team.builder()
                .teamName("A팀")
                .build();

        userEntity.setTeam(teamEntity);

        userRepository.save(userEntity);

        return userEntity;
    }
}

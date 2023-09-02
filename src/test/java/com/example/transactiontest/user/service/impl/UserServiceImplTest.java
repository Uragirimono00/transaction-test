package com.example.transactiontest.user.service.impl;

import com.example.transactiontest.team.domain.model.Team;
import com.example.transactiontest.team.domain.repository.TeamRepository;
import com.example.transactiontest.user.domain.model.User;
import com.example.transactiontest.user.domain.repository.UserRepository;
import com.example.transactiontest.user.dto.request.UserSaveRequestDto;
import com.example.transactiontest.user.service.UserService;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@DataJpaTest
class UserServiceImplTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeamRepository teamRepository;

    @AfterEach
    public void cleanUp() {
        // 모든 유저 및 팀 데이터를 삭제합니다.
        userRepository.deleteAll();
        teamRepository.deleteAll();
    }

    @Test
    @DisplayName("특정 유저의 팀을 조회한다.")
    public void testIsUserInTeam() {
        // A라는 팀을 생성합니다.
        Team teamA = Team.builder()
                .id(1L)
                .teamName("A")
                .build();
        teamRepository.save(teamA);

        // 형서라는 이름을 가지고 A 팀에 속한 userA를 생성합니다.
        User userA = User.builder()
                .id(1L)
                .name("형서")
                .team(teamA)
                .build();
        userRepository.save(userA);

        // userA를 조회합니다.
        User foundUser = userRepository.findByName("형서");

        // 현재 팀이 A인지 확인합니다.
        assertEquals("A", foundUser.getTeam().getTeamName());
    }
}

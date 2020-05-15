package com.iamohsung.studyolle.settings;

import com.iamohsung.studyolle.WithAccount;
import com.iamohsung.studyolle.account.AccountRepository;
import com.iamohsung.studyolle.account.AccountService;
import com.iamohsung.studyolle.account.SignUpForm;
import com.iamohsung.studyolle.domain.Account;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.TestExecutionEvent;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SettingsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    AccountRepository accountRepository;

    @AfterEach
    void afterEach() {
        accountRepository.deleteAll();
    }

    @WithAccount("ohsung")
    @DisplayName("프로필 수정하기 - 입력값 정상")
    @Test
    void updateProfile() throws Exception {
        String bio = "짧은 소개를 수정하는 경우.";
        mockMvc.perform(post(SettingsController.SETTINGS_PROFILE_URL)
            .param("bio", bio)
            .with(csrf())
            .andExpect(status().isOk())
            .andExpect(view().name(SettingsController.SETTINGS_PROFILE_VIEW_NAME))
            .andExpect(model().hasErrors())
            .andExpect(model().attributeExists("account"))
            .andExpect(model().attributeExists("profile"));

        Account account = accountRepository.findByNickname("ohsung");
        assertEquals(bio, account.getBio());
    }
}

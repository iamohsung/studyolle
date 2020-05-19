package com.iamohsung.studyolle.settings.form;

import com.iamohsung.studyolle.domain.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Notifications {

    private boolean studyCreatedByEmail;
    private boolean studyCreatedByWeb = true;
    private boolean studyEnrollmentResultByEmail;
    private boolean studyEnrollmentResultByWeb = true;
    private boolean studyUpdatedByEmail;
    private boolean studyUpdatedByWeb = true;

    public Notifications(Account account) {

        this.studyCreatedByEmail = account.isStudyCreatedByEmail();
        this.studyCreatedByWeb = account.isStudyCreatedByWeb();
        this.studyEnrollmentResultByEmail = account.isStudyEnrollmentResultByEmail();
        this.studyEnrollmentResultByWeb = account.isStudyEnrollmentResultByWeb();
        this.studyUpdatedByEmail = account.isStudyUpdatedByEmail();
        this.studyUpdatedByWeb = account.isStudyUpdatedByWeb();
    }
}

package com.bilgeadam.BABaseApiPlaceholder.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SendAbsenceResponseDto {
    String absenceId;
    String userId;
    String group;
    String groupName;
    int absenceDateTheo;
    int hourOfAbsenceTheo;
    int totalCourseHoursTheo;
    int hourOfAbsenceLimitTheo;
    int absenceDatePrac;
    int hourOfAbsencePrac;
    int totalCourseHoursPrac;
    int hourOfAbsenceLimitPrac;
}

package com.eviden.billMe.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillMeErrorResponse {
    private HttpStatus status;
    private String errorCode;
    private String errorMessage;
}

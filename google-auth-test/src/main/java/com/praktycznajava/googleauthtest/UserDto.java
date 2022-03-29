package com.praktycznajava.googleauthtest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
class UserDto {
    private String username;
    private String secretKey;
    private int validationCode;
    private List<Integer> scratchCodes;
}


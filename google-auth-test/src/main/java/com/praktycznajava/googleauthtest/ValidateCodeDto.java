package com.praktycznajava.googleauthtest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
class ValidateCodeDto {
    private Integer code;
    private String username;
}



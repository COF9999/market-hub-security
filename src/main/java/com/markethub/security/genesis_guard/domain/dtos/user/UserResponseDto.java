package com.markethub.security.genesis_guard.domain.dtos.user;
import com.markethub.security.genesis_guard.domain.dtos.token.TokenDto;

public record UserResponseDto(UserRequestDto userRequestDto,
                              TokenDto tokenDto) {
}

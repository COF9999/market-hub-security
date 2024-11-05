package com.markethub.security.genesis_guard.domain.dtos.comment;

public record CommentaryRequestDto(Long id, Long idTransaction, String message, int valoration, String token) {
}

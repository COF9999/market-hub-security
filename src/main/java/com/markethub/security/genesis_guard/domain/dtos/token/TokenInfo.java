package com.markethub.security.genesis_guard.domain.dtos.token;

import java.util.Date;

public record TokenInfo(String email, Date issueAtDate, Date expDate) {
}

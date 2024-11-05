package com.markethub.security.genesis_guard.domain.dtos.product;

import com.markethub.security.genesis_guard.domain.dtos.token.TokenInfo;
import org.springframework.web.multipart.MultipartFile;

public record ProductRequestDto(Long id,
                                String category,
                                Float price,
                                Byte condition,
                                String name,
                                String imageUrl,
                                MultipartFile multipartFile,
                                String newFileName,
                                String description,
                                TokenInfo tokenInfo) {
}

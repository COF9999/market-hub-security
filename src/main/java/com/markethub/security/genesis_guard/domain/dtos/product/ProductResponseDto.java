package com.markethub.security.genesis_guard.domain.dtos.product;

public record ProductResponseDto(Long id,
                                 String category,
                                 Double price,
                                 Byte condition,
                                 String name,
                                 String imgUrl,
                                 String description
                                    )
{
}

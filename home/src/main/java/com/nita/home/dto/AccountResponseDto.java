package com.nita.home.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountResponseDto {
    private List<AccountDto> data;
    private Long totalElements;
    private int totalPageSize;
    private int pageNumber;
    private int pageSize;
    private boolean isLastPage;
}

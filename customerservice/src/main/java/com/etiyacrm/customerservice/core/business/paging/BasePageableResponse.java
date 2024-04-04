package com.etiyacrm.customerservice.core.business.paging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasePageableResponse {
    private int size;
    private long totalElements;
    private boolean hasNext;
    private boolean hasPrevious;
    private int totalPage;
}

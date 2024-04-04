package com.etiyacrm.customerservice.core.responses;

import com.etiyacrm.customerservice.core.business.paging.BasePageableResponse;

import java.util.ArrayList;
import java.util.List;

public class GetListResponse<T> extends BasePageableResponse {
    private List<T> items;

    public List<T> getItems() {
        if (items == null) {
            items = new ArrayList<>();
        }
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}

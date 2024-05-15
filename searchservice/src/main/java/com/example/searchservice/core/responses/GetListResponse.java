package com.example.searchservice.core.responses;

import com.example.searchservice.core.business.paging.BasePageableResponse;

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
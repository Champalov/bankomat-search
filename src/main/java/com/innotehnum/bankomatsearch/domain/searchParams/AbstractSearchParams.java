package com.innotehnum.bankomatsearch.domain.searchParams;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.session.RowBounds;

@Getter @Setter
public abstract class AbstractSearchParams {
    private int startPage;
    private int itemsPerPage;
    private String sortBy;
    private boolean sortDesc;

    public int getItemsPerPage() {
        if (itemsPerPage == 0) {
            itemsPerPage = Integer.MAX_VALUE;
            startPage = 0;
        }
        return itemsPerPage;
    }

    @JsonIgnore
    public int getOffset() {
        return  getItemsPerPage() * getStartPage();
    }

    @JsonIgnore
    public RowBounds getRowBounds() {
        return new RowBounds(getOffset(), getItemsPerPage());
    }
}

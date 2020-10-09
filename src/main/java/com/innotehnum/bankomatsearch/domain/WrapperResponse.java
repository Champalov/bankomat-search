package com.innotehnum.bankomatsearch.domain;

import com.innotehnum.bankomatsearch.domain.searchParams.AbstractSearchParams;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class WrapperResponse<T> {

    private ResponseInfo meta;
    private List<T> data;

    public WrapperResponse(List<T> content, AbstractSearchParams params, long total) {
        this.data = content;
        this.meta = new ResponseInfo(params, total);
    }

    @Getter
    @Setter
    public static class ResponseInfo {
        private long total;
        private int startPage;
        private int itemsPerPage;

        public ResponseInfo(AbstractSearchParams params, long total) {
            this.total = total;
            this.startPage = params.getStartPage();
            this.itemsPerPage = params.getItemsPerPage();
        }
    }
}

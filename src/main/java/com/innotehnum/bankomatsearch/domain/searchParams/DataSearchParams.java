package com.innotehnum.bankomatsearch.domain.searchParams;

import com.innotehnum.bankomatsearch.domain.Coordinates;
import lombok.Getter;
import lombok.Setter;

@Setter
public class DataSearchParams extends AbstractSearchParams {
    private Filter filters;

    public Filter getFilters() {
        if (filters == null)
            filters = new Filter();
        return filters;
    }

    public static DataSearchParams empty() {
        DataSearchParams params = new DataSearchParams();
        params.setItemsPerPage(Integer.MAX_VALUE);
        params.setFilters(new Filter());
        return params;
    }

    @Setter
    @Getter
    public static class Filter {
        private Coordinates coordinates;
        private Double radius;

        private String name;
        private String address;
        private String workingTime;
        private String url;

        private String rubricId;
        private String companyId;
    }
}

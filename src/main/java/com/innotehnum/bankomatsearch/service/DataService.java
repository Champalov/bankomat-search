package com.innotehnum.bankomatsearch.service;

import com.innotehnum.bankomatsearch.domain.Company;
import com.innotehnum.bankomatsearch.domain.WrapperResponse;
import com.innotehnum.bankomatsearch.domain.searchParams.DataSearchParams;

public interface DataService {
    void loadToBase(XmlLoadService.XmlSourceType xmlSourceType);
    WrapperResponse<Company> searchByParams(DataSearchParams params);
}

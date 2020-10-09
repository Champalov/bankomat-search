package com.innotehnum.bankomatsearch.service;

import com.innotehnum.bankomatsearch.domain.Company;

import java.util.List;

public interface XmlLoadService {
    List<Company> loadData(XmlSourceType xmlSourceType);

    enum XmlSourceType {URL, FILE}
}

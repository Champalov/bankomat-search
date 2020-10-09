package com.innotehnum.bankomatsearch;

import com.innotehnum.bankomatsearch.service.DataService;
import com.innotehnum.bankomatsearch.service.XmlLoadService;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BankomatSearchApplication.class)
class BankomatSearchApplicationTests {
    @Autowired
    private XmlLoadService xmlLoadService;
    @Autowired
    private DataService dataService;

    @Test
    @Ignore
    void companiesLoad() {
//        List<Company> companies = xmlLoadService.loadData();
//        dataService.insertCompanies(companies);
    }

}

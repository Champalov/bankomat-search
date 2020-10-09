package com.innotehnum.bankomatsearch.service;

import com.innotehnum.bankomatsearch.config.AppConfig;
import com.innotehnum.bankomatsearch.domain.Companies;
import com.innotehnum.bankomatsearch.domain.Company;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import java.io.File;
import java.net.URL;
import java.util.List;

@Service
@AllArgsConstructor
public class XmlLoadServiceImpl implements XmlLoadService {
    private final AppConfig config;

    public List<Company> loadData(XmlSourceType xmlSourceType) {
        try {
            var context = JAXBContext.newInstance(Companies.class);
            var um = context.createUnmarshaller();
            var companiesXml = xmlSourceType.equals(XmlSourceType.URL) ?
                    (Companies) um.unmarshal(new URL(config.getNspSourceUrl())) :
                    (Companies) um.unmarshal(new File(config.getNspSourceFile()));

            return companiesXml.getCompanies();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

package com.innotehnum.bankomatsearch.service;

import com.innotehnum.bankomatsearch.domain.Company;
import com.innotehnum.bankomatsearch.domain.WrapperResponse;
import com.innotehnum.bankomatsearch.domain.searchParams.DataSearchParams;
import com.innotehnum.bankomatsearch.repository.DataMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class DataServiceImpl implements DataService {
    private static final int INSERT_PORTION_SIZE = 1000;

    private final DataMapper dataMapper;
    private final XmlLoadService xmlLoadService;

    @Override
    public void loadToBase(XmlLoadService.XmlSourceType xmlSourceType) {
        List<Company> companies = xmlLoadService.loadData(xmlSourceType);

        dataMapper.deleteAll();
        for(int fromPos = 0; fromPos < companies.size(); fromPos += INSERT_PORTION_SIZE) {
            int toPos = fromPos + INSERT_PORTION_SIZE - 1;
            dataMapper.insertList(companies.subList(fromPos, toPos < companies.size() ? toPos : companies.size() - 1));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public WrapperResponse<Company> searchByParams(DataSearchParams params) {
        if (params == null) params = DataSearchParams.empty();

        long count = dataMapper.countByFilter(params);
        List<Company> companies = dataMapper.selectByFilter(params, params.getRowBounds());

        return new WrapperResponse<>(companies, params, count);
    }
}

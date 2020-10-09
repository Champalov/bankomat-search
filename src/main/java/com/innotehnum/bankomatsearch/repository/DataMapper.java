package com.innotehnum.bankomatsearch.repository;

import com.innotehnum.bankomatsearch.domain.Company;
import com.innotehnum.bankomatsearch.domain.searchParams.DataSearchParams;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface DataMapper {
    long countByFilter(@Param("searchParams") DataSearchParams searchParams);
    List<Company> selectByFilter(@Param("searchParams") DataSearchParams searchParams, RowBounds rowBounds);

    List<Company> selectAll();

    void insertList(List<Company> companies);
    void deleteAll();
    void insert(Company company);
}

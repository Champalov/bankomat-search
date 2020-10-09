package com.innotehnum.bankomatsearch.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement(name = "companies")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"companies"})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Companies {
    @XmlElement(name = "company")
    private ArrayList<Company> companies;
}

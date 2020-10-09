package com.innotehnum.bankomatsearch.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.Date;

@XmlRootElement(name = "company")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"companyId", "name", "country", "address", "addressAdd", "workingTime", "coordinates", "url", "rubricId", "actualizationDate"})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Company {
    @XmlTransient
    private Long id;
    @XmlElement(name = "company-id")
    private String companyId;
    @XmlElement
    private String name;
    @XmlElement
    private String country;
    @XmlElement
    private String address;
    @XmlElement(name = "address-add")
    private String addressAdd;
    @XmlElement(name = "working-time")
    private String workingTime;
    @XmlElement
    private Coordinates coordinates;
    @XmlElement
    private String url;
    @XmlElement(name = "rubric-id")
    private String rubricId;
    @XmlElement(name = "actualization-date")
    private String actualizationDate;
    @XmlTransient
    private Date timeAdded;
    @XmlTransient
    private Double distance;

//    private Map<String, Boolean> featureBoolean;
//    private Map<String, String> featureEnumMultiple;
}

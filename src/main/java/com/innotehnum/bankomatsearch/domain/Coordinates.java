package com.innotehnum.bankomatsearch.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.Date;

@XmlRootElement(name = "coordinates")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"lat", "lon"})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Coordinates {
    @XmlElement
    private Double lat;
    @XmlElement
    private Double lon;
}

package com.innotehnum.bankomatsearch.controller;

import com.innotehnum.bankomatsearch.domain.Company;
import com.innotehnum.bankomatsearch.domain.WrapperResponse;
import com.innotehnum.bankomatsearch.domain.searchParams.DataSearchParams;
import com.innotehnum.bankomatsearch.service.DataService;
import com.innotehnum.bankomatsearch.service.XmlLoadService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data")
@AllArgsConstructor
public class DataController {
    private final DataService dataService;

    @PostMapping("/load-from-xml")
    public ResponseEntity<Void> loadFromXml(XmlLoadService.XmlSourceType xmlSourceType) {
        dataService.loadToBase(xmlSourceType);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/search")
    public ResponseEntity<WrapperResponse<Company>> search(@RequestBody DataSearchParams params) {
        return ResponseEntity.ok(dataService.searchByParams(params));
    }
}

package za.ac.nwu.ac.web.sb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.ac.domain.service.GeneralResponce;

@RestController
public class DiscoveryController {

    @GetMapping("/all")
    public GeneralResponse<String> GetAll(){return new GeneralResponse<String>()};

}

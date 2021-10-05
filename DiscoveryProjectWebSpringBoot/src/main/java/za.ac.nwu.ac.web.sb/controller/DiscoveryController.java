package za.ac.nwu.ac.web.sb.controller;

import com.sun.net.httpserver.Authenticator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.ac.domain.service.GeneralResponse;

@RestController
@RequestMapping
public class DiscoveryController {

    @GetMapping("/all")
    public GeneralResponse<String> GetAll()
    {
       return new GeneralResponse<>(successfull true, payload "No");
    }

}

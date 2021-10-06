package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.MilesTypeDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateMilesTypeFlowInt;
import za.ac.nwu.ac.logic.flow.FetchMilesTypeFlow;
import java.util.List;

@RestController
@RequestMapping("Miles-Type")
public class DiscoveryController {

    private final FetchMilesTypeFlow fetchMilesTypeFlow;
    private final CreateMilesTypeFlowInt createMilesTypeFlowInt;

    @Autowired
    public DiscoveryController(FetchMilesTypeFlow fetchMilesTypeFlow,
                               @Qualifier("createMilesTypeFlowName") CreateMilesTypeFlowInt createMilesTypeFlowInt)
    {
        this.fetchMilesTypeFlow = fetchMilesTypeFlow;
        this.createMilesTypeFlowInt =createMilesTypeFlowInt;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all configured miles types", notes = "Returns list of miles types")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Miles Types returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<List<MilesTypeDto>>> getAll(){
        List<MilesTypeDto> milesTypes = fetchMilesTypeFlow.getAllMilesTypes();
        GeneralResponse<List<MilesTypeDto>> response = new GeneralResponse<>(true, "No types found");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Creates new Miles Type", notes = "Creates new Miles type in DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "MilesType was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GeneralResponse.class)
    })

    public ResponseEntity<GeneralResponse<MilesTypeDto>> create(
            @ApiParam(value = "Request to create a new MilesType, ",
            required = true)
            @RequestBody MilesTypeDto milesType){
        MilesTypeDto milesTypeResponse = createMilesTypeFlowInt.create(milesType);
        GeneralResponse<MilesTypeDto> response = new GeneralResponse<>(true, milesTypeResponse);
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
     }
}

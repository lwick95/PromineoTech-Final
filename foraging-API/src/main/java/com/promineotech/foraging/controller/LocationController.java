package com.promineotech.foraging.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.foraging.entity.ForagedItem;
import com.promineotech.foraging.entity.Location;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/location")
@OpenAPIDefinition(info = @Info(title= "Location Service") , servers = {
    @Server(url = "http://localhost:8080", description = "local server.")})
public interface LocationController {
//@formatter:off

  @Operation(
      summary = "Return a list of Locations",
      description = "Returns a list of locations for a given season",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of locations is returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Location.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "No locations where found with the input criteria",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occured. ",
              content = @Content(mediaType = "application/json"))
          
      },
      parameters = {
          @Parameter(name = "Season",
             allowEmptyValue = false,
             required = false,
             description = "The Locations season")
      }
     ) 

  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
   List<Location> fetchLocations(
       @RequestParam(required = false)
         String Season
       );
  
  @Operation(
      summary = "Create a new Location",
      description = "Creates a new location for a Foraged Item",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A location was created",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Location.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The input parameters are invalid",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "Cannot create location with input criteria",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occured. ",
              content = @Content(mediaType = "application/json"))
          
      },
      parameters = {
          @Parameter(name = "Country",
             allowEmptyValue = false,
             required = false,
             description = "The Items Country was created"),
          @Parameter(name = "Region",
            allowEmptyValue = false,
            required = false,
            description = "The Items Region was created"),
          @Parameter(name = "Season",
          allowEmptyValue = false,
          required = false,
          description = "The Items Season was created")  
      }
     )   
 @PostMapping
 @ResponseStatus(code = HttpStatus.CREATED)
  public Optional<Location> createNewLocation(
      @RequestParam(required = false) 
        String Country, 
      @RequestParam(required = false) 
        String Region,
      @RequestParam(required = false) 
        String Season 
        );
 
// @Operation(
//     summary = "Update a Location",
//     description = "Updates a Foraged Items Location",
//     responses = {
//         @ApiResponse(
//             responseCode = "200",
//             description = "Location has been updated",
//             content = @Content(
//                 mediaType = "application/json",
//                 schema = @Schema(implementation = ForagedItem.class))),
//         @ApiResponse(
//             responseCode = "400",
//             description = "The input parameters are invalid",
//             content = @Content(mediaType = "application/json")),
//         @ApiResponse(
//             responseCode = "404",
//             description = "Cannot update location with input criteria",
//             content = @Content(mediaType = "application/json")),
//         @ApiResponse(
//             responseCode = "500",
//             description = "An unplanned error occured. ",
//             content = @Content(mediaType = "application/json"))
//         
//     },
//     parameters = {
//         @Parameter(name = "Country",
//             allowEmptyValue = false,
//             required = false,
//             description = "The Items Country was created"),
//          @Parameter(name = "Region",
//            allowEmptyValue = false,
//            required = false,
//            description = "The Items Region was created"),
//          @Parameter(name = "Season",
//          allowEmptyValue = false,
//          required = false,
//          description = "The Items Season was created")  
//     }
//    ) 
//
// @PutMapping
// @ResponseStatus(code = HttpStatus.OK)
//  public Optional<Location> updateLocation(
//      @RequestParam(required = false) 
//        String Country, 
//      @RequestParam(required = false) 
//        String Region,
//      @RequestParam(required = false) 
//        String Season 
//        );
//  
//@formatter:on  

}

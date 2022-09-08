package com.promineotech.foraging.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.foraging.entity.ForagedItem;
import com.promineotech.foraging.entity.Reviews;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/Reviews")
@OpenAPIDefinition(info = @Info(title= "Reviews Service") , servers = {
    @Server(url = "http://localhost:8080", description = "local server.")})
public interface ReviewsController {
//@formatter:off
  @Operation(
      summary = "Return a list of Reviews",
      description = "Returns a list of Reviews off of the given item ID",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of reviews is returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ForagedItem.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "No reviews where found with the input criteria",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occured. ",
              content = @Content(mediaType = "application/json"))
          
      },
      parameters = {
          @Parameter(name = "item ID",
             allowEmptyValue = false,
             required = false,
             description = "The items ID for requested reviews")
      }
     ) 

  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
   List<Reviews> fetchReviews(
       @RequestParam(required = false) 
         Long item_ID); 
  
  @Operation(
      summary = "Create a new Review",
      description = "Creates a new Foraged Item Review",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A review was created",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Reviews.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The input parameters are invalid",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "Cannot create review with input criteria",
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occured. ",
              content = @Content(mediaType = "application/json"))
          
      },
      parameters = {
          @Parameter(name = "item ID",
             allowEmptyValue = false,
             required = false,
             description = "The items ID")
      }
     ) 

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
   public Optional<Reviews> createNewReview(
       @RequestParam(required = false) 
         Long item_ID, 
       @RequestParam(required = false) 
         String description,
       @RequestParam(required = false) 
         String edibility,
       @RequestParam(required = false)
         String availability
         );
  
//  @Operation(
//      summary = "Delete a Review",
//      description = "Deletes a Foraged Items review",
//      responses = {
//          @ApiResponse(
//              responseCode = "200",
//              description = "A review was deleted",
//              content = @Content(
//                  mediaType = "application/json",
//                  schema = @Schema(implementation = Reviews.class))),
//          @ApiResponse(
//              responseCode = "400",
//              description = "The input parameters are invalid",
//              content = @Content(mediaType = "application/json")),
//          @ApiResponse(
//              responseCode = "404",
//              description = "Cannot delete item with input criteria",
//              content = @Content(mediaType = "application/json")),
//          @ApiResponse(
//              responseCode = "500",
//              description = "An unplanned error occured. ",
//              content = @Content(mediaType = "application/json"))
//          
//      },
//      parameters = {
//          @Parameter(name = "review_ID",
//             allowEmptyValue = false,
//             required = false,
//             description = "The reviews ID")
//      }
//     ) 
//
//  @DeleteMapping
//  @ResponseStatus(code = HttpStatus.OK)
//   public Optional<Reviews> deleteReview(
//       @RequestParam(required = false) 
//         Long review_ID 
//         );
  
//@formatter:on  
}

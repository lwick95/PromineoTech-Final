package com.promineotech.foraging.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.foraging.entity.ForagedItem;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/foragedItems")
@OpenAPIDefinition(info = @Info(title= "Foraged Item Service") , servers = {
    @Server(url = "http://localhost:8080", description = "local server.")})
public interface ForagingController {
//@formatter:off
 @Operation(
     summary = "Return a list of foraged Items",
     description = "Returns a list of foraged items given an item type",
     responses = {
         @ApiResponse(
             responseCode = "200",
             description = "A list of items is returned",
             content = @Content(
                 mediaType = "application/json",
                 schema = @Schema(implementation = ForagedItem.class))),
         @ApiResponse(
             responseCode = "400",
             description = "The request parameters are invalid",
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "404",
             description = "No items where found with the input criteria",
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "500",
             description = "An unplanned error occured. ",
             content = @Content(mediaType = "application/json"))
         
     },
     parameters = {
         @Parameter(name = "item_type",
         allowEmptyValue = false,
         required = false,
         description = "The foraged items type")
     }
    ) 

 @GetMapping
 @ResponseStatus(code = HttpStatus.OK)
  List<ForagedItem> fetchForagedItem( 
      @RequestParam(required = false) 
        String item_type
      );
 
 @Operation(
     summary = "Create a new Foraged Item",
     description = "Creates a new Foraged Item",
     responses = {
         @ApiResponse(
             responseCode = "200",
             description = "A item was created",
             content = @Content(
                 mediaType = "application/json",
                 schema = @Schema(implementation = ForagedItem.class))),
         @ApiResponse(
             responseCode = "400",
             description = "The input parameters are invalid",
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "404",
             description = "Cannot create item with input criteria",
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "500",
             description = "An unplanned error occured. ",
             content = @Content(mediaType = "application/json"))
         
     },
     parameters = {
         @Parameter(name = "item name",
             allowEmptyValue = false,
             required = false,
             description = "The item name"),
          @Parameter(name = "item type",
            allowEmptyValue = false,
            required = false,
            description = "The item type"),
          @Parameter(name = "species name",
            allowEmptyValue = false,
            required = false,
            description = "The species name")
     }
    ) 

 @PostMapping
 @ResponseStatus(code = HttpStatus.CREATED)
  Optional<ForagedItem> createNewItem(
      @RequestParam(required = false) 
        String item_name, 
      @RequestParam(required = false) 
        String item_type,
      @RequestParam(required = false) 
        String species_name 
        );
 
 @Operation(
     summary = "Update a Foraged Item",
     description = "Updates a Foraged Item",
     responses = {
         @ApiResponse(
             responseCode = "200",
             description = "A item was updated",
             content = @Content(
                 mediaType = "application/json",
                 schema = @Schema(implementation = ForagedItem.class))),
         @ApiResponse(
             responseCode = "400",
             description = "The input parameters are invalid",
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "404",
             description = "Cannot update item with input criteria",
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
             description = "The items ID"),
         @Parameter(name = "item name",
            allowEmptyValue = false,
            required = false,
            description = "The items name"),
         @Parameter(name = "item type",
           allowEmptyValue = false,
           required = false,
           description = "The items type"),
         @Parameter(name = "species name",
           allowEmptyValue = false,
           required = false,
           description = "The species name")
     }
    ) 

 @PutMapping
 @ResponseStatus(code = HttpStatus.OK)
  public Optional<ForagedItem> updateItem(
      @RequestParam(required = false) 
        Long item_ID, 
      @RequestParam(required = false) 
        String item_name, 
      @RequestParam(required = false) 
        String item_type,
      @RequestParam(required = false) 
        String species_name 
        );
 
 @Operation(
     summary = "Delete a Foraged Item",
     description = "Deletes a Foraged Item by ID",
     responses = {
         @ApiResponse(
             responseCode = "200",
             description = "A item was deleted",
             content = @Content(
                 mediaType = "application/json",
                 schema = @Schema(implementation = ForagedItem.class))),
         @ApiResponse(
             responseCode = "400",
             description = "The input parameters are invalid",
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "404",
             description = "Cannot delete item with input criteria",
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "500",
             description = "An unplanned error occured. ",
             content = @Content(mediaType = "application/json"))
         
     },
     parameters = {
         @Parameter(name = "item_ID",
            allowEmptyValue = false,
            required = false,
            description = "The item ID")
     }
    ) 

 @DeleteMapping
 @ResponseStatus(code = HttpStatus.OK)
  public Optional<ForagedItem> deleteItem(
      @RequestParam(required = false) 
        Long item_ID  
        );
 
 //@formatter:on
}

package edu.bechraoui.product.controllers;

import edu.bechraoui.product.model.Product;
import edu.bechraoui.product.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Set;


/**
 * Created by aminebechraoui, on 24/02/2023, in edu.bechraoui.product.controllers
 */
@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/product")
    @Operation(summary = "Get all products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Server respond with all available products"),
            @ApiResponse(responseCode = "400", description = "Internal error, server could not respond")
    })
    public ResponseEntity<Set<Product>> getProducts() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/hostname")
    @Operation(summary = "Get hostname")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Server respond hostname"),
            @ApiResponse(responseCode = "400", description = "Internal error, server could not respond")
    })
    public ResponseEntity<String> getHostName() throws SocketException, UnknownHostException {
        return new ResponseEntity<>(productService.getHostName(), HttpStatus.OK);
    }
}

package com.markethub.security.genesis_guard.infraestructure.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.markethub.security.genesis_guard.domain.dtos.product.ProductRequestDto;
import com.markethub.security.genesis_guard.domain.dtos.product.ProductResponseDto;
import com.markethub.security.genesis_guard.domain.dtos.token.TokenDto;
import com.markethub.security.genesis_guard.domain.dtos.token.TokenInfo;
import com.markethub.security.genesis_guard.domain.dtos.user.UserResponseDto;
import com.markethub.security.genesis_guard.infraestructure.globalbeans.SpringConfigBeans;
import com.markethub.security.genesis_guard.infraestructure.rest.advicers.ErrorMessage;
import com.markethub.security.genesis_guard.infraestructure.rest.advicers.IndeterminateErrorMessage;
import com.markethub.security.genesis_guard.infraestructure.rest.advicers.exceptions.ResourceUnauthorized;
import com.markethub.security.genesis_guard.infraestructure.security.jwtspace.Jwt;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/product")
public class ProductControllerRest {

    private final RestTemplate restTemplate;

    private final String baseUriProductKernel = "/product";

    private final Jwt jwt;

    public ProductControllerRest(RestTemplate restTemplate,Jwt jwt){
        this.restTemplate = restTemplate;
        this.jwt = jwt;
    }


    @GetMapping("/{id}")
    public ProductResponseDto getProduct(@PathVariable Long id){
        return restTemplate.postForObject(SpringConfigBeans.urlBaseKernel+baseUriProductKernel+"/register",
                id,
                ProductResponseDto.class);
    }

    @PostMapping("/")
    public ResponseEntity<?> createProduct(
            @RequestParam("file") MultipartFile file,
            @RequestParam("newFileName") String newFileName,
            @RequestParam("category") String category,
            @RequestParam("price") Float price,
            @RequestParam("condition") Byte condition,
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("tokenDto") TokenDto tokenDto,
            HttpServletRequest httpServletRequest

    )
    {
        System.out.println("entro");
        TokenInfo tokenInfo = (TokenInfo) httpServletRequest.getAttribute("tokenInfo");
        ProductRequestDto productDto = new ProductRequestDto(
                null,
                category,
                price,
                condition,
                name,
                null,
                file,
                newFileName,
                description,
                tokenInfo
        );

        try {
            ProductResponseDto productResponseDto =  restTemplate.postForObject(SpringConfigBeans.urlBaseKernel+baseUriProductKernel+"/",
                    productDto,
                    ProductResponseDto.class);
           return ResponseEntity.ok(productResponseDto);
        }catch (HttpStatusCodeException ex1){
            IndeterminateErrorMessage indeterminateErrorMessage = new IndeterminateErrorMessage(
                    ex1.getClass().getTypeName(),
                    ex1.getResponseBodyAsString(),
                    ex1.getStatusCode().value()
            );
           return ResponseEntity.status(ex1.getStatusCode()).body(indeterminateErrorMessage);
        }catch (Exception ex2){
            System.out.println(ex2);
            IndeterminateErrorMessage indeterminateErrorMessage = new IndeterminateErrorMessage(
                    ex2.getClass().getTypeName(),
                    ex2.getMessage(),
                    500
            );
            return ResponseEntity.internalServerError().body(indeterminateErrorMessage);
        }
    }

    @PatchMapping("/updateProduct")
    public ProductResponseDto updateProduct(@RequestBody ProductRequestDto productDto){
        return restTemplate.patchForObject(SpringConfigBeans.urlBaseKernel+baseUriProductKernel+"/",productDto,ProductResponseDto.class);
    }

    @DeleteMapping("/active-delete-product/{id}")
    public void activeDeleteProduct(@PathVariable Long id){
        restTemplate.delete(
                SpringConfigBeans.urlBaseKernel+baseUriProductKernel+"/active-delete-product/"+id);
    }

    @PostMapping("/mock")
    public String mockProduct(@RequestBody TokenDto tokenDto, HttpServletRequest httpServletRequest){
        TokenInfo tokenInfo = (TokenInfo) httpServletRequest.getAttribute("tokenInfo");
        return restTemplate.postForObject(SpringConfigBeans.urlBaseKernel+baseUriProductKernel+"/mock",tokenInfo,String.class);
    }

}

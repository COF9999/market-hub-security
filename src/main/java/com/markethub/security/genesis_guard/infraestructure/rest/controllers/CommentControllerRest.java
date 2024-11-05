package com.markethub.security.genesis_guard.infraestructure.rest.controllers;

import com.markethub.security.genesis_guard.domain.dtos.comment.CommentaryRequestDto;
import com.markethub.security.genesis_guard.infraestructure.globalbeans.SpringConfigBeans;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/commentary")
public class CommentControllerRest {

    private  final RestTemplate restTemplate;

    //private final String baseUriCommentKernel = "/commentary";

    public CommentControllerRest(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @PostMapping("/")
    public void createCommnet(@RequestBody CommentaryRequestDto commentaryRequestDto){
     //   restTemplate.postForObject(SpringConfigBeans.urlBaseKernel+baseUriCommentKernel+"/",commentaryRequestDto,Void.class);

    }


}

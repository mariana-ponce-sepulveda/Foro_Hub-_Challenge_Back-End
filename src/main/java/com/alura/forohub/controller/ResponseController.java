package com.andromeda.forohub.controller;

import com.andromeda.forohub.dto.RespRequestDTO;
import com.andromeda.forohub.dto.RespResponseDTO;
import com.andromeda.forohub.service.ResponseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/responses")
public class ResponseController {

    private final ResponseService responseService;

    public ResponseController(ResponseService responseService) {
        this.responseService = responseService;
    }

    @PostMapping
    public ResponseEntity<RespResponseDTO> register(@RequestBody @Valid RespRequestDTO resp){
        var response = responseService.register(resp);
        return ResponseEntity.ok(response);
    }
}

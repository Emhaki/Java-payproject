package com.springbootpay.membershipservice.adaptor.in.web;

import com.springbootpay.membershipservice.application.port.in.RegisterMembershipCommand;
import com.springbootpay.membershipservice.application.port.in.RegisterMembershipUseCase;
import common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {

    private final RegisterMembershipUseCase registerMembershipUseCase;

    @PostMapping(path = "/membership/register")
    void registerMembership(@RequestBody RegisterMembershipRequest request) {
        // request~~
        // request -> Command

        // Usecase -- request

        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
                .name(request.getName())
                .address(request.getAddress())
                .email(request.getEmail())
                .isValid(true)
                .isCorp(request.isCorp())
                .build();

        registerMembershipUseCase.registerMembership(command);
    }
}

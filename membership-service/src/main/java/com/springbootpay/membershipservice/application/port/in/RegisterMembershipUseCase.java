package com.springbootpay.membershipservice.application.port.in;

import common.UseCase;

@UseCase
public interface RegisterMembershipUseCase {

    void registerMembership(RegisterMembershipCommand command);
}

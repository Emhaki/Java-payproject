package com.springbootpay.membershipservice.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Membership {

    @Getter private final String membershipId;
    @Getter private final String name;
    @Getter private final String email;
    @Getter private final String address;
    @Getter private final boolean isValid;
    @Getter private final boolean isCorp;

    // Membership 고객 정보에 대한 핵심 도메인이기 때문에
    // 오염이 되면 안되는 도메인

    public static Membership generateMember (
        MembershipId membershipId,
        MembershipName membershipName,
        MembershipEmail membershipEmail,
        MembershipAddress membershipAddress,
        MembershipIsValid membershipIsValid,
        MembershipIsCorp membershipIsCorp
    ){
        return new Membership(
                membershipId.membershipId,
                membershipName.nameValue,
                membershipEmail.MembershipEmail,
                membershipAddress.MembershipAddress,
                membershipIsValid.isValidValue,
                membershipIsCorp.isCorpValue
        );
    }

    @Value
    public static class MembershipId {
        public MembershipId(String value) {
            this.membershipId = value;
        }
        String membershipId;
    }

    @Value
    public static class MembershipName {
        public MembershipName(String value) {
            this.nameValue = value;
        }
        String nameValue;
    }

    @Value
    public static class MembershipEmail {
        public MembershipEmail(String value) {
            this.MembershipEmail = value;
        }
        String MembershipEmail;
    }

    @Value
    public static class MembershipAddress {
        public MembershipAddress(String value) {
            this.MembershipAddress = value;
        }
        String MembershipAddress;
    }

    @Value
    public static class MembershipIsValid {
        public MembershipIsValid(boolean value) {
            this.isValidValue = value;
        }
        boolean isValidValue;
    }

    @Value
    public static class MembershipIsCorp {
        public MembershipIsCorp(boolean value) {
            this.isCorpValue = value;
        }
        boolean isCorpValue;
    }
}

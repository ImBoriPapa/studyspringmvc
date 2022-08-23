package review.studyspringmvc.basic2.dto;

import lombok.Data;

@Data
public class MemberDTO {

    private String memberName;
    private MemberRole memberRole;

    public enum MemberRole {GUEST,VIP}

    public MemberDTO(String memberName, MemberRole memberRole) {
        this.memberName = memberName;
        this.memberRole = memberRole;
    }

}

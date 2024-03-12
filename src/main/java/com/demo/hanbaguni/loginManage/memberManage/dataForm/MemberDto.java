package com.demo.hanbaguni.loginManage.memberManage.dataForm;

import com.demo.hanbaguni.dtoUtility.UpdatableDto;
import com.demo.hanbaguni.loginManage.memberManage.entity.Member;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto  implements UpdatableDto {
    @Override
    public void update(Object target) {
        if(target instanceof Member member) {
            member.setMemberId(this.memberDtoId);
            member.setMemberPassword(this.memberDtoPassword);
            member.setMemberName(this.memberDtoName);
        }
    }


    @Size(min = 8, max = 25)
    @NotEmpty(message = "Not insert member ID")
    private String memberDtoId;

    @Size(min = 8, max = 25)
    @NotEmpty(message = "Not insert member password")
    private String memberDtoPassword;

    @Size(min = 2, max = 20)
    @NotEmpty(message = "Not insert member name")
    private String memberDtoName;
}

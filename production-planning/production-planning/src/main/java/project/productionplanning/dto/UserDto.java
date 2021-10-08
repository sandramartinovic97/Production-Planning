package project.productionplanning.dto;

import lombok.Data;

@Data
public class UserDto {
    private Integer userId;
    private String userName;
    private String userSurname;
    private String userUsername;
    private String userEmail;
    private String userPassword;
    private RoleDto roleDto;
}

package com.projectcamp_backend.projectmanagement.payload.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private Long id;
    private String username;
    private String email;
    private Boolean isVerified;
}

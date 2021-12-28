package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Setter
@Getter
public class UserLogin {

    private String login;
    private String senha;

    public UserLogin() {
        super();
    }
}

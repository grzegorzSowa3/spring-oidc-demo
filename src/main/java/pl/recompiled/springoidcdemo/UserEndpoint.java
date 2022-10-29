package pl.recompiled.springoidcdemo;

import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class UserEndpoint {

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal AuthenticatedPrincipal principal) {
        String name;
        if (principal instanceof OAuth2User oAuth2User) {
            name = oAuth2User.getAttribute("login");
        } else {
            name = principal.getName();
        }
        return Collections.singletonMap("name", name);
    }
}

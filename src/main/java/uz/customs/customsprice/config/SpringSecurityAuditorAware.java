package uz.customs.customsprice.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import uz.customs.customsprice.entity.users.User;

import java.util.Optional;

public class SpringSecurityAuditorAware implements AuditorAware<String> {

    @Override
    public @NotNull Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication != null ? authentication.getPrincipal() : "";
        User user = new User();
        if (!principal.equals("")) {
            if (!principal.toString().equals("anonymousUser")) {
                user = (User) principal;
                return Optional.ofNullable(user.getId());
            } else {
                return Optional.ofNullable(authentication.getName());
            }
        } else {
            return Optional.ofNullable("");
        }
    }
}

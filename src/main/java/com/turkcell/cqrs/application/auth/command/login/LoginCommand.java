package com.turkcell.cqrs.application.auth.command.login;

import an.awesome.pipelinr.Command;
import com.turkcell.cqrs.core.exception.type.BusinessException;
import com.turkcell.cqrs.core.jwt.JwtService;
import com.turkcell.cqrs.domain.entity.User;
import com.turkcell.cqrs.persistance.user.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Data
public class LoginCommand implements Command<LoginCommandResponse>
{
    private String email;
    private String password;

    @Component
    @RequiredArgsConstructor
    public static class LoginCommandHandler implements Command.Handler<LoginCommand,LoginCommandResponse>
    {
        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;

        @Override
        public LoginCommandResponse handle(LoginCommand loginCommand) {
            User user = userRepository.findByEmail(loginCommand.getEmail())
                    .orElseThrow(() -> new BusinessException("Bad credentials"));
            boolean isPasswordCorrect = passwordEncoder.matches(loginCommand.getPassword(), user.getPassword());
            if(!isPasswordCorrect)
                throw new BusinessException("Bad credentials");

            Map<String,Object> claims = new HashMap<>();
            claims.put("id", user.getId());
            String jwt = jwtService.generateToken(user.getEmail(), claims);
            return new LoginCommandResponse(jwt);
        }
    }
}

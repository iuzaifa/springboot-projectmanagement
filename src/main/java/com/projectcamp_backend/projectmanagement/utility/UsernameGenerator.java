package com.projectcamp_backend.projectmanagement.utility;

import com.projectcamp_backend.projectmanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class UsernameGenerator {

    private final UserRepository userRepository;

    public String generateUsername(String fullName) {

        String baseUsername = fullName
                .trim()
                .toLowerCase()
                .replaceAll("\\s+", "_")
                .replaceAll("[^a-z0-9_]", "");

        String username = baseUsername;

        Random random = new Random();

        while (userRepository.existsByUsername(username)) {

            int randomNumber = 100 + random.nextInt(900);

            username = baseUsername + randomNumber;
        }

        return username;
    }
}
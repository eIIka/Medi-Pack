package ua.ellka.medipack.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ua.ellka.medipack.model.User;
import ua.ellka.medipack.model.security.MediPackUserDetails;
import ua.ellka.medipack.repo.UserRepo;

@RequiredArgsConstructor
public class MediPackUserDetailsService implements UserDetailsService {
    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        return new MediPackUserDetails(user);
    }
}

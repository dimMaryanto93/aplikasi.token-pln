package com.tabeldata.pln.services;

import com.tabeldata.pln.model.Pelanggan;
import com.tabeldata.pln.model.Staff;
import com.tabeldata.pln.model.User;
import com.tabeldata.pln.repository.PelangganRepository;
import com.tabeldata.pln.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private PelangganRepository pelangganRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        Pelanggan pelanggan = pelangganRepository.findByUsername(username);
        Staff staff = staffRepository.findByUsername(username);

        if (pelanggan != null) {
            return new UserPrincipal(pelanggan, false);
        } else if (staff != null) {
            return new UserPrincipal(staff, true);
        } else {
            User user = new User();
            user.setActive(false);
            return new UserPrincipal(user, false);
        }
    }

    public class UserPrincipal implements UserDetails {

        private boolean admin;
        private User user;

        public UserPrincipal(User user, boolean isAdmin) {
            this.user = user;
            this.admin = isAdmin;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return this.admin ?
                    Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")) :
                    Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
        }

        @Override
        public String getPassword() {
            return user.getPassword();
        }

        @Override
        public String getUsername() {
            return user.getUsername();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return this.user.isActive();
        }
    }
}

package org.fleetingly.auth.repository;

import org.fleetingly.auth.domain.UserDetails;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@ApplicationScoped
public class UserDetailsRepository {

    private Set<UserDetails> employees = new HashSet<>();

    public UserDetailsRepository() {
        add(new UserDetails(1L,  "John Smith", 50,"Developer"));
        add(new UserDetails(1L,  "Paul Walker", 40, "Architect"));
    }

    public UserDetails add(UserDetails UserDetails) {
        UserDetails.setId((long) (employees.size()+1));
        employees.add(UserDetails);
        return UserDetails;
    }

    public UserDetails findById(Long id) {
        Optional<UserDetails> UserDetails = employees.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();
        if (UserDetails.isPresent())
            return UserDetails.get();
        else
            return null;
    }

    public Set<UserDetails> findAll() {
        return employees;
    }


}

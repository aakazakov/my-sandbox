package dev.fun.examples;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dev.fun.examples.dao.AuthorityRepository;
import dev.fun.examples.dao.RoleRepository;
import dev.fun.examples.dao.UserRepository;
import dev.fun.examples.domain.Authority;
import dev.fun.examples.domain.Role;
import dev.fun.examples.domain.User;

@Component
public class DataFiller implements CommandLineRunner {
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Authority auth1 = authorityRepository.save(new Authority("auth1"));
		Authority auth2 = authorityRepository.save(new Authority("auth2"));
		Authority auth3 = authorityRepository.save(new Authority("auth3"));
		Authority auth4 = authorityRepository.save(new Authority("auth4"));
		Authority auth5 = authorityRepository.save(new Authority("auth5"));
		Authority auth6 = authorityRepository.save(new Authority("auth6"));
		
		Role role1 = roleRepository.save(new Role("role1"));
		Role role2 = roleRepository.save(new Role("role2"));
		Role role3 = roleRepository.save(new Role("role3"));
		
		role1.setAuthorities(Arrays.asList(auth1, auth2, auth3, auth4, auth5, auth6));
		role2.setAuthorities(Arrays.asList(auth1, auth2, auth3, auth4));
		role1.setAuthorities(Arrays.asList(auth1, auth2));
		
		roleRepository.saveAll(Arrays.asList(role1, role2, role3));
		
		userRepository.saveAll(Arrays.asList(
				new User("user1", "pass1", role1),
				new User("user2", "pass2", role2),
				new User("user3", "pass3", role2),
				new User("user4", "pass4", role3)
		));
				
	}

}

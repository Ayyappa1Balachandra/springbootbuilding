package com.stacksimplify.restServices.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stacksimplify.restServices.Entites.UserData;

@Repository
public interface UserRepository extends JpaRepository<UserData, Long> {



	boolean existsByUserName(String userName);

	Optional<UserData> findByUserName(String userName);

}

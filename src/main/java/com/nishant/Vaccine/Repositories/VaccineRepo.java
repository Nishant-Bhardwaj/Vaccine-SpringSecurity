package com.nishant.Vaccine.Repositories;

import com.nishant.Vaccine.Model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRepo extends JpaRepository<Vaccine, String> {

}

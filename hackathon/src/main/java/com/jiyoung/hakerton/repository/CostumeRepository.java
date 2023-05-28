package com.jiyoung.hakerton.repository;

import com.jiyoung.hakerton.domain.Costume;
import com.jiyoung.hakerton.domain.Flag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CostumeRepository extends JpaRepository<Costume, Long> {

}

package com.jiyoung.hakerton.repository;

import com.jiyoung.hakerton.domain.Flag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FlagRepository extends JpaRepository<Flag, Long> {


}

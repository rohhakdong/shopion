package com.shopion.domain.code;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordDictRepository extends JpaRepository<WordDict, String> {

    List<WordDict> findByKorWordContainingOrEngWordContaining(String korWord, String engWord);

}

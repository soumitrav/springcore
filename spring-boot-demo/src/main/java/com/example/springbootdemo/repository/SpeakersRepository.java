package com.example.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootdemo.models.Speaker;

public interface SpeakersRepository extends JpaRepository<Speaker, Long>{

}

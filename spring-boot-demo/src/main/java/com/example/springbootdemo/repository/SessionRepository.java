package com.example.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootdemo.models.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

}

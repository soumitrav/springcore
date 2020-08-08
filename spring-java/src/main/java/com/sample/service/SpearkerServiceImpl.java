package com.sample.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dao.SpeakerRepository;
import com.sample.model.Spearker;

@Service("speakerService")
public class SpearkerServiceImpl implements SpeakerService {

	SpeakerRepository speakerRepository;
	
	@Autowired
	public SpearkerServiceImpl(SpeakerRepository speakerRepository) {
		System.out.println("constructor args");
		this.speakerRepository = speakerRepository;
	}

	public SpearkerServiceImpl() {
		System.out.println("no args");
	}

	public List<Spearker> getAllSpearker(){
		return speakerRepository.getAllSpeaker();
	}

	public SpeakerRepository getSpeakerRepository() {
		return speakerRepository;
	}

	@PostConstruct
	public void init() {
		System.out.println("Inside init");
	}
	
	public void setSpeakerRepository(SpeakerRepository speakerRepository) {
		System.out.println("Setter");
		this.speakerRepository = speakerRepository;
	}
	
}

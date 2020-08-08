package com.sample.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sample.model.Spearker;

@Repository("speakerRepository")
public class SpeakerRepositoryImpl implements SpeakerRepository {

	@Autowired
	private Calendar cale;
	
	@Autowired
	private Tool tool;
	
	@Override
	public List<Spearker> getAllSpeaker(){
		
		List<Spearker> speaker = new ArrayList<Spearker>();
		Spearker s = new Spearker();
		s.setFirstName("Soumitra");
		s.setLastName("Pathak");
		speaker.add(s);
		System.out.println(cale.getTime());
		System.out.println(tool.getName());
		return speaker;
	}
}

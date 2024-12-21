package com.sbr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbr.dao.SubjectDao;
import com.sbr.entities.Subject;

@Service
public class SubjectService {
	@Autowired
	SubjectDao subjectDao;

	public List<Subject> getAllSubjects() {

		List<Subject> allSubjects = subjectDao.getAllSubjects();
		return allSubjects;
	}

	public Subject getSubjectById(Long id) {
		List<Subject> allSubjects = subjectDao.getAllSubjects();
		for (Subject subject : allSubjects) {
			if (subject.getId() == id) {
				return subject;
			}
		}
		return null;
	}

	public Subject saveSubject(Subject subject) {

		return subjectDao.saveSubject(subject);

	}

	public Subject deleteSubject(Long id) {
		return subjectDao.deleteSubject(id);

	}

}

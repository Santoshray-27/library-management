package com.example.library_management.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library_management.Model.Faculty;
import com.example.library_management.Repository.FacultyRepo;

@Service
public class FacultyService {
    @Autowired
    private FacultyRepo fr;

    // Faculty Entry..
    public void fsave(Faculty faculty) {
        fr.save(faculty);
    }

    // Book View..
    public List<Faculty> getAllFacultys() {
        return fr.findAll();
    }

    // Faculty Update..
    public Faculty getFacultyById(int id) {
        Optional<Faculty> optional = fr.findById(id);
        Faculty faculty = null;
        if (optional.isPresent())
            faculty = optional.get();
        else
            throw new RuntimeException(
                    "Customer not found for id : " + id);
        return faculty;
    }

    // Delete faculty
    public void deleteFacultyById(int id) {
        fr.deleteById(id);
    }
}

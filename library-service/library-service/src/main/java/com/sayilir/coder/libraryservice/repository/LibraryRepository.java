package com.sayilir.coder.libraryservice.repository;

import com.sayilir.coder.libraryservice.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, String> {
}

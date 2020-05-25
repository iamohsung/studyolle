package com.iamohsung.studyolle.tag;

import com.iamohsung.studyolle.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface TagRepository extends JpaRepository<Tag, Long> {

//    Optional<Tag> findByTitle(String title);
    Tag findByTitle(String title);
}

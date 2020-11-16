package com.huex.assignments;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This is a repository class
 */
public interface Repository extends JpaRepository<CSVModel, String> {
}

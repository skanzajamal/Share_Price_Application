package com.repository;

import com.model.FilterTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilterRepository extends JpaRepository<FilterTable, Long> {

} //ENDINTERFACE

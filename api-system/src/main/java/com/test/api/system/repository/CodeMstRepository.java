package com.test.api.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.api.system.entity.CodeMst;
import com.test.api.system.repository.coustom.CodeMstRepositoryCustom;

public interface CodeMstRepository extends JpaRepository<CodeMst, Long>, CodeMstRepositoryCustom {

}

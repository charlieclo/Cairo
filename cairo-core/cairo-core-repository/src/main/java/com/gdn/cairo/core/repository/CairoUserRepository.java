package com.gdn.cairo.core.repository;

import com.gdn.cairo.core.entity.CairoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Charlie Leonardo Oroh
 */

@Repository
public interface CairoUserRepository extends JpaRepository<CairoUser, String> {
}

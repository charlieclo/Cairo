package com.gdn.cairo.core.repository;

import com.gdn.cairo.core.entity.GoodsPurchaseRequest;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Charlie Leonardo Oroh
 */

@Repository
public interface GoodsPurchaseRequestRepository extends ElasticsearchRepository<GoodsPurchaseRequest, String> {
}

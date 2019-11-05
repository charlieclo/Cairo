package com.gdn.cairo.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * @author Charlie Leonardo Oroh
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

  @Version
  @Column(name = "version")
  protected Long version;

  @CreatedDate
  @Column(name = "created_date")
  protected Long createdDate;

  @CreatedBy
  @Column(name = "created_by")
  protected String createdBy;

  @LastModifiedDate
  @Column(name = "last_modified_date")
  protected Long lastModifiedDate;

  @LastModifiedBy
  @Column(name = "last_modified_by")
  protected String lastModifiedBy;

}

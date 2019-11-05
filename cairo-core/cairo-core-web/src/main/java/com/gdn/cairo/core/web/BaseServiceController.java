package com.gdn.cairo.core.web;

import brave.Tracer;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Charlie Leonardo Oroh
 */

public class BaseServiceController {

  @Autowired
  protected Tracer tracer;
}

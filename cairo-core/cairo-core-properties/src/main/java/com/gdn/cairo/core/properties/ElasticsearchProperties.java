package com.gdn.cairo.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Charlie Leonardo Oroh
 */

@Data
@ConfigurationProperties("elasticsearch")
public class ElasticsearchProperties {

  private String clusterName;

  private String host;

  private int port;
}

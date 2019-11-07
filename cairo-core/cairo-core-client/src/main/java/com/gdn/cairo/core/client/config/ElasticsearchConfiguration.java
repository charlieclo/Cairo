package com.gdn.cairo.core.client.config;

import com.gdn.cairo.core.properties.ElasticsearchProperties;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.net.InetAddress;

/**
 * @author Charlie Leonardo Oroh
 */

@Slf4j
@Configuration
public class ElasticsearchConfiguration {

  @Autowired
  private ElasticsearchProperties elasticsearchProperties;

  @Bean
  public Client client() throws Exception {
    Settings settings = Settings.builder()
      .put("cluster.name", elasticsearchProperties.getClusterName())
      .build();

    TransportClient transportClient = new PreBuiltTransportClient(settings);
    transportClient.addTransportAddress(new TransportAddress(InetAddress.getByName(elasticsearchProperties.getHost()), elasticsearchProperties.getPort()));
    return transportClient;
  }

  @Bean
  public ElasticsearchOperations elasticsearchTemplate() throws Exception {
    return new ElasticsearchTemplate(client());
  }

//  (Implementation Using RestHighLevelClient)
//  private RestHighLevelClient restHighLevelClient;
//
//  @Override
//  public Class<RestHighLevelClient> getObjectType() {
//    return RestHighLevelClient.class;
//  }
//
//  @Override
//  protected RestHighLevelClient createInstance() throws Exception {
//    return buildClient();
//  }
//
//  private RestHighLevelClient buildClient() {
//    try {
//      restHighLevelClient = new RestHighLevelClient(
//        RestClient.builder(
//          new HttpHost(
//            elasticsearchProperties.getHost(),
//            elasticsearchProperties.getPort(),
//            elasticsearchProperties.getScheme())));
//    } catch (Exception e) {
//      log.error(e.getMessage());
//    }
//    return restHighLevelClient;
//  }
}

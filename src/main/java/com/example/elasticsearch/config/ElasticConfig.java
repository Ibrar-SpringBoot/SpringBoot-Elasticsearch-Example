package com.example.elasticsearch.config;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestClientBuilder.RequestConfigCallback;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticConfig {
	
	@Value("${elasticsearch.host}")
	private String elasticsearchHost;

	@Value("${elasticsearch.port}")
	private int elasticsearchPort;

	private int timeout = 6000;

	public RestHighLevelClient client() {

   	 System.out.println("host:"+ elasticsearchHost+"port:"+elasticsearchPort);
   	 
        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        
        credentialsProvider.setCredentials(AuthScope.ANY,new UsernamePasswordCredentials("", ""));
        
        RestClientBuilder builder = RestClient.builder(new HttpHost(elasticsearchHost, elasticsearchPort, "http")).setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider));
        
        builder.setRequestConfigCallback(new RequestConfigCallback() {
			
			@Override
			public Builder customizeRequestConfig(Builder requestConfigBuilder) {
				// TODO Auto-generated method stub
				
				requestConfigBuilder.setConnectTimeout(timeout);
				requestConfigBuilder.setSocketTimeout(timeout);
				requestConfigBuilder.setConnectionRequestTimeout(timeout);
				
				return null;
			}
		});

        RestHighLevelClient client = new RestHighLevelClient(builder);
        return client;
   }
}

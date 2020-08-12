package com.test.geteway.filter;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

import org.springframework.beans.factory.annotation.Value;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PreZuulFilter extends ZuulFilter {

    @Value("${header.access-key}")
    private String accessKey;
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		log.info("filter test key {} !!", accessKey);
		RequestContext context = RequestContext.getCurrentContext();
		context.addZuulRequestHeader("X-ZUUL-ACCESSKEY", accessKey);
		
		return null;
	}

	@Override
	public String filterType() {
		return ROUTE_TYPE;
	}

	@Override
	public int filterOrder() {
		return PRE_DECORATION_FILTER_ORDER - 1;
	}

}

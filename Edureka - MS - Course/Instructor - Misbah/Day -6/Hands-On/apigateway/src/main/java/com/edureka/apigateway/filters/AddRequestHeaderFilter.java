package com.edureka.apigateway.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import java.time.Instant;

public class AddRequestHeaderFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    } // post, error

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // can have custom condition
//        RequestContext.getCurrentContext();
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // add starttime to context as Instant.now in prefilter
        // and then calculate time in post filter
        System.out.println("*********************");
        System.out.println("*********************");
        System.out.println("***************** called the filter-run");
        RequestContext currentContext = RequestContext.getCurrentContext();
        currentContext.addZuulRequestHeader("x-location", "USA");
//        currentContext.addZuulRequestHeader("starttime", Instant.now().toString());
        return null;
    }
}

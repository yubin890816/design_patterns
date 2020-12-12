package com.yubin.design.chain_of_responsibility.extend_instance;

/**
 * 拦截器接口
 *
 * @author YUBIN
 * @create 2020-12-12
 */
public interface Filter {

    public void doFilter(Request request, Response response,FilterChain chain);
}

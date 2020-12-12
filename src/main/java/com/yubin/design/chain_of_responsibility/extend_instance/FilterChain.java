package com.yubin.design.chain_of_responsibility.extend_instance;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤器链
 *
 * @author YUBIN
 * @create 2020-12-12
 */
public class FilterChain {
    // 拦截器链
    private List<Filter> filters = new ArrayList<>();

    // 定义拦截器执行到拦截器链中的第几个
    private int index = 0;

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    public void doFilter(Request request, Response response) {
        if (index == filters.size()) {
            return;
        }
        Filter filter = filters.get(index);
        index++;
        filter.doFilter(request, response, this);
    }
}

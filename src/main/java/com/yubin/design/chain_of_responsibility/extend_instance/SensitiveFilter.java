package com.yubin.design.chain_of_responsibility.extend_instance;

/**
 * 过滤敏感词的过滤器
 *
 * @author YUBIN
 * @create 2020-12-12
 */
public class SensitiveFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.msg = request.msg.replaceAll("我操", "**") + "---SensitiveFilter()";
        chain.doFilter(request, response);
        response.msg += "---SensitiveFilter()";
    }
}
package com.yubin.design.chain_of_responsibility.extend_instance;

/**
 * 过滤html标签的过滤器
 *
 * @author YUBIN
 * @create 2020-12-12
 */
public class HtmlFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.msg = request.msg.replaceAll("<", "[").replaceAll(">", "]") + "---HtmlFilter()";
        chain.doFilter(request, response);
        response.msg += "---HtmlFilter()";
    }
}

package com.yubin.design.chain_of_responsibility.extend_instance;

/**
 * 客户端
 *
 * @author YUBIN
 * @create 2020-12-12
 */
public class Client {

    public static void main(String[] args) {
        FilterChain chain = new FilterChain();
        chain.add(new HtmlFilter()).add(new SensitiveFilter());
        Request request = new Request();
        request.msg = "<script>alert('我操! 这不是我心目中的女神么')</script>";
        Response response = new Response();
        response.msg = "response";
        chain.doFilter(request, response);
        System.out.println(request);
        System.out.println(response);
    }
}

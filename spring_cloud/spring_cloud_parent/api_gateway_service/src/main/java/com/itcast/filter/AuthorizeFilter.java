package com.itcast.filter;

import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

//自定义全局过滤器,用来鉴权token
@Component
public class AuthorizeFilter implements GlobalFilter ,Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //exchange参数代表上下文
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if (StringUtils.isBlank(token)){
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return  exchange.getResponse().setComplete();
        }
        //存在token,则放行
        return chain.filter(exchange);
    }

    //过滤器的执行顺序,返回数值越小,执行顺序越大
    @Override
    public int getOrder() {
        return 0;
    }
}

package com.pmo.app.pmoservice.config;

import com.google.common.base.Optional;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;

@Component
public class ConfigCorsFilter implements Filter{


    public ConfigCorsFilter(){}

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @SuppressWarnings("rawtypes")
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Authorization,Content-Type, Accept, X-Requested-With, remember-me");

        String auth = request.getHeader("authorization");

        System.out.println("PATH :" + request.getRequestURI());
        System.out.println("PATH :" + request.getRemoteAddr());
        System.out.println("PATH :" + request.getContextPath());


        Enumeration<String> headerNames = request.getHeaderNames();
        Collection<String> headerNamesRes = response.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.print("Header : " + headerName);
            String headerValue = request.getHeader(headerName);
            System.out.print(" (" + headerValue + ")\n");
        }

        System.out.println("RESPONSE :");
        for (String headerName : headerNamesRes) {
            System.out.print("Header : " + headerName);
            String headerValue = request.getHeader(headerName);
            System.out.print(" (" + headerValue + ")\n");
        }

        HttpSession session = request.getSession(false);
        if (session != null) {
            System.out.println("sess = " + session.getAttribute("TOKEN"));

            Enumeration<String> hh = session.getAttributeNames();
            while (hh.hasMoreElements()) {
                String headerName = hh.nextElement();
                System.out.print("Sess : " + headerName);
                String headerValue = session.getAttribute(headerName).toString();
                System.out.print(" (" + headerValue + ")\n");
            }
        }

        Optional username = Optional.fromNullable(request.getHeader("X-Auth-Username"));
        Optional password = Optional.fromNullable(request.getHeader("X-Auth-Password"));
        Optional token = Optional.fromNullable(request.getHeader("X-Auth-Token"));

        System.out.println("US:" + username);
        System.out.println("UpasswordS:" + password);
        System.out.println("token:" + token);

        if (auth == null) {
            chain.doFilter(req, response);
        } else {
            String[] arr = auth.split(" ");
            byte[] valueDecoded = Base64.decodeBase64(arr[1]);
            System.out.println("Decoded value is " + new String(valueDecoded));
            chain.doFilter(req, response);
        }
    }


    @Override
    public void destroy() {

    }
}

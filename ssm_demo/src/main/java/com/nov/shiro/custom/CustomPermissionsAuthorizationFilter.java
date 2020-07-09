package com.nov.shiro.custom;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;

public class CustomPermissionsAuthorizationFilter extends PermissionsAuthorizationFilter{
	
	public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {

        Subject subject = getSubject(request, response);
        String uri = WebUtils.getPathWithinApplication(WebUtils.toHttp(request));
        
        boolean isPermitted = false;
        if(subject.isPermitted(uri)) {
        	 isPermitted = true;
        }

        return isPermitted;
    }
}

/* 
 * Copyright (C) 2010 星星(wuweihua)<349446658@qq.com>
 * 
 * This file is part of Wabacus 
 * 
 * Wabacus is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.wabacusdemo.util;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.wabacus.config.Config;

public class SetCharacterEncodingFilter implements Filter
{
    private FilterConfig filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException
    {

        this.filterConfig = filterConfig;
    }
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
    {
        try
        {
            if(!Config.encode.equalsIgnoreCase("utf-8"))
            {//如果当前项目采用的不是UTF-8编码
                HttpServletRequest httpRequest=(HttpServletRequest)request;
                String contentType=httpRequest.getContentType();
                if (contentType != null
                        && contentType.toLowerCase().startsWith(
                                "application/x-www-form-urlencoded; charset=utf-8"))
                {//报表提交
                    request.setCharacterEncoding("UTF-8");
                }else
                {
                    request.setCharacterEncoding(Config.encode);
                }
                response.setContentType("text/html; charset="+Config.encode);
            }else
            {
                request.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;charset=UTF-8");
            }
            chain.doFilter(request,response);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void destroy()
    {
        this.filterConfig = null;
    }
}
package com.app.dao.dbservice;

import java.util.Date;
import java.util.List;

import com.app.dao.domain.BlogBO;

/**
 * 
 */
public interface BlogDAO
{
    public void addBlog(BlogBO bbo) throws Exception;
    public void updateBlog(BlogBO bbo) throws Exception;

    public List<BlogBO> findBlogByPublishedDateRange(BlogBO bbo, Date startDate, Date endDate) throws Exception;
    public List<BlogBO> findAllBlogs(BlogBO bbo) throws Exception;


}

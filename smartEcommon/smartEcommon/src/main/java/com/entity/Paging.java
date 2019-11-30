package com.entity;

import java.io.Serializable;

/**
 * @ClassName Paging
 * @Description TODO
 * @Author xizhonghuai
 * @Date 2019-04-30 11:46
 * @Version 1.0
 */
public class Paging implements Serializable {

    private Integer pageCount;
    private Integer pageIndex;
    private Integer pageNum;/*每页数*/

    public Paging() {
        this.pageIndex = 1;
        this.pageNum = 20;
    }

    public Paging(Integer pageCount, Integer pageIndex, Integer pageNum) {
        this.pageCount = pageCount;
        this.pageIndex = pageIndex;
        this.pageNum = pageNum;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "Paging{" +
                "pageCount=" + pageCount +
                ", pageIndex=" + pageIndex +
                ", pageNum=" + pageNum +
                '}';
    }
}

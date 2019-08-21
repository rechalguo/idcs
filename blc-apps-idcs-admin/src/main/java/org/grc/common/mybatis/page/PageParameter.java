package org.grc.common.mybatis.page;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageParameter implements Serializable {

    private static final long serialVersionUID = 587754556498974978L;
    
    public static final Integer PAGE_SIZE_DEFAULT = 5;
    
    //pagesize ，每一页显示多少
    private int limit = 5;
    //总页数
    private int totalPage;
    //总记录数
    private int totalRows;
    //当前页数
    private int page;
    //当前显示到的ID, 在mysql limit 中就是第一个参数.
    private int skip;
    
    private List<Object> rows = new ArrayList<>();
	private Map<String, Object> userdata = new HashMap<>();
	private boolean download=false;
    
    public PageParameter() {
    	this(PageParameter.PAGE_SIZE_DEFAULT);
    }
    
    public PageParameter(int pageSize) {
    	this(pageSize,1);
    }
    public PageParameter(int pageSize, int currentPage) {
    	if(pageSize<0) pageSize = 50;
    	if(currentPage<=0) currentPage = 1;
    	this.limit = pageSize;
    	this.page = currentPage;
    	this.skip = this.limit * (this.page-1);
    }
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
		resetPageInfo(PageResetID.PAGE_TOTAL);
	}
	public void setPage(int currentPage) {
		this.page = currentPage;
		resetPageInfo(PageResetID.PAGE_CUR);
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int pageSize) {
		this.limit = pageSize;
		resetPageInfo(PageResetID.PAGE_SIZE);
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
		resetPageInfo(PageResetID.TOTAL_ROWS);
	}
	public int getSkip() {
		return skip;
	}
	public List<Object> getRows() {
		return rows;
	}

	public Map<String, Object> getUserdata() {
		return userdata;
	}

	public boolean isDownload() {
		return download;
	}

	public void setDownload(boolean download) {
		this.download = download;
	}

	private void resetPageInfo(PageResetID id) {
		switch(id) {
		case TOTAL_ROWS:
			//this.totalPage=new Double(Math.ceil(this.totalRows*1.0/this.pageSize)).intValue();
		case PAGE_SIZE:
			this.totalPage=new Double(Math.ceil(this.totalRows*1.0/this.limit)).intValue();
			
			//if(this.currentPage>this.totalPage) this.currentPage=this.totalPage;
		case PAGE_TOTAL:
			if(this.totalPage>0&&this.page>this.totalPage) this.page=this.totalPage;
			//this.skip = this.pageSize * (this.currentPage-1);
			//this.skip = this.pageSize * (this.currentPage-1);
		case PAGE_CUR:
			//this.skip = this.pageSize * (this.currentPage-1);
		}
		this.skip = this.limit * (this.page-1);
	}
	
	private enum PageResetID{
		PAGE_TOTAL, PAGE_SIZE, PAGE_CUR, TOTAL_ROWS
	}
}

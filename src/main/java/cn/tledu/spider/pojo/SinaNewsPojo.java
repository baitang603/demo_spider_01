package cn.tledu.spider.pojo;

public class SinaNewsPojo {
	private String urlStr;
	private String title;
	private String dateStr;
	public SinaNewsPojo(String urlStr, String title, String dateStr) {
		super();
		this.urlStr = urlStr;
		this.title = title;
		this.dateStr = dateStr;
	}
	public String getUrlStr() {
		return urlStr;
	}
	public void setUrlStr(String urlStr) {
		this.urlStr = urlStr;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDateStr() {
		return dateStr;
	}
	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((urlStr == null) ? 0 : urlStr.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinaNewsPojo other = (SinaNewsPojo) obj;
		if (urlStr == null) {
			if (other.urlStr != null)
				return false;
		} else if (!urlStr.equals(other.urlStr))
			return false;
		return true;
	}
}

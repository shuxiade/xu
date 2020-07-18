package com.nov.entity;

import java.util.Date;

public class Perm {
	
	private Integer id;
	private String permName;
	private String permCode;
	private String permUrl;
	private Integer disabled = 0;
	private String createBy;
	private Date createTime = new Date();
	private String updateBy;
	private Date updateTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPermName() {
		return permName;
	}
	public void setPermName(String permName) {
		this.permName = permName;
	}
	public String getPermCode() {
		return permCode;
	}
	public void setPermCode(String permCode) {
		this.permCode = permCode;
	}
	public String getPermUrl() {
		return permUrl;
	}
	public void setPermUrl(String permUrl) {
		this.permUrl = permUrl;
	}
	public Integer getDisabled() {
		return disabled;
	}
	public void setDisabled(Integer disabled) {
		this.disabled = disabled;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createBy == null) ? 0 : createBy.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((disabled == null) ? 0 : disabled.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((permCode == null) ? 0 : permCode.hashCode());
		result = prime * result + ((permName == null) ? 0 : permName.hashCode());
		result = prime * result + ((permUrl == null) ? 0 : permUrl.hashCode());
		result = prime * result + ((updateBy == null) ? 0 : updateBy.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
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
		Perm other = (Perm) obj;
		if (createBy == null) {
			if (other.createBy != null)
				return false;
		} else if (!createBy.equals(other.createBy))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (disabled == null) {
			if (other.disabled != null)
				return false;
		} else if (!disabled.equals(other.disabled))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (permCode == null) {
			if (other.permCode != null)
				return false;
		} else if (!permCode.equals(other.permCode))
			return false;
		if (permName == null) {
			if (other.permName != null)
				return false;
		} else if (!permName.equals(other.permName))
			return false;
		if (permUrl == null) {
			if (other.permUrl != null)
				return false;
		} else if (!permUrl.equals(other.permUrl))
			return false;
		if (updateBy == null) {
			if (other.updateBy != null)
				return false;
		} else if (!updateBy.equals(other.updateBy))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Perm [id=");
		builder.append(id);
		builder.append(", permName=");
		builder.append(permName);
		builder.append(", permCode=");
		builder.append(permCode);
		builder.append(", permUrl=");
		builder.append(permUrl);
		builder.append(", disabled=");
		builder.append(disabled);
		builder.append(", createBy=");
		builder.append(createBy);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", updateBy=");
		builder.append(updateBy);
		builder.append(", updateTime=");
		builder.append(updateTime);
		builder.append("]");
		return builder.toString();
	}
}

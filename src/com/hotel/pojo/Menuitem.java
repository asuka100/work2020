package com.hotel.pojo;

public class Menuitem {
    private Integer id;

    private Integer positionId;

    private String menuitem;

    private String parent;

    private String urllink;

    private String success;

    private String descript;

    @Override
	public String toString() {
		return "Menuitem [id=" + id + ", positionId=" + positionId + ", menuitem=" + menuitem + ", parent=" + parent
				+ ", urllink=" + urllink + ", success=" + success + ", descript=" + descript + "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getMenuitem() {
        return menuitem;
    }

    public void setMenuitem(String menuitem) {
        this.menuitem = menuitem == null ? null : menuitem.trim();
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent == null ? null : parent.trim();
    }

    public String getUrllink() {
        return urllink;
    }

    public void setUrllink(String urllink) {
        this.urllink = urllink == null ? null : urllink.trim();
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success == null ? null : success.trim();
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript == null ? null : descript.trim();
    }
}
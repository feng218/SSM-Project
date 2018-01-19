package cn.itcast.core.bean.user;

import java.io.Serializable;

public class Addr implements Serializable {
    /**
     * ID
     */
    private Long id;

    /**
     * 用户ID
     */
    private String buyerId;

    /**
     * 收货人
     */
    private String name;

    /**
     * 所在城市
     */
    private String city;

    /**
     * 收货地址
     */
    private String addr;

    /**
     * 手机号或是固定电话号
     */
    private String phone;

    /**
     * 是否默认
     */
    private Boolean isDef;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId == null ? null : buyerId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Boolean getIsDef() {
        return isDef;
    }

    public void setIsDef(Boolean isDef) {
        this.isDef = isDef;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", buyerId=").append(buyerId);
        sb.append(", name=").append(name);
        sb.append(", city=").append(city);
        sb.append(", addr=").append(addr);
        sb.append(", phone=").append(phone);
        sb.append(", isDef=").append(isDef);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
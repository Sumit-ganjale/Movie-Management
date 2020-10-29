package com.fynd.movie.management.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name="USER_MASTER")
	public class USER_MASTER
	  implements Serializable
	{
	  private static final long serialVersionUID = -1L;

	  @Id
	  @Column(name="USER_ID")
	  public BigDecimal USER_ID;

	  @Column(name="DISPLAY_USER_ID")
	  public String DISPLAY_USER_ID;

	  @Column(name="HOMEPAGE_FUNCTION_ID")
	  public String HOMEPAGE_FUNCTION_ID;

	  @Column(name="MODIFIED_BY")
	  public BigDecimal MODIFIED_BY;


	  public void setPrimaryKeys(Object[] paramArrayOfObject)
	    throws Exception
	  {
	    this.USER_ID = ((BigDecimal)paramArrayOfObject[0]);
	  }

	  public BigDecimal getUSER_ID()
	  {
	    return this.USER_ID;
	  }

	  public void setUSER_ID(BigDecimal paramBigDecimal)
	  {
	    this.USER_ID = paramBigDecimal;
	  }

	  public String getDISPLAY_USER_ID()
	  {
	    return this.DISPLAY_USER_ID;
	  }

	  public void setDISPLAY_USER_ID(String paramString)
	  {
	    this.DISPLAY_USER_ID = paramString;
	  }

	  public String getHOMEPAGE_FUNCTION_ID()
	  {
	    return this.HOMEPAGE_FUNCTION_ID;
	  }

	  public void setHOMEPAGE_FUNCTION_ID(String paramString)
	  {
	    this.HOMEPAGE_FUNCTION_ID = paramString;
	  }

	  public BigDecimal getMODIFIED_BY()
	  {
	    return this.MODIFIED_BY;
	  }

	  public void setMODIFIED_BY(BigDecimal paramBigDecimal)
	  {
	    this.MODIFIED_BY = paramBigDecimal;
	  }
	}


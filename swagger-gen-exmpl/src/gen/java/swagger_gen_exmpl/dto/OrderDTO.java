package swagger_gen_exmpl.dto;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.NotNull;





@ApiModel(description = "")
public class OrderDTO  {
  
  
  
  private Long id = null;
  
  
  private Long petId = null;
  
  
  private Integer quantity = null;
  
  
  private javax.xml.datatype.XMLGregorianCalendar shipDate = null;
  
  public enum StatusEnum {
     placed,  approved,  delivered, 
  };
  
  private StatusEnum status = null;
  
  
  private Boolean complete = false;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("id")
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("petId")
  public Long getPetId() {
    return petId;
  }
  public void setPetId(Long petId) {
    this.petId = petId;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("quantity")
  public Integer getQuantity() {
    return quantity;
  }
  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("shipDate")
  public javax.xml.datatype.XMLGregorianCalendar getShipDate() {
    return shipDate;
  }
  public void setShipDate(javax.xml.datatype.XMLGregorianCalendar shipDate) {
    this.shipDate = shipDate;
  }

  
  /**
   * Order Status
   **/
  @ApiModelProperty(value = "Order Status")
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }
  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("complete")
  public Boolean getComplete() {
    return complete;
  }
  public void setComplete(Boolean complete) {
    this.complete = complete;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderDTO {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  petId: ").append(petId).append("\n");
    sb.append("  quantity: ").append(quantity).append("\n");
    sb.append("  shipDate: ").append(shipDate).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  complete: ").append(complete).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

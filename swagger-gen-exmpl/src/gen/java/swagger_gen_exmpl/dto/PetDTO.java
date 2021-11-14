package swagger_gen_exmpl.dto;

import java.util.ArrayList;
import java.util.List;
import swagger_gen_exmpl.dto.CategoryDTO;
import swagger_gen_exmpl.dto.TagDTO;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.NotNull;





@ApiModel(description = "")
public class PetDTO  {
  
  
  
  private Long id = null;
  
  
  private CategoryDTO category = null;
  
  @NotNull
  private String name = null;
  
  @NotNull
  private List<String> photoUrls = new ArrayList<String>();
  
  
  private List<TagDTO> tags = new ArrayList<TagDTO>();
  
  public enum StatusEnum {
     available,  pending,  sold, 
  };
  
  private StatusEnum status = null;

  
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
  @JsonProperty("category")
  public CategoryDTO getCategory() {
    return category;
  }
  public void setCategory(CategoryDTO category) {
    this.category = category;
  }

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("photoUrls")
  public List<String> getPhotoUrls() {
    return photoUrls;
  }
  public void setPhotoUrls(List<String> photoUrls) {
    this.photoUrls = photoUrls;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("tags")
  public List<TagDTO> getTags() {
    return tags;
  }
  public void setTags(List<TagDTO> tags) {
    this.tags = tags;
  }

  
  /**
   * pet status in the store
   **/
  @ApiModelProperty(value = "pet status in the store")
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }
  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class PetDTO {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  category: ").append(category).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  photoUrls: ").append(photoUrls).append("\n");
    sb.append("  tags: ").append(tags).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
